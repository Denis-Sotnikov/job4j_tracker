package ru.job4j.tracker.oop;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (products.length - 1 == index) {
            products[index] = null;
        } else {
            for (int i = index; i < products.length-1; i++) {
                products[i] = products[i + 1];
//                if (i == products.length - 1) {
//                    products[i] = null;
//                }

            }
            products[products.length-1] = null;
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[6];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Egg+", 19);
        products[4] = new Product("Water", 19);
        products[5] = new Product("Chese", 19);
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getName());
        }
        System.out.println("---");
        ShopDrop.delete(products, 0);
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName());
            }
        }

//        products[1] = products[2];
//        products[2] = null;
//        for (int i = 0; i < products.length; i++) {
//            Product product = products[i];
//            if (product != null) {
//                System.out.println(product.getName());
//            } else {
//                System.out.println("null");
//            }
//        }
    }
}
