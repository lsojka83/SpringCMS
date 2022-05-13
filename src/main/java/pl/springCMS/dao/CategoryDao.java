package pl.springCMS.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.springCMS.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;



    public void save(Category entity)
    {
        entityManager.persist(entity);
    }

    public void delete(Category entity)
    {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void update(Category entity)
    {
        entityManager.merge(entity);
    }

    public List<Category> findAll()
    {
        return entityManager.createQuery("SELECT a FROM Category a")
                .getResultList();
    }

    public Category findById(Long id)
    {
        return entityManager.find(Category.class, id);
    }

}
