package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemUnitTests {

	@Test
	public void testToString() {
		Item item = new Item("testitem",10,5);
	assertEquals("testitem, 10, 5", item.toString());
	}
	

}
