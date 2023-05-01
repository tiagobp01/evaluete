package br.com.ekan.evaluete.configuration;

import org.modelmapper.internal.Errors;
import org.modelmapper.spi.ValueReader;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;


public class RecordValueReader implements ValueReader<Record> {
    @Override
    public Object get(Record record, String memberName) {
        var field = matchField(record, memberName);
        if (field == null) {
            return null;
        }

        try {
            return field.get(record);
        } catch (IllegalAccessException e) {
            throw new Errors().addMessage(e, "Cannot get the member").toMappingException();
        }
    }

    @Override
    public Member<Record> getMember(Record record, String memberName) {
        var field = matchField(record, memberName);
        var type = field != null ? field.getClass() : Record.class;
        return new Member<>(type) {
            @Override
            public Object get(Record source, String memberName) {
                return RecordValueReader.this.get(source, memberName);
            }
        };
    }

    @Override
    public Collection<String> memberNames(Record record) {
        var fields = record.getClass().getDeclaredFields();
        var memberNames = new ArrayList<String>(fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            memberNames.add(field.getName());
        }
        return memberNames;
    }

    private Field matchField(Record source, String memberName) {
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (memberName.equalsIgnoreCase(field.getName()))
                return field;
        }
        return null;
    }

}