package br.com.guilhermebehs.unittest;

import br.com.guilhermebehs.unittest.domain.CustomerCore;
import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;
import br.com.guilhermebehs.unittest.domain.port.CustomerPortIn;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerPortIn {

    private final CustomerCore customerCore;

    public CustomerService(CustomerCore customerCore) {
        this.customerCore = customerCore;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
         var customerEntity = new CustomerEntity(
                 customerDto.getLegalDocumentNumber(),
                 customerDto.getName(),
                 customerDto.getAddress(),
                 customerDto.getBirthDate()
         );
         var customerCreated = customerCore.create(customerEntity);

         return new CustomerDto(
                 customerCreated.getLegalDocumentNumber(),
                 customerCreated.getName(),
                 customerCreated.getAddress(),
                 customerCreated.getBirthDate()
         );
    }
}
