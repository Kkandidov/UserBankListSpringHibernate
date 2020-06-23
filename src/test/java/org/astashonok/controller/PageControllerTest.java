package org.astashonok.controller;

import org.astashonok.model.Account;
import org.astashonok.model.User;
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
public class PageControllerTest {

    @Autowired
    private PageController pageController;

    @Test
    public void getAllAccounts() {
        Account[] expected = new Account[]{
                new Account(1, 4000, 1), new Account(2, 2000, 2),
                new Account(3, 3000, 3), new Account(4, 5000, 4),
                new Account(5, 1000, 5), new Account(6, 9000, 6),
                new Account(7, 6000, 7), new Account(8, 8000, 8),
                new Account(9, 7000, 9), new Account(10, 9000, 10)
        };
        assertArrayEquals(expected, pageController.getAllAccounts().toArray());
    }

    @Test
    public void getUserById() {
        User expected = new User(3, "Дмитрий", "Дмитриев");
        User actual = pageController.getUserById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getRichestUsers() {
        User [] expected = new User[]{
                new User (6, "Кирилл", "Кириллов"),
                new User (10, "Родион", "Родионов")
        };
        List<User> actual = pageController.getRichestUsers();
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void getAccountsSum() {
        double expected = 54000;
        double actual = pageController.getAccountsSum();
        assertEquals(expected, actual, 0.0);
    }
}