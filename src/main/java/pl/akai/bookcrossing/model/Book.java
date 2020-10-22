package pl.akai.bookcrossing.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private Integer ownerId;
    private Integer currentOwnerId;
}
