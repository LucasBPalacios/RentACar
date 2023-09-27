package br.com.rentacar.services;

import br.com.rentacar.dto.VehicleDTO;
import br.com.rentacar.exceptions.ResourceNotFoundException;
import br.com.rentacar.mapper.CustomModelMapper;
import br.com.rentacar.model.VehicleModel;
import br.com.rentacar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleDTO create(VehicleDTO dto) {
        VehicleModel model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(vehicleRepository.save(model), VehicleDTO.class);
    }

    public VehicleDTO findById(int id) {
        VehicleModel model = vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(null));
        return CustomModelMapper.parseObject(model, VehicleDTO.class);
    }

    public List<VehicleDTO> findAll(){
        List<VehicleModel> list = vehicleRepository.findAll();
        return CustomModelMapper.parseObjectList(list, VehicleDTO.class);
    }

    public VehicleDTO update(VehicleDTO dto){
        VehicleModel model = vehicleRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        model = CustomModelMapper.parseObject(dto, VehicleModel.class);
        return CustomModelMapper.parseObject(vehicleRepository.save(model), VehicleDTO.class);
    }

    public void delete(VehicleDTO dto) {
        VehicleModel model = vehicleRepository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException(null));
        vehicleRepository.delete(model);
    }
}
