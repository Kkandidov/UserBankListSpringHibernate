package org.astashonok.service.impl;

import org.astashonok.exception.EntityNotFoundException;
import org.astashonok.model.User;
import org.astashonok.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/populatetestdb.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void add() {
        User expected = new User();
        expected.setName("Konstantin");
        expected.setSurname("Konstantinov");
        User actual = userService.add(expected);
        assertEquals(expected, actual);
    }

    @Test (expected = EntityNotFoundException.class)
    public void delete() throws EntityNotFoundException {
        userService.delete(5);
        userService.getById(5);
    }

    @Test
    public void getById() throws EntityNotFoundException {
        User expected = new User(3, "Дмитрий", "Дмитриев");
        User actual = userService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void edit() throws EntityNotFoundException {
        User expected = new User(3, "Дмитрий", "Дмитриев");
        userService.edit(expected);
        User actual = userService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        int expected = 10;
        int actual = userService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void getRichestUsers() {
        User [] expected = new User[]{
                new User (6, "Кирилл", "Кириллов"),
                new User (10, "Родион", "Родионов")
        };
        List<User> actual = userService.getRichestUsers();
        assertArrayEquals(expected, actual.toArray());
    }
}