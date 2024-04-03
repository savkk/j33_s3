package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductGetPriceTest {

    @Parameterized.Parameter(0)
    public int price;

    @Parameterized.Parameter(1)
    public int expectedResult;

    @Parameterized.Parameters(name = "{index}. price {0}, expected result {1}")
    public static Object[][] data() {
        return new Object[][]{
                {99, 100},
                {100, 100},
                {101, 101},
                {151, 150}
        };
    }

    @Test
    public void getPrice() {
        Product product = new Product(price, 0);
        int finalPrice = product.getPrice();
        Assert.assertEquals("Ожидаемый результат отличается от фактического",
                expectedResult, finalPrice);
    }
}
