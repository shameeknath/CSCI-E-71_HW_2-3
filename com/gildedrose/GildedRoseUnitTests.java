package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseUnitTests {
	GildedRose gr;
	
	@Before
	public void setUp() {
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
		Item milk = new Item("Milk", 2, 15);
		Item agedBrie = new Item("Aged Brie", 2, 48);
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
		Item[] items = new Item[] {sulfuras, milk, agedBrie, backstagePass}; 
		gr = new GildedRose(items);
	}
	
	@Test
	public void sulfurasQualityRemains80() {
		assertEquals(80, gr.items[0].quality);
		gr.updateQuality();
		assertEquals(80, gr.items[0].quality);
		gr.updateQuality();
		assertEquals(80, gr.items[0].quality);
	
	}

	@Test
	public void sulfurasSellInDoesNotChange() {
		assertEquals(-1, gr.items[0].sellIn);
		gr.updateQuality();
		assertEquals(-1, gr.items[0].sellIn);
		gr.updateQuality();
		assertEquals(-1, gr.items[0].sellIn);
	}
	
	@Test
	public void normalItemSellInReducesByOne() {
		assertEquals(2, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(1, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(0, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(-1, gr.items[1].sellIn);
	}	
	
	@Test
	public void normalItemQualityReduction() {
		assertEquals(15, gr.items[1].quality);
		gr.updateQuality();
		assertEquals(14, gr.items[1].quality);
	}	
	
	@Test
	public void normalItemQualityReductionPastSellInDate() {
		gr.items[1].sellIn = 1;
		assertEquals(15, gr.items[1].quality);
		assertEquals(1, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(14, gr.items[1].quality);
		assertEquals(0, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(12, gr.items[1].quality);
		assertEquals(-1, gr.items[1].sellIn);
		gr.updateQuality();
		assertEquals(10, gr.items[1].quality);
		assertEquals(-2, gr.items[1].sellIn);
		gr.items[1].quality = 0;
		gr.updateQuality();
		assertEquals(0, gr.items[1].quality);
		assertEquals(-3, gr.items[1].sellIn);
		
	}
	
	@Test
	public void agedBrieSellInReductionTest() {
		assertEquals(2, gr.items[2].sellIn);
		gr.updateQuality();
		assertEquals(1, gr.items[2].sellIn);
		gr.updateQuality();
		assertEquals(0, gr.items[2].sellIn);
		gr.updateQuality();
		assertEquals(-1, gr.items[2].sellIn);
		gr.updateQuality();
		assertEquals(-2, gr.items[2].sellIn);
	}
	
	@Test
	public void agedBrieQualityIncreases() {
		gr.items[2].quality = 47;
		gr.items[2].sellIn = 1;
		gr.updateQuality();
		assertEquals(48, gr.items[2].quality);
		assertEquals(0, gr.items[2].sellIn);
		gr.updateQuality();
		assertEquals(50, gr.items[2].quality);
		assertEquals(-1, gr.items[2].sellIn);
//		gr.updateQuality();
//		assertEquals(50, gr.items[3].quality);
//		assertEquals(9, gr.items[3].sellIn);
//		gr.updateQuality();
	}
	
	@Test
	public void backstagePassQualityIncreases() {
		assertEquals(20, gr.items[3].quality);
		assertEquals(11, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(21, gr.items[3].quality);
		assertEquals(10, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(23, gr.items[3].quality);
		assertEquals(9, gr.items[3].sellIn);
		gr.items[3].sellIn = 6;
		gr.updateQuality();
		assertEquals(25, gr.items[3].quality);
		assertEquals(5, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(28, gr.items[3].quality);
		assertEquals(4, gr.items[3].sellIn);
		gr.items[3].sellIn = 0;
		gr.updateQuality();
		assertEquals(0, gr.items[3].quality);
		assertEquals(-1, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(0, gr.items[3].quality);
		assertEquals(-2, gr.items[3].sellIn);
	}
	
	@Test
	public void backstagePassQualityDoesNotExceed50() {
		gr.items[3].quality = 48;
		assertEquals(48, gr.items[3].quality);
		assertEquals(11, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(49, gr.items[3].quality);
		assertEquals(10, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(50, gr.items[3].quality);
		assertEquals(9, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(50, gr.items[3].quality);
		assertEquals(8, gr.items[3].sellIn);
		gr.items[3].sellIn = 5;
		gr.items[3].quality = 48;
		gr.updateQuality();
		assertEquals(50, gr.items[3].quality);
		assertEquals(4, gr.items[3].sellIn);
		/*gr.updateQuality();
		assertEquals(28, gr.items[3].quality);
		assertEquals(4, gr.items[3].sellIn);
		gr.items[3].sellIn = 0;
		gr.updateQuality();
		assertEquals(0, gr.items[3].quality);
		assertEquals(-1, gr.items[3].sellIn);
		gr.updateQuality();
		assertEquals(0, gr.items[3].quality);
		assertEquals(-2, gr.items[3].sellIn);*/
	}
}
