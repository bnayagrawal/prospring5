package dev.bnayagrawal.prospring5.chapter6.springjdbc2;

import dev.bnayagrawal.prospring5.chapter6.common.Album;
import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class AnnotationJdbcTest {

    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        // Not for testing!
        listSingers(singers);
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> singers = singerDao.findByFirstName("John");
        assertEquals(2, singers.size());
        // Not for testing!
        listSingers(singers);
    }

    @Test
    public void testSingerUpdate() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(new GregorianCalendar(1997, 9, 16).getTime().getTime()));
        singerDao.update(singer);
        // Assert if singer with id 1 is has firstName "John Clayton"!
        // Not for testing!
        listSingers(singerDao.findAll());
    }

    @Test
    public void testSingerInsert() {
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date(new GregorianCalendar(1991, 1, 17).getTime().getTime()));
        singerDao.insert(singer);
        // Assert if singer with firstName "Ed" is created!
        // Not for testing!
        listSingers(singerDao.findAll());
    }

    @Test
    public void testSingerInsertWithAlbum() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(new GregorianCalendar(1940, 8, 16).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My King of Blues");
        album.setReleaseDate(new Date(new GregorianCalendar(1961, 7, 18).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(new GregorianCalendar(1962, 3, 20).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.insertWithAlbum(singer);
        // Assertion logic missing
        // Not for testing!
        listSingers(singerDao.findAll());
    }

    @Test
    public void testFindFirstNameById() {
        String firstName = singerDao.findFirstNameById(2L);
        assertEquals("Eric", firstName);
        System.out.println("Retrieved value: " + firstName);
    }

    private void listSingers(List<Singer> singers) {
        singers.forEach(singer -> {
            System.out.println(singer);
            if(singer.getAlbums() != null) {
                for(Album album: singer.getAlbums()) {
                    System.out.println("\t-->" + album);
                }
            }
        });
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
