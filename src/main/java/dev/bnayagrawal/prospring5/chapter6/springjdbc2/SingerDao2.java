package dev.bnayagrawal.prospring5.chapter6.springjdbc2;

import dev.bnayagrawal.prospring5.chapter6.common.Album;
import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import dev.bnayagrawal.prospring5.chapter6.springjdbc2.ops.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository("singerDao")
public class SingerDao2 implements SingerDao {

    private static final Logger logger = Logger.getLogger(SingerDao2.class.getName());

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private SelectAllSingers selectAllSingers;
    private SelectSingerByFirstName selectSingerByFirstName;
    private UpdateSinger updateSinger;
    private InsertSinger insertSinger;
    private InsertSingerAlbum insertSingerAlbum;
    private StoredFunctionFirstNameById storedFunctionFirstNameById;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.selectAllSingers = new SelectAllSingers(dataSource);
        this.selectSingerByFirstName = new SelectSingerByFirstName(dataSource);
        this.updateSinger = new UpdateSinger(dataSource);
        this.insertSinger = new InsertSinger(dataSource);
        this.insertSingerAlbum = new InsertSingerAlbum(dataSource);
        this.storedFunctionFirstNameById = new StoredFunctionFirstNameById(dataSource);
    }

    DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public List<Singer> findAll() {
        return selectAllSingers.execute();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return selectSingerByFirstName.executeByNamedParam(Map.of("first_name", firstName));
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        List<String> result = storedFunctionFirstNameById.execute(id);
        return result.get(0);
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertSinger.updateByNamedParam(paramMap, keyHolder);
        singer.setId(keyHolder.getKey().longValue());
        logger.info("New singer inserted with id: " + singer.getId());
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", singer.getFirstName());
        paramMap.put("last_name", singer.getLastName());
        paramMap.put("birth_date", singer.getBirthDate());
        paramMap.put("id", singer.getId());
        updateSinger.updateByNamedParam(paramMap);
        logger.info("Existing singer updated with id: " + singer.getId());
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        insert(singer);
        List<Album> albums = singer.getAlbums();
        if(null != albums) {
            for(Album album: albums) {
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("singer_id", singer.getId());
                paramMap.put("title", album.getTitle());
                paramMap.put("release_date", album.getReleaseDate());
                insertSingerAlbum.updateByNamedParam(paramMap);
            }
            insertSingerAlbum.flush();
        }
    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

    @Override
    public List<Singer> findAllWithAlbums() {
        String sql = "SELECT s.id, s.first_name, s.last_name, s.birth_date,"
                + " a.id AS a.album_id, a.title, a.release_date FROM singer s"
                + " LEFT JOIN album a ON s.id = a.singer_id";
        return jdbcTemplate.query(sql, resultSet -> {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                singer = map.get(id);
                if(singer == null) {
                    singer = new Singer();
                    singer.setId(resultSet.getLong("id"));
                    singer.setFirstName(resultSet.getString("first_name"));
                    singer.setLastName(resultSet.getString("last_name"));
                    singer.setBirthDate(resultSet.getDate("birth_date"));
                    singer.setAlbums(new ArrayList<>());
                    map.put(id, singer);
                }
                Long albumId = resultSet.getLong("singer_tel_id");
                if(albumId > 0) {
                    Album album = new Album();
                    album.setId(albumId);
                    album.setSingerId(id);
                    album.setTitle(resultSet.getString("title"));
                    album.setReleaseDate(resultSet.getDate("release_date"));
                    singer.addAlbum(album);
                }
            }
            return new ArrayList<>(map.values());
        });
    }
}
