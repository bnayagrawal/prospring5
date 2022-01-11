package dev.bnayagrawal.prospring5.chapter7.service;

import dev.bnayagrawal.prospring5.chapter7.entity.Album;
import dev.bnayagrawal.prospring5.chapter7.entity.Instrument;
import dev.bnayagrawal.prospring5.chapter7.entity.Singer;
import dev.bnayagrawal.prospring5.chapter7.repository.InstrumentDao;
import dev.bnayagrawal.prospring5.chapter7.repository.SingerDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

@Service
public class DBInitializer {

    private static final Logger logger = Logger.getLogger(DBInitializer.class.getName());

    private final SingerDao singerDao;
    private final InstrumentDao instrumentDao;

    public DBInitializer(SingerDao singerDao, InstrumentDao instrumentDao) {
        this.singerDao = singerDao;
        this.instrumentDao = instrumentDao;
    }

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");

        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        instrumentDao.save(guitar);

        Instrument piano = new Instrument();
        guitar.setInstrumentId("Piano");
        instrumentDao.save(piano);

        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date((new GregorianCalendar(1997, 9, 16)).getTime().getTime()));
        singer.addInstrument(guitar);
        singer.addInstrument(piano);

        Album album1 = new Album();
        album1.setTitle("The Search For Everything");
        album1.setReleaseDate(new Date((new GregorianCalendar(2017, 0, 20)).getTime().getTime()));
        singer.addAlbum(album1);

        Album album2 = new Album();
        album1.setTitle("Battle Studies");
        album1.setReleaseDate(new Date((new GregorianCalendar(2009, 10, 17)).getTime().getTime()));
        singer.addAlbum(album2);

        singerDao.save(singer);

        logger.info("Database initialization finished.");
    }
}
