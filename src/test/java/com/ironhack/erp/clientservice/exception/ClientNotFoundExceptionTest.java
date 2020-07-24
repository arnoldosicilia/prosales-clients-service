package com.ironhack.erp.clientservice.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientNotFoundExceptionTest {
    @Test
    void assertThrows() {
        new ClientNotFoundException(null);
    }
}