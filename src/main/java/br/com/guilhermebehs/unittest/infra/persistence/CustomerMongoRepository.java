package br.com.guilhermebehs.unittest.infra.persistence;


import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoRepository extends MongoRepository<CustomerEntity, String>{}

