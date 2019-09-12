package com.jiaflu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jiaflu.graphql.entity.Author;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {
    private static Map<Integer, Author> authorMap = new HashMap<>();
    static {
        authorMap.put(1, new Author(1, "moyan", 55));
        authorMap.put(2, new Author(2, "yikaifu", 50));
        authorMap.put(3, new Author(3, "liuqing", 40));
    }

    public Author findAuthor(Integer id) {
        return authorMap.get(id);
    }
}
