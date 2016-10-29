package no.insurance.repository;

import no.insurance.domain.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by p on 22/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceRepositoryTest {

    @Autowired
    private ServiceRepository _serviceRepository;

    @Test
    public void testFindAll() {
        List<Service> services = _serviceRepository.findAll();
        assertThat(services.size(), is(greaterThanOrEqualTo(0)));
    }
}