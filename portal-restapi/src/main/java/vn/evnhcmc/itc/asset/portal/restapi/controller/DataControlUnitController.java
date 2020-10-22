package vn.evnhcmc.itc.asset.portal.restapi.controller;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.evnhcmc.itc.asset.portal.restapi.common.exception.BadRequestException;
import vn.evnhcmc.itc.asset.portal.restapi.common.exception.ResourceNotFoundException;
import vn.evnhcmc.itc.asset.portal.restapi.model.DataControlUnitEntity;
import vn.evnhcmc.itc.asset.portal.restapi.payload.DataControlUnit;
import vn.evnhcmc.itc.asset.portal.restapi.service.DataControlUnitService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping(value = "/api/dcus")
public class DataControlUnitController {

    private final ModelMapper _modelMapper;
    private final DataControlUnitService _dcuService;

    public DataControlUnitController(ModelMapper modelMapper, DataControlUnitService dcuService) {
        _modelMapper = modelMapper;
        _dcuService = dcuService;
    }

    @ResponseBody
    @GetMapping( name = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DataControlUnit>> get() {
        return ResponseEntity.ok(_dcuService.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()));
    }

    @ResponseBody
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DataControlUnit> get(@PathVariable final Long id) {
        return ResponseEntity.ok(_dcuService.findById(id)
                .map(this::convertToDto)
                .orElseThrow(ResourceNotFoundException::new));
    }

    @ResponseBody
    @PostMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DataControlUnit> create(@RequestBody DataControlUnit dcu) {
        return ResponseEntity.ok(convertToDto(_dcuService.saveAndFlush(convertToEntity(dcu))));
    }

    @ResponseBody
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DataControlUnit> save(@PathVariable final Long id, @RequestBody DataControlUnit dcu) {
        DataControlUnitEntity dcuEntity = _dcuService.findById(id)
                .map(element -> convertToEntity(dcu))
                .orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.ok(convertToDto(_dcuService.save(dcuEntity)));
    }

    @ResponseBody
    @PatchMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DataControlUnit> save(@PathVariable final Long id, @RequestParam Map<String, Object> changes) {
        try {
            return ResponseEntity.ok(convertToDto(_dcuService.save(changes, id)));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.error(e);
            throw new BadRequestException("Save dcu failed.", e);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        _dcuService.deleteById(id);
    }

    private DataControlUnit convertToDto(DataControlUnitEntity user) {
        return _modelMapper.map(user, DataControlUnit.class);
    }

    private DataControlUnitEntity convertToEntity(DataControlUnit user) {
        return _modelMapper.map(user, DataControlUnitEntity.class);
    }

}
