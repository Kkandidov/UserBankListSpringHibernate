package org.astashonok.service.impl;

import org.astashonok.exception.EntityNotFoundException;
import org.astashonok.model.Account;
import org.astashonok.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/populatetestdb.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void add() {
        Account expected = new Account();
        expected.setAccount(6500);
        expected.setUserId(10);
        Account actual = accountService.add(expected);
        assertEquals(expected, actual);
    }

    @Test (expected = EntityNotFoundException.class)
    public void delete() throws EntityNotFoundException {
        accountService.delete(5);
        accountService.getById(5);
    }

    @Test
    public void getById() throws EntityNotFoundException {
        Account expected = new Account(3, 3000, 3);
        Account actual = accountService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void edit() throws EntityNotFoundException {
        Account expected = new Account(3, 4000, 3);
        accountService.edit(expected);
        Account actual = accountService.getById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        int expected = 10;
        int actual = accountService.getAll().size();
        assertEquals(expected, actual);
    }

    @Test
    public void getAccountsSum() {
        double expected = 54000;
        double actual = accountService.getAccountsSum();
        assertEquals(expected, actual, 0.0);
    }
}