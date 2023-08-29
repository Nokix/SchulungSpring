package de.cegos.SchulungSpring.aop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ShopingCartTest {

    @Autowired
    ShopingCart shopingCart;

    @Test
    @DisplayName("Add single Item")
    public void testAddItem1() {
        Item cola = new Item("Cola", 100L);

        shopingCart.addItem(cola);

        assertEquals(1, shopingCart.getCountOfItems());
        assertEquals(100L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Add multiple Items")
    public void testAddItem2() {
        Item cola = new Item("Cola", 100L);

        shopingCart.addItem(cola);
        shopingCart.addItem(cola);
        shopingCart.addItem(cola);

        assertEquals(3, shopingCart.getCountOfItems());
        assertEquals(300L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Remove Item")
    public void testRemoveItem1() {
        Item cola = new Item("Cola", 100L);

        shopingCart.addItem(cola);
        shopingCart.addItem(cola);
        shopingCart.removeItem(cola);

        assertEquals(1, shopingCart.getCountOfItems());
        assertEquals(100L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Remove Item that is not present")
    public void testRemoveItem2() {
        Item cola = new Item("Cola", 100L);

        shopingCart.removeItem(cola);

        assertEquals(0L, shopingCart.getCountOfItems());
        assertEquals(0L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Initilized ShoppingCart is empty")
    public void testInizilization() {
        assertEquals(0L, shopingCart.getCountOfItems());
        assertEquals(0L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Add and Remove different Items")
    public void testMultipleItems() {
        Item cola = new Item("Cola", 100L);
        Item sprite = new Item("Sprite", 70L);

        shopingCart.addItem(cola);
        shopingCart.addItem(sprite);
        shopingCart.addItem(sprite);
        shopingCart.removeItem(cola);

        assertEquals(2, shopingCart.getCountOfItems());
        assertEquals(140L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Add very many Item")
    public void testAddItem3() {
        Item cola = new Item("Cola", 100L);

        for (int i = 0; i < 200; i++) {
            shopingCart.addItem(cola);
        }

        assertEquals(200, shopingCart.getCountOfItems());
        assertEquals(20000L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Add multiple Items at once")
    public void testAddItems1() {
        Iterable<Item> items = List.of(
                new Item("Cola", 100L),
                new Item("Sprite", 70L),
                new Item("Fanta", 5L)
        );

        shopingCart.addItems(items);

        assertEquals(3L, shopingCart.getCountOfItems());
        assertEquals(175L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Add empty List of Items")
    public void testAddItems2() {
        Iterable<Item> emptyList = List.of();
        shopingCart.addItems(emptyList);
        assertEquals(0L, shopingCart.getCountOfItems());
        assertEquals(0L, shopingCart.getSumOfPrices());
    }

    @Test
    @DisplayName("Only sugar snacks are allowed")
    public void testAddItems() {
        Item cola = new Item("Cola", 100L);
        Item möhren = new Item("Möhren", 80L);

        shopingCart.addItem(cola);
        shopingCart.addItem(möhren);

        assertEquals(1L, shopingCart.getCountOfItems());
        assertEquals(100L, shopingCart.getSumOfPrices());
    }
}