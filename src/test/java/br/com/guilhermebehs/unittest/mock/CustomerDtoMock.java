package br.com.guilhermebehs.unittest.mock;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;

import java.time.LocalDate;

public class CustomerDtoMock {

    public static CustomerDto entity(){
        return mock();
    }


    private static CustomerDto mock(){
        LocalDate birthDate = LocalDate.parse("1991-02-15");
        return new CustomerDto("1", "Guilherme Behs", "Baker Street 221b", birthDate);
    }
}
