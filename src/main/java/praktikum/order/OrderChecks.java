package praktikum.order;

import io.restassured.response.ValidatableResponse;
import java.util.List;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class OrderChecks {
    public void checkCreateOrder(ValidatableResponse createResponse){
        int track = createResponse
                .assertThat()
                .statusCode(201)
                .extract()
                .path("track");
        assertNotEquals(0,track);
    }

    public void checkGetOrders(ValidatableResponse createResponse){
        List orders = createResponse
                .assertThat()
                .statusCode(200)
                .extract()
                .path("orders");
        assertNotNull(orders);
    }
}
