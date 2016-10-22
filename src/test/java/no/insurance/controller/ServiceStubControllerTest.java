package no.insurance.controller;

import no.insurance.domain.Service;
import no.insurance.helper.Insurance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by p on 22/10/2016.
 */
public class ServiceStubControllerTest {

    private Service expectedService;
    private List<Service> expectedServices;
    private Long userId1;

    @InjectMocks
    private ServiceStubController controller;

    @Before
    public void setUp() throws Exception {
        expectedServices = new ArrayList<Service>();
        userId1 = 1L;
        expectedService = new Service(1L, userId1, Insurance.CAR.getValue(), "product got for my car", 0, 3450.5D);
        expectedServices.add(expectedService);

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {

        List<Service> actualServices = controller.list();

        assertNotNull(actualServices);
        assertEquals(expectedServices.toArray().length,1);

        // Method is static
        assertEquals(actualServices.toArray().length,3);

        assertEquals( expectedServices.get(0).getId().longValue(), actualServices.get(0).getId().longValue() );
    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}