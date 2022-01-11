package pl.springacademy.onlineshop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.springacademy.onlineshop.model.Product;
import pl.springacademy.onlineshop.repository.CartRepository;

@Service
@Profile("PLUS")
@RequiredArgsConstructor
public class PlusShopService implements ShopServiceInterface {

    private final CartRepository cartRepository;

    @Value("${price.tax}")
    private int tax;

    @Override
    public void getCartProducts() {
        final List<Product> cartProducts = cartRepository.getAllCartProducts();
        cartProducts.forEach(
                product -> System.out.println(product.getName() + " costs " + countFinalPrice(product.getPrice())
                        + " zł [including " + tax + "% tax]. Base price was " + product.getPrice())
        );
    }

    private String countFinalPrice(final BigDecimal price) {
        final BigDecimal taxRate = price
                .multiply(BigDecimal.valueOf(tax/100.0))
                .setScale(2, RoundingMode.HALF_EVEN);

        return price.add(taxRate)
                .toString();
    }
}
