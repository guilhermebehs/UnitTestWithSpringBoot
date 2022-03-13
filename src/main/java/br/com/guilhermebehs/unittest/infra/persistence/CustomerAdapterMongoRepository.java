package br.com.guilhermebehs.unittest.infra.persistence;

import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import br.com.guilhermebehs.unittest.domain.port.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerAdapterMongoRepository implements CustomerRepository {

    private final CustomerMongoRepository customerMongoRepository;

    public CustomerAdapterMongoRepository(CustomerMongoRepository customerMongoRepository) {
        this.customerMongoRepository = customerMongoRepository;
    }


    @Override
    public List<CustomerEntity> list() {
        return customerMongoRepository.findAll();
    }

    @Override
    public CustomerEntity create(CustomerEntity customer) {
        return customerMongoRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> getByLegalDocumentNumber(String legalDocumentNumber) {
        return Optional.empty();
    }
}