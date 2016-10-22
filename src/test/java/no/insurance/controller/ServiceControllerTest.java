package no.insurance.controller;

import no.insurance.domain.Service;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;
import no.insurance.repository.ServiceRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 22/10/2016.
 */
public class ServiceControllerTest {

    private Service expectedService;
    private List<Service> expectedServices;
    private Long userId1;

    @InjectMocks
    private ServiceController controllerMock;

    @Mock
    private ServiceRepository _serviceRepositoryMock;

    @Before
    public void setUp() throws Exception {
        expectedServices = new ArrayList<Service>();
        userId1 = 1L;
        expectedService = new Service(1L, userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        expectedServices.add(expectedService);

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {
        //MOCHITO
        when(_serviceRepositoryMock.findAll()).thenReturn(expectedServices);

        List<Service> actualServices = controllerMock.list();

        assertNotNull(actualServices);
        assertEquals(expectedServices.toArray().length,1);

        //verify if method was call
        verify(_serviceRepositoryMock).findAll();

        assertEquals( expectedServices.get(0).getId().longValue(), actualServices.get(0).getId().longValue() );

        //Hamcrest
        //assertThat(expectedServices.get(0).getId(), is(actualServices.getId()));
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