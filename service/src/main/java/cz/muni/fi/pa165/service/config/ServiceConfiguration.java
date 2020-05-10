package cz.muni.fi.pa165.service.config;

import cz.muni.fi.pa165.PersistenceApplicationContext;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceApplicationContext.class)
public class ServiceConfiguration {

    @Bean
    public Mapper dozer() {
        return new DozerBeanMapper();
    }

}
