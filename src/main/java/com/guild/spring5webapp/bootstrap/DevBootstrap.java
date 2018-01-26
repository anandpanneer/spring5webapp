package com.guild.spring5webapp.bootstrap;

import com.guild.spring5webapp.model.Author;
import com.guild.spring5webapp.model.Book;
import com.guild.spring5webapp.repositories.AuthorRepository;
import com.guild.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Author author = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123", "Harper Collins");
        author.getBooks().add(book1);
        book1.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book1);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE development without EJB", "2334", "Worx");
        rod.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
