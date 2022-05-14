package pl.springCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.springCMS.dao.CategoryDao;
import pl.springCMS.entity.Category;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String id) {
        return categoryDao.findById(Long.parseLong(id));
    }
}
