package com.example.unittestdemo;

import model.Client;
import model.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class UnitTestDemoApplicationTests {

    @InjectMocks
    private final ClientController clientController = new ClientController();

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private ClientRepository clientRepository;

    private static final Client existClient = new Client();


    @BeforeAll
    public static void before() {
        existClient.setId(1L);
        existClient.setFirstName("test1");
        existClient.setMiddleName("test1");
        existClient.setLastName("test1");
    }

    @Test
    public void okTest() {
        Mockito.when(clientRepository.findById(1)).thenReturn(new Client().setId(1L)
                .setFirstName("test1")
                .setMiddleName("test1")
                .setLastName("test1"));
        Assertions.assertThat(clientController.getById(1)).isEqualTo(existClient);
    }

    @Test
    public void notFoundTest() {
        String expectedErrorMessage = "did not find result";
        Mockito.when(clientRepository.findById(15))
                .thenThrow(new EmptyResultDataAccessException(expectedErrorMessage, 0));
        String errorMessage = null;
        try {
            clientController.getById(15);
        } catch (EmptyResultDataAccessException ex) {
            errorMessage = ex.getMessage();
        }
        Assertions.assertThat(errorMessage).isEqualTo(expectedErrorMessage);
    }

    @Test
    public void errorDBTest() {
        String expectedErrorMessage = "incorrect variable %s";
        long variable = -1;
        Mockito.when(clientRepository.findById(variable))
                .thenThrow(new NumberFormatException(String.format(expectedErrorMessage, variable)));
        String errorMessage = null;
        try {
            clientController.getById(variable);
        } catch (NumberFormatException ex) {
            errorMessage = ex.getMessage();
        }
        Assertions.assertThat(errorMessage).isEqualTo(String.format(expectedErrorMessage, variable));
    }
}
