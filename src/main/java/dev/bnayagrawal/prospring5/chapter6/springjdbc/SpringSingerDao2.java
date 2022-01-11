package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.Album;
import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringSingerDao2 implements SingerDao, InitializingBean {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SpringSingerDao2(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        String sql = "select id, first_name, last_name, birth_date from singer";
        return namedParameterJdbcTemplate.query(sql, new SingerMapper());
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "SELECT first_name FROM singer WHERE id = :singerId",
                Map.of("singerId", id),
                String.class
        );
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

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
        return namedParameterJdbcTemplate.query(sql, new SingerWithDetailExtractor());
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(null == namedParameterJdbcTemplate) {
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on SingerDao");
        }
    }

    private static final class SingerMapper implements RowMapper<Singer> {

        @Override
        public Singer mapRow(ResultSet resultSet, int i) throws SQLException {
            Singer singer = new Singer();
            singer.setId(resultSet.getLong("id"));
            singer.setFirstName(resultSet.getString("first_name"));
            singer.setLastName(resultSet.getString("last_name"));
            singer.setBirthDate(resultSet.getDate("birth_date"));
            return singer;
        }
    }

    private static final class SingerWithDetailExtractor implements ResultSetExtractor<List<Singer>> {

        @Override
        public List<Singer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
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
        }
    }
}
