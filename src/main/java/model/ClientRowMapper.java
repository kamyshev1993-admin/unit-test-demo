package model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("ID"));
        client.setFirstName(rs.getString("FIRST_NAME"));
        client.setMiddleName(rs.getString("MIDDLE_NAME"));
        client.setLastName(rs.getString("LAST_NAME"));
        return client;
    }
}
