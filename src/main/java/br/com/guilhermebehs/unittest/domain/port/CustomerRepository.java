package br.com.guilhermebehs.unittest.domain.port;

import br.com.guilhermebehs.unittest.domain.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    public List<Customer> list();
}
