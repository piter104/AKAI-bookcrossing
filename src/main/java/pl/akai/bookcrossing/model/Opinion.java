package pl.akai.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {
    private int id;
    private int rating;
    private String description;
    private User author;
}
