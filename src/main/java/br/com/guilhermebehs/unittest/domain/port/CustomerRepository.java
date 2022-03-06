package br.com.guilhermebehs.unittest.domain.port;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public List<CustomerEntity> list();
    public CustomerEntity create(CustomerDto customer);
    public Optional<CustomerEntity> getByLegalDocumentNumber(String legalDocumentNumber);
}
