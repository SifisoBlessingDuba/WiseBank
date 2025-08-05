package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.wisebank.domain.Beneficiary;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.BeneficiaryRepository;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BeneficiaryServiceTest {

    @Mock
    private BeneficiaryRepository beneficiaryRepository;

    @InjectMocks
    private BeneficiaryService beneficiaryService;

    private AutoCloseable closeable;
    private Beneficiary beneficiary;
    private User mockUser;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);

        // Mock User with getUserid() stubbed to prevent NullPointerException in toString()
        mockUser = mock(User.class);
        when(mockUser.getUserid()).thenReturn("U123");

        beneficiary = new Beneficiary.Builder()
                .setAccountNumber("1234567890")
                .setName("Jane Doe")
                .setBankName("Capitec")
                .setAddedAt(LocalDate.now())
                .setUser(mockUser)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void testSave() {
        when(beneficiaryRepository.save(beneficiary)).thenReturn(beneficiary);
        Beneficiary saved = beneficiaryService.save(beneficiary);
        assertNotNull(saved);
        assertEquals("Jane Doe", saved.getName());
        verify(beneficiaryRepository, times(1)).save(beneficiary);
    }

    @Test
    void testUpdate() {
        when(beneficiaryRepository.save(beneficiary)).thenReturn(beneficiary);
        Beneficiary updated = beneficiaryService.update(beneficiary);
        assertNotNull(updated);
        assertEquals("1234567890", updated.getAccountNumber());
        verify(beneficiaryRepository, times(1)).save(beneficiary);
    }

    @Test
    void testDeleteById() {
        doNothing().when(beneficiaryRepository).deleteById("1234567890");
        beneficiaryService.deleteById("1234567890");
        verify(beneficiaryRepository, times(1)).deleteById("1234567890");
    }

    @Test
    void testFindById() {
        when(beneficiaryRepository.findById("1234567890")).thenReturn(Optional.of(beneficiary));
        Beneficiary found = beneficiaryService.findById("1234567890");
        assertNotNull(found);
        assertEquals("Jane Doe", found.getName());
        verify(beneficiaryRepository, times(1)).findById("1234567890");
    }

    @Test
    void testFindAll() {
        List<Beneficiary> list = Collections.singletonList(beneficiary);
        when(beneficiaryRepository.findAll()).thenReturn(list);
        List<Beneficiary> result = beneficiaryService.findAll();
        assertEquals(1, result.size());
        verify(beneficiaryRepository, times(1)).findAll();
    }
}
