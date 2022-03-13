package br.com.guilhermebehs.unittest.domain.port;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;

public interface CustomerPortIn {

    public CustomerDto create(CustomerDto customer);
}
