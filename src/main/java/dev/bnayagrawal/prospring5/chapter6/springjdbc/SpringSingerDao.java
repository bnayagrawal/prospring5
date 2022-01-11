package dev.bnayagrawal.prospring5.chapter6.springjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringSingerDao implements SingerDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    public SpringSingerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        return null;
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
        return jdbcTemplate.queryForObject(
                "select first_name from singer where id = ?", new Object[]{id}, String.class);
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
        return null;
    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
