package pl.akai.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookFormResponse extends Book {
    private Set<Integer> existingTagsIdList = new HashSet<>();
    private String newTagsNames;

    public void addTagId(Integer tagId) {
        this.existingTagsIdList.add(tagId);
    }
}
