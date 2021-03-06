package pl.springacademy.onlineshop.controler;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import pl.springacademy.onlineshop.repository.CartRepository;
import pl.springacademy.onlineshop.service.ShopServiceInterface;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ShopServiceInterface shopServiceInterface;
    private final CartRepository cartRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void getCart() {
        shopServiceInterface.getCartProducts();
    }
}
