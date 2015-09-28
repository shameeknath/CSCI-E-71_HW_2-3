package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class TexttestFixtureUnitTest {

	@Test
	public void executeMain() {
		try {
			TexttestFixture.main(new String [] {});
		} catch (Exception e) {
			fail("Main Excuted with errors");
		}
	
	}
	
	@Test
	public void executeMainWithArguments() {
		try {
			TexttestFixture.main(new String [] {"12"});
		} catch (Exception e) {
			fail("Main with Arguments Excuted with errors");
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void executeMainWithInvalidArguments() {
		TexttestFixture.main(new String [] {"f"});
	}

}
