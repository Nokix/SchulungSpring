package de.cegos.SchulungSpring.aop;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Getter
public class ShopingCart {
    private Long sumOfPrices = 0L;
    private Long countOfItems = 0L;

    public Item addItem(Item item) {

        updateCountOfItems();
        updateSumOfPrices();
        return item;
    }

    public Item removeItem(Item item) {

        updateCountOfItems();
        updateSumOfPrices();
        return item;
    }

    private void updateSumOfPrices() {

    }

    private void updateCountOfItems() {

    }
}
