package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import dev.bnayagrawal.prospring5.chapter6.datasource.EmbeddedJdbcConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration extends EmbeddedJdbcConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao() {
        SpringSingerDao singerDao = new SpringSingerDao(jdbcTemplate());
        return singerDao;
    }
}
