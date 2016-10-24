package no.insurance.controller;

import no.insurance.domain.Service;
import no.insurance.repository.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 22/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
class ServiceController {

    @Autowired
    private ServiceRepository _serviceRepository;

    @RequestMapping(value = "service", method = RequestMethod.GET)
    public List<Service> list() {

        return _serviceRepository.findAll();
    }

    @RequestMapping(value = "service", method = RequestMethod.POST)
    public Service create(@RequestBody Service service) {

        return _serviceRepository.saveAndFlush(service);
    }

    @RequestMapping(value = "service/{id}", method = RequestMethod.GET)
    public Service get(@PathVariable Long id) {
       // For testing
       // Service service = _serviceRepository.findOne(id);

        return _serviceRepository.findOne(id);
    }

    @RequestMapping(value = "service/{id}", method = RequestMethod.PUT)
    public Service update(@PathVariable Long id, @RequestBody Service service) {
        Service existingService = _serviceRepository.findOne(id);
        BeanUtils.copyProperties(service, existingService);
        return _serviceRepository.saveAndFlush(existingService);
    }

    @RequestMapping(value = "service/{id}", method = RequestMethod.DELETE)
    public Service delete(@PathVariable Long id) {
        Service existingService = _serviceRepository.findOne(id);
        _serviceRepository.delete(existingService);
        return existingService;

        //NOTE: return void is possible also
    }
}
