package pl.springCMS.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Zadanie 1
//
//    Otwórz IDE a następnie utwórz w nim projekt o nazwie SpringCMS.
//    Utwórz encje o nazwie Category.
//    Encja ma zawierać następujące pola:
//
//    id
//    name
//    description (może przyjmować wartość null)

//Zadanie 1
//
//    Dla encji Category ustaw następujące ograniczenia:
//
//    name - minimum 5 znaków, pole wymagane
//

//
//    Dla encji Article ustaw następujące ograniczenia:
//


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=5)
    @NotBlank
    private String name;
    @Column(nullable = true)
    private String description;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category() {
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
