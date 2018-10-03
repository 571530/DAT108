package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void gyldigVarenavn() {
		assert(Validator.validVarenavn("navn"));
		assertFalse(Validator.validVarenavn(""));
	}
	
	@Test
	void gyldigId() {
		assert(Validator.validId("12"));
		assert(Validator.validId("0"));

		assertFalse(Validator.validId("tolv"));
		assertFalse(Validator.validId("-12"));
		assertFalse(Validator.validId(""));
	}

}
