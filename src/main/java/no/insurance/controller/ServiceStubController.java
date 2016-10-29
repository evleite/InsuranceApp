package no.insurance.controller;

import no.insurance.Stub.LetterStub;
import no.insurance.domain.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 22/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class ServiceStubController {

    @RequestMapping(value = "servicestub", method = RequestMethod.GET)
    public List<Service> list() {
        return LetterStub.list();
    }

    @RequestMapping(value = "servicestub", method = RequestMethod.POST)
    public Service create(@RequestBody Service service) {
        return LetterStub.create(service);
    }

    @RequestMapping(value = "servicestub/{id}", method = RequestMethod.GET)
    public Service get(@PathVariable Long id) {
        return LetterStub.get(id);
    }

    @RequestMapping(value = "servicestub/{id}", method = RequestMethod.PUT)
    public Service update(@PathVariable Long id, @RequestBody Service service) {
        Service existingService = LetterStub.get(id);
        BeanUtils.copyProperties(service, existingService);
        return LetterStub.update(id, existingService);
    }

    @RequestMapping(value = "servicestub/{id}", method = RequestMethod.DELETE)
    public Service delete(@PathVariable Long id) {
        Service existingService = LetterStub.get(id);
        LetterStub.delete(id);
        return existingService;

        //NOTE: return void is possible also
    }
}
