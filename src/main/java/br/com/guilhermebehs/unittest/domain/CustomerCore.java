package br.com.guilhermebehs.unittest.domain;

import br.com.guilhermebehs.unittest.domain.entity.Customer;
import br.com.guilhermebehs.unittest.domain.port.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerCore {

    private final CustomerRepository customerRepository;

    public CustomerCore(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> list(){
        return customerRepository.list();
    }
}
