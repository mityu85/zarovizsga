package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DogTypes {

    private MariaDbDataSource dataSource;

    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogTypes = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "select name from dog_types where country like ?")
                ) {
            ps.setString(1, country.toUpperCase());

            return getDogTypesListByPreparedStatement(dogTypes, ps);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect", e);
        }
    }

    private List<String> getDogTypesListByPreparedStatement(List<String> dogTypes, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dogTypes.add(rs.getString("name").toLowerCase());
            }
            Collections.sort(dogTypes);
            return dogTypes;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot query", e);
        }
    }
}
