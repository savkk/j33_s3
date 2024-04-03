package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductGetFinalPriceTest {
    @Parameterized.Parameter(0)
    public int discount;

    @Parameterized.Parameter(1)
    public int price;

    @Parameterized.Parameter(2)
    public int expectedResult;

    @Parameterized.Parameter(3)
    public String someString;


    @Parameterized.Parameters(name = "{index}. discount {0}, price {1}, expected result {2}")
    public static Object[][] data() {
        return new Object[][]{
                {-1, 100, 100, "1"},
                {0, 100, 100, "2"},
                {25, 100, 75, "3"},
                {50, 100, 50, "4"}
        };
    }


    @Test
    public void getFinalPrice() {
        System.out.println(someString);
        Product product = new Product(price, discount);
        int finalPrice = product.getFinalPrice();
        Assert.assertEquals("Ожидаемый результат отличается от фактического",
                expectedResult, finalPrice);
    }
}