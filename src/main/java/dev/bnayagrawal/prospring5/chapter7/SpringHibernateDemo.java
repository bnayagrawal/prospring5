package dev.bnayagrawal.prospring5.chapter7;

import dev.bnayagrawal.prospring5.chapter7.config.AppConfig;
import dev.bnayagrawal.prospring5.chapter7.entity.Album;
import dev.bnayagrawal.prospring5.chapter7.entity.Instrument;
import dev.bnayagrawal.prospring5.chapter7.entity.Singer;
import dev.bnayagrawal.prospring5.chapter7.repository.SingerDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class SpringHibernateDemo {

    private static Logger logger = Logger.getLogger(SpringHibernateDemo.class.getName());

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        listSingersWithAlbum(singerDao.findAll());

        ctx.close();
    }

    private static void listSingers(List<Singer> singers) {
        logger.info(" --- Listing singers:");
        singers.stream().map(Object::toString).forEach(logger::info);
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" --- Listing singers with instruments: ");
        for(Singer singer: singers) {
            logger.info(singer.toString());
            if(singer.getAlbums() != null) {
                for (Album album: singer.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }
            if(singer.getInstruments() != null) {
                for(Instrument instrument: singer.getInstruments()) {
                    logger.info("\t" + instrument.getInstrumentId());
                }
            }
        }
    }
}
