import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import data.Database;
import data.daos.CityDao;
import data.entities.City;

public class App {
    public static void main(String[] args) {
        try (Connection connection = Database.getDatabaseConnection()) {
            CityDao cityDao = new CityDao(connection);

            City city = new City();
            city.setCountryCode("CAN");
            city.setDistrict("ON");
            city.setID(null);
            city.setName("Kingston");
            city.setPopulation(120000);
            cityDao.insert(city);

            List<City> cities= cityDao.findAll();
            for (City myCity : cities) {
                System.out.println(myCity);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
