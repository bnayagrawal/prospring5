package dev.bnayagrawal.prospring5.chapter6.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class EmbeddedJdbcConfig {

    private static Logger logger = Logger.getLogger(EmbeddedJdbcConfig.class.getName());

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:chapter6/schema.sql", "classpath:chapter6/test-data.sql").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Embedded DataSource bean can not be created!", e);
            return null;
        }
    }
}
