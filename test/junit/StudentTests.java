
// Add focused @org.junit.jupiter.api.Test methods here.
// Create fresh objects for each test and assert results AND unchanged state on rejection.
// The supplied wrapper is not a substitute for your own test design.
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class StudentTests {
	@Test
	void minEdgeInput() {
		assertEquals(1, new Duration(1).hours());
	}

	@Test
	void maxEdgeInput() {
		assertEquals(24, new Duration(24).hours());
	}

	@Test
	void rejectZeroInput() {
		assertThrows(IllegalArgumentException.class, () -> new Duration(0));
	}

	@Test
	void rejectOverInput() {
		assertThrows(IllegalArgumentException.class, () -> new Duration(25));
	}

	@Test
	void rejectNegativeInput() {
		assertThrows(IllegalArgumentException.class, () -> new Duration(-1));
	}

	@Test
	void studentRate() {
		assertEquals(600, new Pricing().quote(new Duration(3), Customer.STUDENT));
	}

	@Test
	void visitorRate() {
		assertEquals(1200, new Pricing().quote(new Duration(3), Customer.VISITOR));
	}

	@Test
	void nullDuration() {
		assertThrows(IllegalArgumentException.class, () -> new Pricing().quote(null, Customer.STUDENT));
		assertThrows(IllegalArgumentException.class, () -> new Pricing().quote(new Duration(1), null));
	}

}