package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Client findById(long id) {
        String sql = "SELECT * FROM CLIENT where id = ?";
        return jdbcTemplate.queryForObject(sql, new ClientRowMapper(), id);
    }
}
