package pl.akai.bookcrossing.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Opinion {
    private int id;
    private int rating;
    private String description;
    private int bookId;
    private  int authorId;
}
