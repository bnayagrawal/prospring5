package dev.bnayagrawal.prospring5.chapter6.springjdbc2;

import dev.bnayagrawal.prospring5.chapter6.datasource.DbConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

@ComponentScan(basePackages = "dev.bnayagrawal.prospring5.chapter6.springjdbc2")
public class AppConfig extends DbConfig {

    private static Logger logger = Logger.getLogger(AppConfig.class.getName());

    @Override
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "DBCP DataSource bean cannot be created!", e);
            return null;
        }
    }
}
