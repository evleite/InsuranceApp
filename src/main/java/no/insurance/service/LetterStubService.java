package no.insurance.service;

import no.insurance.Stub.LetterStub;
import no.insurance.domain.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by p on 29/10/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class LetterStubService {
    @RequestMapping(value = "letterstub", method = RequestMethod.GET)
    public List<Service> list() {

        return LetterStub.list();
    }

    @RequestMapping(value = "letterstub", method = RequestMethod.POST)
    public Service create(@RequestBody Service service) {

        return LetterStub.create(service);
    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.GET)
    public Service get(@PathVariable Long id) {

        return LetterStub.get(id);
    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.PUT)
    public Service update(@PathVariable Long id, @RequestBody Service service) {

        Service existingService = LetterStub.get(id);
        BeanUtils.copyProperties(service, existingService);
        return LetterStub.update(id, existingService);

    }

    @RequestMapping(value = "letterstub/{id}", method = RequestMethod.DELETE)
    public Service delete(@PathVariable Long id) {

        Service existingService = LetterStub.get(id);
        LetterStub.delete(id);
        return existingService;

    }
}
