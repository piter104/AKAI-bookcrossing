package pl.akai.bookcrossing.model;

import lombok.*;

@Data
@Builder
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
