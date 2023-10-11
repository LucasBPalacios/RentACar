package br.com.rentacar.controller;

import br.com.rentacar.dto.CustomerDTO;
import br.com.rentacar.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDsl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customers", description = "This endpoint manages customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    @Operation(summary = "Persists a new customer", tags = {"Customers"}, responses = {@ApiResponse(description = "Success!", responseCode = "200",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))})})
    public CustomerDTO create(@RequestBody CustomerDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Persists a new Customer in database", tags = {"Customers"}, responses = {@ApiResponse(description = "Success!", responseCode = "200", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))}),
            @ApiResponse(description = "Bad request", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Internal error", responseCode = "500", content = {@Content})
    })
    public CustomerDTO findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @PutMapping
    public CustomerDTO update(@RequestBody CustomerDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        CustomerDTO dto = service.findById(id);
        service.delete(dto);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
