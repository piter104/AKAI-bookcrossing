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
public class BookFormResponse {
    private List<Integer> existingTagsList = new ArrayList<>();
    private String newTags;
}
