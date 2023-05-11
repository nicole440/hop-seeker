package com.breweryfinder.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testSetDateOfBirth() {
        // Test case 1: user is at least 21 years old
        LocalDate validDateOfBirth = LocalDate.now().minusYears(21);
        User user1 = new User();
        user1.setDateOfBirth(validDateOfBirth);
        assertEquals(validDateOfBirth, user1.getDateOfBirth());

        // Test case 2: user is less than 21 years old
        LocalDate invalidDateOfBirth = LocalDate.now().minusYears(20);
        User user2 = new User();
        user2.setDateOfBirth(invalidDateOfBirth);
        assertNull(user2.getDateOfBirth());
    }

}