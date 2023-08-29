package de.cegos.SchulungSpring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class UpdateAspect {

    @Pointcut("within(ShopingCart)")
    void methodsInShopingCart() {
    }

    @Pointcut("methodsInShopingCart() && args(item)")
    void methodsInShopingCartWithItem(Item item) {
    }

    @After("methodsInShopingCart()")
    public void updateShopingCart(JoinPoint joinPoint) {;
        ShopingCart cart = (ShopingCart) joinPoint.getTarget();
        cart.updateCountOfItems();
        cart.updateSumOfPrices();
    }

    @Around("methodsInShopingCartWithItem(item)")
    public void forbidHealthyStuff(
            ProceedingJoinPoint proceedingJoinPoint,
            Item item) throws Throwable {

        List<String> healthy = List.of("Möhren", "Gurken", "Paprika");
        if (healthy.contains(item.getName())) {
            return;
        }

        proceedingJoinPoint.proceed();
    }
}
