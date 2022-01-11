package pl.springacademy.onlineshop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.springacademy.onlineshop.model.Product;
import pl.springacademy.onlineshop.repository.CartRepository;

@Service
@Profile("PRO")
@RequiredArgsConstructor
public class ProShopService implements ShopServiceInterface {

    private final CartRepository cartRepository;

    @Value("${price.tax}")
    private int tax;
    @Value("${price.discount}")
    private int discount;

    @Override
    public void getCartProducts() {
        final List<Product> cartProducts = cartRepository.getAllCartProducts();
        cartProducts.forEach(
                product -> System.out.println(product.getName() + " costs " + countFinalPrice(product.getPrice())
                        + " zł [including " + tax + "% tax and " + discount + "% discount]. Base price was " + product.getPrice())
        );
    }

    private String countFinalPrice(final BigDecimal price) {
        final BigDecimal priceWithDiscount = price
                .subtract(price
                        .multiply(BigDecimal.valueOf(discount/100.0))
                        .setScale(2, RoundingMode.HALF_EVEN)
                );

        final BigDecimal taxRate = priceWithDiscount
                .multiply(BigDecimal.valueOf(tax/100.0))
                .setScale(2, RoundingMode.HALF_EVEN);

        return priceWithDiscount.add(taxRate)
                .toString();
    }
}
