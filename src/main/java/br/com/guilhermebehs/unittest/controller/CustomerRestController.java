package br.com.guilhermebehs.unittest.controller;

import br.com.guilhermebehs.unittest.domain.dto.CustomerDto;
import br.com.guilhermebehs.unittest.domain.port.CustomerPortIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "v1/customers")
public class CustomerRestController {

    private final CustomerPortIn customerPortIn;

    public CustomerRestController(CustomerPortIn customerPortIn) {
        this.customerPortIn = customerPortIn;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerDto customerDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerPortIn.create(customerDto));
    }
}
