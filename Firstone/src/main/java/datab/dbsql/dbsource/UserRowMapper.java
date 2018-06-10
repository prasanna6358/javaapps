package datab.dbsql.dbsource;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("Name"));
        user.setPassword(resultSet.getString("Password"));
        user.setEmail(resultSet.getString("Email"));
        user.setCountry(resultSet.getString("Country"));
        return user;
    }
}
