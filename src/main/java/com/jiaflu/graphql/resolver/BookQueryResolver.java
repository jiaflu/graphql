package com.jiaflu.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jiaflu.graphql.entity.Author;
import com.jiaflu.graphql.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {
    private static Map<Integer, Book> bookMap = new HashMap<>();

    public List<Book> findBooks() {
        Author author = new Author(1, "Bill Venners", 40);
        Book book = new Book(1, "scala编程第三版", author, "电子工业出版社");
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        return bookList;
    }

}
