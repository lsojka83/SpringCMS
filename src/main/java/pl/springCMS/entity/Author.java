package pl.springCMS.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Zadanie 2
//
//    Utwórz encje o nazwie Author.
//    Encja ma zawierać następujące pola:
//
//    id
//    firstName
//    lastName

//    Dla encji Author ustaw następujące ograniczenia:
//
//    firstName - pole wymagane
//    lastName - pole wymagane

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
