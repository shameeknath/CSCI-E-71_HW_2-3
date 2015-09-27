package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    private void modifyQuality(Item item, int inc) {
    	item.quality += inc;
    	if (item.quality > 50) {
    		item.quality = 50;
    	}
    	if (item.quality < 0) {
    		item.quality = 0;
    	}
    		
    	
    }

    /**
     * Update the sellin days and update quality of all items
     */
    public void updateQuality() {
    	
    	// Loop though all items and applying updates.
        for (int i = 0; i < items.length; i++) {
        	
        	if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        		items[i].sellIn -= 1;
        	}
        	    	
        	if ( items[i].name.equals("Aged Brie")) {
        		// Aged Brie
        		if (items[i].sellIn >= 0 ) {
        			 modifyQuality(items[i], 1);
        			
        		} else {
        			modifyQuality(items[i], 2);
        		}
        		
        	} else if ( items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") ) {
        		// Backstage passes
        		if (items[i].sellIn < 0) {
        			// When sellIn has past, then quality is just zero
        			items[i].quality = 0;  
        		} else if (items[i].sellIn < 5) {
        			modifyQuality(items[i], 3);	
        	    } else if (items[i].sellIn < 10 ) {
        	    	modifyQuality(items[i], 2);
        	    } else {
        	    	modifyQuality(items[i], 1);	
        	    }		
        		
        	} else if ( items[i].name.equals("Sulfuras, Hand of Ragnaros") ) {
        		// Sulfuras
        		// do nothing, stays the same
        		
        	} else {
        		// Normal
        		if (items[i].sellIn >= 0) {
        			modifyQuality(items[i], -1);
        		} else {
        			modifyQuality(items[i], -2);	
        		}      	
        	}
        	
        }
    }
}
