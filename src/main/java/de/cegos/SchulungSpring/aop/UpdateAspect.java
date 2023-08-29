package de.cegos.SchulungSpring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class UpdateAspect {

    // Methoden in einem Aspekt werden "Advice" genannt.

//    @After("within(ShopingCart)")
    @After("within(ShopingCart))")
    public void updateShopingCart(JoinPoint joinPoint) {;
        ShopingCart cart = (ShopingCart) joinPoint.getTarget();
        cart.updateCountOfItems();
        cart.updateSumOfPrices();
    }

    @Around("within(ShopingCart) && args(item)")
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
