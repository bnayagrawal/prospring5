package dev.bnayagrawal.prospring5.chapter7.repository;

import dev.bnayagrawal.prospring5.chapter7.entity.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();
    List<Singer> findAllWithAlbums();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);

}
