package pl.springacademy.onlineshop.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pl.springacademy.onlineshop.model.Product;
import pl.springacademy.onlineshop.repository.CartRepository;

@Service
@Profile({"START", "default"})
@RequiredArgsConstructor
public class StartShopService implements ShopServiceInterface {

    private final CartRepository cartRepository;

    @Override
    public void getCartProducts() {
        final List<Product> cartProducts = cartRepository.getAllCartProducts();
        cartProducts.forEach(
                product -> System.out.println(product.getName() + " costs " + product.getPrice() + " zł.")
        );
    }
}
