package br.com.guilhermebehs.unittest.domain;

import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import br.com.guilhermebehs.unittest.domain.error.BadRequestException;
import br.com.guilhermebehs.unittest.domain.port.CustomerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CustomerCore {

    private final CustomerRepository customerRepository;

    public CustomerCore(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> list(){
        return customerRepository.list();
    }

    public CustomerEntity create(CustomerEntity customer){
        validateIfAlreadyExists(customer);
        return customerRepository.create(customer);
    }


    private void validateIfAlreadyExists(CustomerEntity customer){
        var customerExists = customerRepository
                .getByLegalDocumentNumber(customer.getLegalDocumentNumber())
                .isPresent();
        if(customerExists)
            throw new BadRequestException("Legal document number already exists");
    }
}
