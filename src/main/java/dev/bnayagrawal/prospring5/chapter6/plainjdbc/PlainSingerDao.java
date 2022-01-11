package dev.bnayagrawal.prospring5.chapter6.plainjdbc;

import dev.bnayagrawal.prospring5.chapter6.common.Singer;
import dev.bnayagrawal.prospring5.chapter6.common.SingerDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PlainSingerDao implements SingerDao {

    private static Logger logger = Logger.getLogger(PlainSingerDao.class.getName());

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Problem loading DB driver!", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/musicdb?user=postgres&password=admin");
    }

    private void closeConnection(Connection connection) {
        if(null == connection) return;
        try {
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Problem closing connection to the database!", e);
        }
    }

    /*\\REPO//***************
    * Repository methods
    **\\REPO//**************/

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("select * from singer")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Problem when executing SELECT!", exception);
        }
        return result;
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
        return null;
    }

    @Override
    public void insert(Singer singer) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO singer (first_name, last_name, birth_date) " +
                    "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                ///////////////////
                singer.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Problem when executing INSERT!", exception);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM singer WHERE id=?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            logger.log(Level.SEVERE, "Problem when executing DELETE!", exception);
        }
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
}
