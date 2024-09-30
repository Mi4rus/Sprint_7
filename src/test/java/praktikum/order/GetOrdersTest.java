package praktikum.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class GetOrdersTest {
    private OrderClient client = new OrderClient();
    private OrderChecks check = new OrderChecks();

    @Test
    @DisplayName("Получение списка заказов")
    public void successGetOrders(){
        ValidatableResponse createResponse = client.getOrders();
        check.checkGetOrders(createResponse);
    }
}
