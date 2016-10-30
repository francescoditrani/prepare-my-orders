package com.droidconuk.frasam.preparemyorders.fakedb;


import com.droidconuk.frasam.preparemyorders.model.Product;

import java.util.ArrayList;

/**
 * Created by francescoditrani on 29/10/16.
 */

public class FakeDB {

    public static final ArrayList<Product> halloweenProducts;
    static
    {
        halloweenProducts = new ArrayList<>();
        halloweenProducts.add(new Product("Pumpkin", 29.99,"Awesome pumpkin", "It's a really awesome pumpkin", "123456"));
        halloweenProducts.add(new Product("Cauldron", 199.99,"Awesome Cauldron", "It's a really awesome Cauldron", "234354534"));
        halloweenProducts.add(new Product("Bat eyes", 0.99,"Awesome Bat eyes", "Really awesome Bat eyes", "23434535"));
        halloweenProducts.add(new Product("Lizard tail", 3.99,"Awesome Lizard tail", "It's a really awesome Lizard tail", "23434535324"));
        halloweenProducts.add(new Product("Nimbus 2000", 3.99,"Awesome Nimbus 2000", "It's THE really awesome Nimbus 2000", "2343453578686"));
    }


}
