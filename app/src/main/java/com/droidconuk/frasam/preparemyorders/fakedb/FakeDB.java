package com.droidconuk.frasam.preparemyorders.fakedb;


import com.droidconuk.frasam.preparemyorders.model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francescoditrani on 29/10/16.
 */

public class FakeDB {

    public static final Map<String, Product> halloweenProducts;
    static
    {
        halloweenProducts = new HashMap<String, Product>();
        halloweenProducts.put("123456", new Product("Pumpkin", 29.99,"Awesome pumpkin", "It's a really awesome pumpkin"));
        halloweenProducts.put("327645", new Product("Cauldron", 199.99,"Awesome Cauldron", "It's a really awesome Cauldron"));
        halloweenProducts.put("32743554", new Product("Bat eyes", 0.99,"Awesome Bat eyes", "Really awesome Bat eyes"));
        halloweenProducts.put("3276453452", new Product("Lizard tail", 3.99,"Awesome Lizard tail", "It's a really awesome Lizard tail"));
        halloweenProducts.put("472384", new Product("Nimbus 2000", 3.99,"Awesome Nimbus 2000", "It's THE really awesome Nimbus 2000"));
    }


}
