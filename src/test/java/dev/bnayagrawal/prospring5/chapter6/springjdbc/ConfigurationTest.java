package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ConfigurationTest extends TestCase {

    @Test
    public void testH2DB() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
        testDao(context.getBean(SingerDao.class));
        context.close();
    }

    private void testDao(SingerDao singerDao) {
        assertNotNull(singerDao);
        String firstName = singerDao.findFirstNameById(1L);
        assertTrue("John".equals(firstName));
    }
}