package pl.springacademy.onlineshop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import pl.springacademy.onlineshop.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

public class CartRepositoryTest {

    private final CartRepository cartRepository = new CartRepository();

    @Test
    void should_return_proper_number_of_products() {
        final List<Product> cartProducts = cartRepository.getAllCartProducts();

        assertThat(cartProducts).hasSize(5);
    }
}