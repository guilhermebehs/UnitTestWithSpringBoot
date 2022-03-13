package br.com.guilhermebehs.unittest.domain;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import br.com.guilhermebehs.unittest.domain.error.BadRequestException;
import br.com.guilhermebehs.unittest.domain.port.CustomerRepository;
import br.com.guilhermebehs.unittest.mock.CustomerDtoMock;
import br.com.guilhermebehs.unittest.mock.CustomerEntityMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@DisplayName("CustomerCore")
public class CustomerCoreTest {

    @Autowired
    private CustomerCore customerCore;

    @MockBean
    private CustomerRepository customerRepository;

    private List<CustomerEntity> customersMock;
    private CustomerEntity customerMock;

    @BeforeEach
    public void setUp(){
        customersMock = CustomerEntityMock.entities();
        customerMock = CustomerEntityMock.entity();
        when(customerRepository.list()).thenReturn(customersMock);
        when(customerRepository.create(any())).thenReturn(customerMock);
        when(customerRepository.getByLegalDocumentNumber(any())).thenReturn(Optional.empty());
    }

    @Test
    @DisplayName("Should return customer on success")
    public void shouldReturnCustomers(){
        List<CustomerEntity> customers = customerCore.list();
        assertThat(customers.size()).isEqualTo(customersMock.size());
        verify(customerRepository,times(1)).list();
    }

    @Test
    @DisplayName("Should create customer on success")
    public void shouldCreateCustomer(){
        var customerEntity = CustomerEntityMock.entity();
        CustomerEntity customer = customerCore.create(customerEntity);
        assertThat(customer.getLegalDocumentNumber()).isEqualTo(customer.getLegalDocumentNumber());
        assertThat(customer.getAddress()).isEqualTo(customer.getAddress());
        assertThat(customer.getName()).isEqualTo(customer.getName());
        assertThat(customer.getBirthDate()).isEqualTo(customer.getBirthDate());
        verify(customerRepository,times(1)).getByLegalDocumentNumber(any());
        verify(customerRepository,times(1)).create(any());
    }

    @DisplayName("Should throw when customer already exists on creation")
    public void shouldThrowWhenCustomerAlreadyExistsOnCreation(){
        var customerEntity = CustomerEntityMock.entity();
        when(customerRepository.getByLegalDocumentNumber(any())).thenReturn(Optional.of(customerMock));
        var exception = assertThrows(BadRequestException.class, ()->{
            customerCore.create(customerEntity);
        });
        assertThat(exception.getMessage()).isEqualTo("Legal document number is invalid");
        verify(customerRepository,times(1)).getByLegalDocumentNumber(any());
        verify(customerRepository,times(0)).create(any());
    }


    @Test
    @DisplayName("Should throw when customer repository throws")
    public void shouldThrowWhenCustomerRepositoryThrows(){
        when(customerRepository.list()).thenThrow(new RuntimeException("Any error"));

        RuntimeException exception = assertThrows(RuntimeException.class, ()-> {
            customerCore.list();
        });
        assertThat(exception.getMessage()).isEqualTo("Any error");
        verify(customerRepository,times(1)).list();
    }
}
