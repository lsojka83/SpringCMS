package pl.springCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springCMS.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

//Zadanie 1
//
//    W klasach ArticleDao, AuthorDao, CategoryDao dodaj metody, które przy użyciu JPQL umożliwią pobieranie wszystkich obiektów danego typu.

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;



    public void save(Article entity)
    {
        entityManager.persist(entity);
    }

    public void delete(Article entity)
    {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void update(Article entity)
    {
        entityManager.merge(entity);
    }

    public List<Article> findAll()
    {
        return entityManager.createQuery("SELECT a FROM Article a")
                .getResultList();
    }

    public List<Article> getLatestFive()
    {
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created")
                .setMaxResults(5).getResultList();

    }

    public Article findById(Long id)
    {
        return entityManager.find(Article.class, id);
    }

}
