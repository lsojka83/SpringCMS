package pl.springCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springCMS.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

}
