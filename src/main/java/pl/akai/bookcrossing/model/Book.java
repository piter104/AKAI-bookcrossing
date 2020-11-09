package pl.akai.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Tag> tagList = new HashSet<>();

    public void addTag(Tag tag) {
        this.tagList.add(tag);
    }
}
