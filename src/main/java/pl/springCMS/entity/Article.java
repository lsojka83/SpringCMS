package pl.springCMS.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    @ManyToOne
    private Author author;
    @OneToMany (fetch = FetchType.EAGER)
    private List<Category> categories;
    LocalDate created;
    LocalDate updated;

    public Article() {
    }

    public Article(String title) {
        this.title = title;
    }

    @PrePersist
    public  void prePersist()
    {
        created = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate()
    {
        updated = LocalDate.now();
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", categories=" + categories +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
