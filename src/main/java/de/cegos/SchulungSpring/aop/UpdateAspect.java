package de.cegos.SchulungSpring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdateAspect {

    @After("within(ShopingCart)")
    public void updateShopingCart(JoinPoint joinPoint) {
        ShopingCart cart = (ShopingCart) joinPoint.getTarget();
        cart.updateCountOfItems();
        cart.updateSumOfPrices();
    }
}
