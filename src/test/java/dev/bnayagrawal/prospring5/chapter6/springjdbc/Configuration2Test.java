package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.Album;
import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

@RunWith(JUnit4.class)
public class Configuration2Test extends TestCase {

    private GenericApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(Configuration2.class);
    }

    @After
    public void teardown() {
        context.close();
    }

    @Test
    public void testH2DB() {
        SingerDao singerDao = context.getBean(SingerDao.class);
        assertNotNull(singerDao);
        String firstName = singerDao.findFirstNameById(1L);
        assertTrue("John".equals(firstName));
    }

    @Test
    public void testRowMapper() {
        SingerDao singerDao = context.getBean(SingerDao.class);
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());

        singers.forEach(singer -> {
            System.out.println(singer);
            if(singer.getAlbums() != null) {
                for(Album album: singer.getAlbums()) {
                    System.out.println("---" + album);
                }
            }
        });
    }

    @Test
    public void testResultSetExtractor() {
        SingerDao singerDao = context.getBean(SingerDao.class);
        List<Singer> singers = singerDao.findAllWithAlbums();
        assertEquals(3, singers.size());
        // Not for testing!
        singers.forEach(singer -> {
            System.out.println(singer);
            if(singer.getAlbums() != null) {
                for(Album album: singer.getAlbums()) {
                    System.out.println("\t-->" + album);
                }
            }
        });
    }
}