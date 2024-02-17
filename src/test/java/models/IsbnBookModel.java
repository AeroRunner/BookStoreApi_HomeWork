package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class IsbnBookModel {
    public IsbnBookModel(String isbn) {
        this.isbn = isbn;
    }
    private String isbn;
}
