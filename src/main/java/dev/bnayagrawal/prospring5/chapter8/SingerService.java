package dev.bnayagrawal.prospring5.chapter8;

import dev.bnayagrawal.prospring5.chapter7.entity.Singer;

import java.util.List;

public interface SingerService {

    List<Singer> findAll();
    List<Singer> findAllWithAlbums();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
    List<Singer> findAllByNativeQuery();
}
