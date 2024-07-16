package com.sapient.sapient.Callouts;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CalloutTests {
	static Callout c;

	@Mock
    private CalloutRepository calloutrepo;

    @InjectMocks
    private CalloutService calloutservice;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Callout();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		given(calloutrepo.save(c)).willReturn(c);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void calloutAddsToRepository() {
		assertNotNull(c);
		Boolean result = calloutservice.addCallout(c);
		assertEquals(result, true);
	}

}
