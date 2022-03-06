package br.com.guilhermebehs.unittest.mock;

import br.com.guilhermebehs.unittest.domain.entity.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerMock {

    public static List<Customer> entities(){
        List<Customer> list = new ArrayList<>();
        int listSize = new Random().nextInt(5) + 1;

        for(int i = 0; i < listSize; i++)
            list.add(entity());

        return list;
   }

    public static Customer entity(){
       return mock();
    }


    private static Customer mock(){
        LocalDate localDate = LocalDate.parse("1991-02-15");
        return new Customer("1", "Guilherme Behs", "Baker Street 221b", localDate);
    }
}
