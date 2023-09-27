package br.com.rentacar.controller;

import br.com.rentacar.dto.VehicleDTO;
import br.com.rentacar.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public VehicleDTO create(@RequestBody VehicleDTO dto) {return vehicleService.create(dto);}
    @GetMapping("/{id}")
    public VehicleDTO findById(@PathVariable("id") int id){
        return vehicleService.findById(id);
    }
    @PutMapping
    public VehicleDTO update(@RequestBody VehicleDTO dto){
        return vehicleService.update(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        VehicleDTO dto = vehicleService.findById(id);
        vehicleService.delete(dto);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
