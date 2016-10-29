package no.insurance.Service;

import no.insurance.domain.Letter;
import no.insurance.helper.Insurance;
import no.insurance.helper.State;
import no.insurance.repository.LetterRepository;
import no.insurance.service.LetterService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by p on 29/10/2016.
 */
public class LetterServiceTest {
    private Letter expectedLetter;
    private List<Letter> expectedLetters;
    private Long userId1;

    @InjectMocks
    private LetterService _letterServiceMock;

    @Mock
    private LetterRepository _letterRepositoryMock;

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
        //MOCHITO
        when(_letterRepositoryMock.findAll()).thenReturn(expectedLetters);

        List<Letter> actualLetters = _letterServiceMock.list();

        assertNotNull(actualLetters);
        assertEquals(actualLetters.toArray().length,1);

        //verify if method was call
        verify(_letterRepositoryMock).findAll();

        assertEquals( expectedLetters.get(0).getId().longValue(), actualLetters.get(0).getId().longValue() );

        //Hamcrest
        assertThat(expectedLetters.get(0).getId(), is(actualLetters.get(0).getId()));
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
