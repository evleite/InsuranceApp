package no.insurance.Service;

import no.insurance.domain.Letter;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;
import no.insurance.service.LetterStubService;
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
 * Created by p on 29/10/2016.
 */
public class LetterStubServiceTest {
    private Letter expectedLetter;
    private List<Letter> expectedLetters;
    private Long userId1;

    @InjectMocks
    private LetterStubService _letterSubServiceMock;

    @Before
    public void setUp() throws Exception {
        expectedLetters = new ArrayList<Letter>();
        userId1 = 1L;
        expectedLetter = new Letter(1L, userId1, Insurance.CAR.getValue(), "product got for my car", State.SEND.getValue(), 3450.5);
        expectedLetters.add(expectedLetter);

        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {

        List<Letter> actualLetters = _letterSubServiceMock.list();

        assertNotNull(actualLetters);
        assertEquals(expectedLetters.toArray().length,1);

        // Method is static
        assertEquals(actualLetters.toArray().length,3);

        assertEquals( expectedLetters.get(0).getId().longValue(), actualLetters.get(0).getId().longValue() );
    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        //assertEquals(true,false);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
