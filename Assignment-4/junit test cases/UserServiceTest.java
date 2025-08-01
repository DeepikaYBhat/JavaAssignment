package com.Assignment3.CRUD.Example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Assignment3.CRUD.Example.entity.User;
import com.Assignment3.CRUD.Example.repository.UserRepository;


import java.util.Optional;

import com.Assignment3.CRUD.Example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockitoBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#saveUser(User)}
     */
    @Test
    void testSave() {

        User user = new User();
        user.setSalary("17000");
        user.setEmpid(9);
        user.setEmpname("Name");
        user.setDob("21/01/1997");
        when(userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setSalary("17000");
        user1.setEmpid(9);
        user1.setEmpname("Name");
        user1.setDob("21/01/1997");
        assertSame(user, userService.saveUser(user1));
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link UserService#findById(int)}
     */
    @Test
    void testGetEmployee() {
        User user = new User();
        user.setSalary("17000");
        user.setEmpid(9);
        user.setEmpname("Name");
        user.setDob("21/01/1997");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(user, userService.findById(9));
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#findById(int)}
     */

    /**
     * Method under test: {@link UserService#updateUser(User)}
     */
    @Test
     void testUpdateEmployee() {
        User user = new User();
        user.setSalary("17000");
        user.setEmpid(9);
        user.setEmpname("Name");
        user.setDob("21/01/1997");
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setSalary("17000");
        user1.setEmpid(9);
        user1.setEmpname("Name");
        user1.setDob("21/01/1997");
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Integer) any())).thenReturn(ofResult);



        User user2 = new User();
        user2.setSalary("17000");
        user2.setEmpid(9);
        user2.setEmpname("Name");
        user2.setDob("21/01/1997");
        User updatedUser = userService.updateUser(user2);

        assertEquals(user2.getEmpid(), updatedUser.getEmpid());
        assertEquals(user2.getEmpname(), updatedUser.getEmpname());
        assertEquals(user2.getSalary(), updatedUser.getSalary());
        assertEquals(user2.getDob(), updatedUser.getDob());
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link UserService#updateUser(User)}
     */

    @Test
    void testDeleteEmployee() {
        User user = new User();
        user.setEmpid(9);
        user.setEmpname("Test User");
        user.setSalary("10000");
        user.setDob("01/01/2000");

        // Mocking findById and deleteById
        when(userRepository.findById(9)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(9);

        userService.deleteUser(9);

        verify(userRepository).findById(9);
        verify(userRepository).deleteById(9);
    }


}