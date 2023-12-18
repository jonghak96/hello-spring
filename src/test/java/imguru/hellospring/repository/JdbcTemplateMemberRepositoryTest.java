package imguru.hellospring.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

class JdbcTemplateMemberRepositoryTest {
    DataSource dataSource;

    JdbcTemplateMemberRepository repository = new JdbcTemplateMemberRepository(dataSource);

    @Test
    void save() {


    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }
}