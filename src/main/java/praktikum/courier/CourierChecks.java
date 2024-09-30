package praktikum.courier;

import io.restassured.response.ValidatableResponse;

import static org.junit.Assert.*;

public class CourierChecks {
    public int checkLoggedIn(ValidatableResponse loginResponse) {
        int id = loginResponse
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
        assertNotEquals(0,id);
        return id;
    }

    public void checkCreated(ValidatableResponse response) {
        boolean created = response
            .assertThat()
            .statusCode(201)
            .extract()
            .path("ok");
        assertTrue(created);
    }

    public void deleted(ValidatableResponse response) {
        boolean deleted = response
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
        assertTrue(deleted);

    }
    public void checkDuplicateError(ValidatableResponse response){
        String message = response
                .assertThat()
                .statusCode(409)
                .extract()
                .path("message");
        assertEquals(message,"Этот логин уже используется");
    }
    public void checkBadRequestCreate(ValidatableResponse response){
        String message = response
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
        assertEquals(message,"Недостаточно данных для создания учетной записи");
    }

    public void checkBadRequestLogin(ValidatableResponse response){
        String message = response
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
        assertEquals(message,"Недостаточно данных для входа");
    }
    public void checkNotFoundLogin(ValidatableResponse response){
        String message = response
                .assertThat()
                .statusCode(404)
                .extract()
                .path("message");
        assertEquals(message,"Учетная запись не найдена");
    }
}
