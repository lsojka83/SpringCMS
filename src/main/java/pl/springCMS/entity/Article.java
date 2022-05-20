package pl.springCMS.entity;

import pl.springCMS.converter.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//Zadanie 3
//
//    Utwórz encję Article,
//    Encja ma zawierać następujące pola:
//
//    id
//    title (max. 200 znaków),
//    author - (powiązanie relacją do klasy Author) - artykuł może mieć tylko jednego autora
//    categories - (powiązanie relacją do klasy Category) - artykuł może należeć do wielu kategorii
//    content
//    created (wartość ma być automatycznie dodawana podczas zapisu)
//    updated (wartość ma być automatycznie zmieniana podczas edycji).

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    private String content;
    @ManyToOne
    private Author author;
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Category> categories;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime updated;

    public Article() {
    }

    public Article(String title) {
        this.title = title;
    }

    @PrePersist
    public void prePersist()
    {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate()
    {
        updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", categories=" + categories +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
