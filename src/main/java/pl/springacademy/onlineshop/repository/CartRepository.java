package pl.springacademy.onlineshop.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.springacademy.onlineshop.model.Product;

@Slf4j
@Component
public class CartRepository {

    private static final int MIN_PRICE = 50;
    private static final int MAX_PRICE = 300;

    @EventListener(ApplicationReadyEvent.class)
    public List<Product> getAllCartProducts() {
        return Arrays.asList(
                new Product("Product1", generatePrice()),
                new Product("Product2", generatePrice()),
                new Product("Product3", generatePrice()),
                new Product("Product4", generatePrice()),
                new Product("Product5", generatePrice())
        );
    }

    private BigDecimal generatePrice() {
        return BigDecimal.valueOf((Math.random() * (MAX_PRICE - MIN_PRICE)) + MIN_PRICE)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
