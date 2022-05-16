package pl.springCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.springCMS.dao.AuthorDao;
import pl.springCMS.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;


    @Override
    public Author convert(String id) {
        return authorDao.findById(Long.valueOf(id));
    }
}
