package br.com.guilhermebehs.unittest.infra.persistence;


import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CustomerMongoRepository extends MongoRepository<CustomerEntity, String>{

    @Query("{'legal_document_number' : ?0}")
    Optional<CustomerEntity> findByLegalDocumentNUmber(String legalDocumentNumber);
}

