package br.com.guilhermebehs.unittest.domain;

import br.com.guilhermebehs.unittest.domain.entity.Customer;
import br.com.guilhermebehs.unittest.domain.port.CustomerRepository;
import br.com.guilhermebehs.unittest.mock.CustomerMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class CustomerCoreTest {

    @Autowired
    private CustomerCore customerCore;

    @MockBean
    private CustomerRepository customerRepository;

    private List<Customer> customersMock;

    @BeforeEach
    public void setUp(){
        customersMock = CustomerMock.entities();
        when(customerRepository.list()).thenReturn(customersMock);
    }

    @Test
    public void shouldReturnCustomers(){
        List<Customer> customers = customerCore.list();
        assertThat(customers.size()).isEqualTo(customersMock.size());
        verify(customerRepository,times(1)).list();
    }

    @Test
    public void shouldThrowWhenCustomerRepositoryThrows(){
        when(customerRepository.list()).thenThrow(new RuntimeException("Any error"));

        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            customerCore.list();
        });
        assertThat(exception.getMessage()).isEqualTo("Any error");
        verify(customerRepository,times(1)).list();
    }
}
