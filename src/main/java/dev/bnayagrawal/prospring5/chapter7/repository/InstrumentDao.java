package dev.bnayagrawal.prospring5.chapter7.repository;

import dev.bnayagrawal.prospring5.chapter7.entity.Instrument;

public interface InstrumentDao {

    Instrument save(Instrument instrument);
}
