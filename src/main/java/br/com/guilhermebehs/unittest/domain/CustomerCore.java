package br.com.guilhermebehs.unittest.domain;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
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

    public CustomerEntity create(CustomerDto customer){
        validateName(customer.getName());
        validateAddress(customer.getAddress());
        validateBirthDay(customer.getBirthDate());
        validateLegalDocumentNumber(customer.getLegalDocumentNumber());

        return customerRepository.create(customer);
    }

    private void validateName(String name){
        if(name == null)
            throw new BadRequestException("Name is required");
        if(!(name.length() >= 1 && name.length() <= 100))
            throw new BadRequestException("Name size must be between 1 and 100");
    }

    private void validateAddress(String address){
        if(address == null)
            throw new BadRequestException("Address is required");
        if(!(address.length() >= 1 && address.length() <= 100))
            throw new BadRequestException("Address size must be between 1 and 100");
    }

    private void validateBirthDay(LocalDate birthDate){
        if(birthDate == null)
            throw new BadRequestException("Birth date is required");
    }

    private void validateLegalDocumentNumber(String legalDocumentNumber){
        if(legalDocumentNumber == null)
            throw new BadRequestException("Legal document number is required");
        try{
            Long.parseLong(legalDocumentNumber);
        }
        catch(NumberFormatException e){
            throw new BadRequestException("Legal document number is invalid");
        }
        var customerExists = customerRepository.getByLegalDocumentNumber(legalDocumentNumber).isPresent();
        if(customerExists)
            throw new BadRequestException("Legal document number is invalid");
    }
}
