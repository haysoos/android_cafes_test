package com.yahoo.fuzzy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiceCoefficientTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testBigram() {
		DiceEfficient.bigram("test");
	}
	
	@Test
	public final void testDice() {
		assertEquals(.8, DiceEfficient.dice(DiceEfficient.bigram("test1"), DiceEfficient.bigram("test2")), .01);
	}

}
