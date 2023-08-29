package de.cegos.SchulungSpring.aop;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@Component
@Getter
public class ShopingCart {
    public Map<Item, Long> cart = new HashMap<>();

    private Long sumOfPrices = 0L;
    private Long countOfItems = 0L;

    public ShopingCart addItem(Item item) {
        Long currentNumberOfItem = cart.getOrDefault(item, 0L);
        cart.put(item, currentNumberOfItem + 1);
        return this;
    }

    public ShopingCart removeItem(Item item) {
        if (!cart.containsKey(item)) return this;

        Long itemAmount = cart.get(item);
        if (itemAmount > 1) {
            cart.put(item, itemAmount - 1);
        } else {
            cart.remove(item);
        }
        return this;
    }

    public ShopingCart addItems(Iterable<Item> items) {
        StreamSupport.stream(items.spliterator(), false)
                .forEach(this::addItem);
        return this;
    }

    void updateSumOfPrices() {
        this.sumOfPrices = cart.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    void updateCountOfItems() {
        this.countOfItems =
                cart.values().stream().mapToLong(Long::longValue).sum();
    }
}
