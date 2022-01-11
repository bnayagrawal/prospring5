package dev.bnayagrawal.prospring5.chapter6.datasource;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConfigTest extends TestCase {

    private static Logger logger = Logger.getLogger(DbConfigTest.class.getName());

    @Test
    public void testOne() throws SQLException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:chapter6/drivermanager-cfg-01.xml");
        ctx.refresh();
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    @Test
    public void testTwo() throws SQLException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    private void testDataSource(DataSource dataSource) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int mockVal = resultSet.getInt("1");
                assertTrue(mockVal == 1);
            }
            statement.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Something unexpected happened.", e);
        } finally {
            if(null != connection) {
                connection.close();
            }
        }

    }
}