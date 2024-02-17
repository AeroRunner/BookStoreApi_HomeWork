package api;

import models.AddBookRequestModel;
import models.AddBookResponseModel;
import models.IsbnBookModel;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static specification.Specifications.*;

public class BooksApi {
    public static void deleteAllBooks(String token, String userId) {
        given(testRequest)
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .log().all()
                .spec(deleteAllBooksResponse);
    }

    public static AddBookResponseModel addBooks(String token, String userId) {
        ArrayList books = new ArrayList<>();
        books.add(new IsbnBookModel("9781449325862"));
        AddBookRequestModel dataBook = new AddBookRequestModel();
        dataBook.setCollectionOfIsbns(books);
        dataBook.setUserId(userId);

        return given(testRequest)
                .header("Authorization", "Bearer " + token)
                .body(dataBook)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .log().all()
                .spec(addBooksResponse)
                .extract().as(AddBookResponseModel.class);
    }
}
