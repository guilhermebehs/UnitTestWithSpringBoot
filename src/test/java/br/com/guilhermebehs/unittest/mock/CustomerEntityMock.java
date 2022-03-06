package br.com.guilhermebehs.unittest.mock;

import br.com.guilhermebehs.unittest.domain.entity.CustomerEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerEntityMock {

    public static List<CustomerEntity> entities(){
        List<CustomerEntity> list = new ArrayList<>();
        int listSize = new Random().nextInt(5) + 1;

        for(int i = 0; i < listSize; i++)
            list.add(entity());

        return list;
   }

    public static CustomerEntity entity(){
       return mock();
    }


    private static CustomerEntity mock(){
        LocalDate birthDate = LocalDate.parse("1991-02-15");
        return new CustomerEntity("1", "Guilherme Behs", "Baker Street 221b", birthDate);
    }
}
