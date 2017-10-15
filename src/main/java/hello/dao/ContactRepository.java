package hello.dao;

import hello.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {
    @Autowired
    private
    JdbcTemplate jdbcTemplate;
    public List<Contacts> findAll(){

        List<Contacts> result = jdbcTemplate.query("SELECT id, name FROM contacts",
                (rs, rowNum) -> new Contacts(rs.getBigDecimal("id").toBigIntegerExact(), rs.getString("name"))
        );


        return result;
    }


}
