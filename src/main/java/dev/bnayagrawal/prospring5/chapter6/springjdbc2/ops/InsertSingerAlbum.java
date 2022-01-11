package dev.bnayagrawal.prospring5.chapter6.springjdbc2.ops;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertSingerAlbum extends BatchSqlUpdate {

    private static final String SQL_INSERT_SINGER_ALBUM =
            "INSERT INTO album (singer_id, title, release_date)" +
                    "VALUES (:singer_id, :title, :release_date)";

    private static final int BATCH_SIZE = 10;

    public InsertSingerAlbum(DataSource dataSource) {
        super(dataSource, SQL_INSERT_SINGER_ALBUM);
        super.declareParameter(new SqlParameter("singer_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("release_date", Types.DATE));
        setBatchSize(BATCH_SIZE);
    }
}
