package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import dev.bnayagrawal.prospring5.chapter6.datasource.EmbeddedJdbcConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class Configuration2 extends EmbeddedJdbcConfig {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public SingerDao singerDao() {
        return new SpringSingerDao2(namedParameterJdbcTemplate());
    }
}
