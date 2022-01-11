package pl.springacademy.onlineshop.controler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.springacademy.onlineshop.service.ShopServiceInterface;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

    @Mock
    private ShopServiceInterface shopServiceInterface;

    @InjectMocks
    private CartController cartController;

    @Test
    void should_call_shop_service_interface_when_cart_controller_method_invoked() {
        // given
        // when
        cartController.getCart();

        // then
        verify(shopServiceInterface).getCartProducts();
    }
}