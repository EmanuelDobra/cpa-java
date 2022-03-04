package data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.entities.City;

public class CityDao {
    Connection connection;

    public CityDao(Connection connection) {
        this.connection = connection;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<City>(); 

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM city");
            // Iterate through results
            while (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }       
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }

    public void insert (City city) {
        try (Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO city VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, city.getName());
            ps.setString(3, city.getCountryCode());
            ps.setString(4, city.getDistrict());
            ps.setInt(5, city.getPopulation());
            int rows = ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            // Move on to the first item
            if (keys.next()) {
                //System.out.println(keys.getInt(1));
                city.setID(keys.getInt(1));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
