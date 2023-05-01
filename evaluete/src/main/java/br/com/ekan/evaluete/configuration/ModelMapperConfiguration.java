package br.com.ekan.evaluete.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfiguration {
    @Bean
    @Autowired(required = false)
    public ModelMapper modelMapper(List<TypeMapConfiguration> configurations) {
        var mapper = new ModelMapper();
        mapper.getConfiguration()
                .addValueReader(new RecordValueReader())
                .setMatchingStrategy(MatchingStrategies.STRICT);
        configurations.forEach(c -> c.configure(mapper));
        return mapper;
    }

}
