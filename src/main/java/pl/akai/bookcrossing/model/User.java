package pl.akai.bookcrossing.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class User {
    private int id;
    private String firstName;
    private String surname;
}
