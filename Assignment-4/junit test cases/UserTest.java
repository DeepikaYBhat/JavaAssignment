package com.Assignment3.CRUD.Example;

import com.Assignment3.CRUD.Example.entity.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setSalary("17000");
        actualUser.setEmpid(9);
        actualUser.setEmpname("Name");
        actualUser.setDob("21/01/1997");
        assertEquals("17000", actualUser.getSalary());
        assertEquals(9, actualUser.getEmpid());
        assertEquals("Name", actualUser.getEmpname());
        assertEquals("21/01/1997", actualUser.getDob());
    }
}