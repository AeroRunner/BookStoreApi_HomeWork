package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static specification.Specifications.*;

public class AuthorizationApi {
    public static LoginResponseModel authResponse () {
        LoginRequestModel userData = new LoginRequestModel();
        userData.setUserName("AeroRunner8");
        userData.setPassword("Rock2025lan!");

        return
                given(testRequest)
                        .body(userData)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .log().all()
                        .spec(loginResponse)
                        .extract().as(LoginResponseModel.class);
    };
}
