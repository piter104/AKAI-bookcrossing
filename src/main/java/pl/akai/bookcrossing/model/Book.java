package pl.akai.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private BookFormResponse response;
    private List<Tag> tagList = new ArrayList<>();
    public void addTag(Tag tag) {
        this.tagList.add(tag);
    }
}
