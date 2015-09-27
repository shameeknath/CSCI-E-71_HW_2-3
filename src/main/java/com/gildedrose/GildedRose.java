package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
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
        		if (items[i].quality < 50 && items[i].sellIn >= 0 ) {
        			 items[i].quality +=  1;
        			
        		} else {
        			items[i].quality +=  2;
        		}
        		
        		
        	} else if ( items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") ) {
        		// Backstage passes
        		if (items[i].quality < 50) {
        			 items[i].quality = items[i].quality + 1;
        			 if (items[i].sellIn < 11) {
                         if (items[i].quality < 50) {
                             items[i].quality = items[i].quality + 1;
                         }
                     }
        			 
        			 if (items[i].sellIn < 6) {
                         if (items[i].quality < 50) {
                             items[i].quality = items[i].quality + 1;
                         }
                     }
        		}
        		if (items[i].sellIn < 0) {
        			items[i].quality = items[i].quality - items[i].quality;
        			
        		}
        		
        	} else if ( items[i].name.equals("Sulfuras, Hand of Ragnaros") ) {
        		// Sulfuras
        		items[i].sellIn = items[i].sellIn - 1;
        		
        	} else {
        		// Normal
        		if (items[i].quality > 0) {
        			items[i].quality = items[i].quality - 1;
        		}
        		if (items[i].sellIn < 0) {
        			if (items[i].quality > 0) {
        				items[i].quality = items[i].quality - 1;
            		}
        		 }
        		
        	
        	}
        	
        	
        	
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
        }
    }
}
