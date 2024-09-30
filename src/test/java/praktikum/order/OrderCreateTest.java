package praktikum.order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class OrderCreateTest {
    private OrderClient client = new OrderClient();
    private OrderChecks check = new OrderChecks();
    private String[] color;

    public OrderCreateTest(String[] color){
        this.color = color;
    }

    @Parameterized.Parameters(name = "Test with color: {0}")
    public static Object[][] colorGenerator(){
        return new Object[][]{
                {new String[]{}},
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"GREY","BLACK"}}
        };
    }
    @Test
    @DisplayName("Создание заказа с разными цветами")
    public void createOrderWithParameterizedColor(){
        var order = Order.orderWithoutColor();
        order.setColor(color);
        ValidatableResponse createResponse = client.createOrder(order);
        check.checkCreateOrder(createResponse);
    }
}
