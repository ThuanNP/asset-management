package vn.evnhcmc.itc.asset.portal.restapi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.evnhcmc.itc.asset.portal.restapi.common.exception.ResourceNotFoundException;
import vn.evnhcmc.itc.asset.portal.restapi.model.DataControlUnit;
import vn.evnhcmc.itc.asset.portal.restapi.service.DataControlUnitService;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/api/dcus")
public class DataControlUnitController {

    private DataControlUnitService _dcuService;

    public DataControlUnitController(DataControlUnitService dcuService) {
        _dcuService = dcuService;
    }

    @ResponseBody
    @GetMapping( name = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DataControlUnit>> findAll() {
        return ResponseEntity.ok(_dcuService.findAll());
    }

    @ResponseBody
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DataControlUnit> findById(@PathVariable final Long id) {
        DataControlUnit dcu = _dcuService.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ResponseEntity.ok(dcu);
    }
}
