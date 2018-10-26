package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void passordGyldig() {
		assertFalse(Validator.validPassord("1234"));
		assertFalse(Validator.validPassord(null));
		assertFalse(Validator.validPassord(""));
		
		assert(Validator.validPassord("??????????"));
		assert(Validator.validPassord("12345"));
		assert(Validator.validPassord("læåæøæå"));
		assert(Validator.validPassord("👌🍕🍔🎂🐱‍👓")); // Viktig med støtte for emoji i passord
	}
	
	@Test
	void mobilGyldig() {
		assertFalse(Validator.validMobil("1234123"));
		assertFalse(Validator.validMobil(null));
		assertFalse(Validator.validMobil("12341a21"));
		assertFalse(Validator.validMobil("12341a2111"));
		
		assert(Validator.validMobil("12341234"));
		assert(Validator.validMobil("00001000"));
		assert(Validator.validMobil("00000001"));
	}

	@Test
	void fornavnGyldig() {
		assertFalse(Validator.validFornavn("1234123"));
		assertFalse(Validator.validFornavn(null));
		assertFalse(Validator.validFornavn("Ole_b"));
		assertFalse(Validator.validFornavn("ole"));
		assertFalse(Validator.validFornavn("åge"));
		assertFalse(Validator.validFornavn("A"));
		assertFalse(Validator.validFornavn("Asdsdsadsdsdsdsssdsdsdsds"));
		
		assert(Validator.validFornavn("Ole b"));
		assert(Validator.validFornavn("Ole-b---"));
		assert(Validator.validFornavn("Truls"));
		assert(Validator.validFornavn("Åge"));
		assert(Validator.validFornavn("Jørn"));
		assert(Validator.validFornavn("JØRN"));
		assert(Validator.validFornavn("CAPSSSSSSSSSSS"));
	}
	
	@Test
	void etternavnGyldig() {
		assertFalse(Validator.validEtternavn("1234123"));
		assertFalse(Validator.validEtternavn(null));
		assertFalse(Validator.validEtternavn("Ole_b"));
		assertFalse(Validator.validEtternavn("ole"));
		assertFalse(Validator.validEtternavn("åge"));
		assertFalse(Validator.validEtternavn("A"));
		assertFalse(Validator.validEtternavn("Asdsdsadsdsdsdsssdsdsdsds"));
		
		assert(Validator.validEtternavn("Ole b"));
		assert(Validator.validFornavn("T r u l s"));
		assert(Validator.validFornavn("Åge"));
		assert(Validator.validFornavn("Jørn"));
		assert(Validator.validFornavn("JØRN"));
		assert(Validator.validFornavn("CAPSSSSSSSSSSS"));
	}
}
