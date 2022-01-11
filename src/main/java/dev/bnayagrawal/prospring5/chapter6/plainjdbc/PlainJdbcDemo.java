package dev.bnayagrawal.prospring5.chapter6.plainjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

public class PlainJdbcDemo {

    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = Logger.getLogger(PlainJdbcDemo.class.getName());

    public static void main(String[] args) {
        logger.info("Listing initial singer data:");
        listAllSingers();

        logger.info("------------");
        logger.info("Insert a new singer");

        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date((new GregorianCalendar(1991, 2, 1991)).getTime().getTime()));
        ////////// INSERT ///////////
        singerDao.insert(singer);

        logger.info("Listing singer data after new singer created:");
        listAllSingers();

        logger.info("------------");
        logger.info("Deleting the previously created singer");

        singerDao.delete(singer.getId());

        logger.info("Listing singer data after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();

        for(Singer singer: singers) {
            logger.info(singer.toString());
        }
    }
}
