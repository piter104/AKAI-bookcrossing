package pl.akai.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private User owner;
    private User reader;
<<<<<<< HEAD
=======
    private List<Tag> tagList = new ArrayList<>();
>>>>>>> b20192104aac97dfedbfbc6b91234462c031d1d1
}
