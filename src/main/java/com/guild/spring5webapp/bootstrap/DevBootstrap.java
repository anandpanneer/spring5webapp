package com.guild.spring5webapp.bootstrap;

import com.guild.spring5webapp.model.Address;
import com.guild.spring5webapp.model.Author;
import com.guild.spring5webapp.model.Book;
import com.guild.spring5webapp.model.Publisher;
import com.guild.spring5webapp.repositories.AddressRepository;
import com.guild.spring5webapp.repositories.AuthorRepository;
import com.guild.spring5webapp.repositories.BookRepository;
import com.guild.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private AddressRepository addressRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Author author = new Author("Eric", "Evans");
        Address address1 = new Address("baby nagar", "velachery", "india", "60003");
        Publisher publisher1 = new Publisher("Harper Collins", address1);
        Book book1 = new Book("Domain Driven Design", "123", publisher1);
        author.getBooks().add(book1);
        book1.getAuthors().add(author);

        addressRepository.save(address1);
        publisherRepository.save(publisher1);
        authorRepository.save(author);
        bookRepository.save(book1);

        Address address2 = new Address("nagar", "chennai", "india", "6000302");
        Publisher publisher2 = new Publisher("Worx", address2);
        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE development without EJB", "2334", publisher2);
        rod.getBooks().add(book2);

        addressRepository.save(address2);
        publisherRepository.save(publisher2);
        authorRepository.save(rod);
        bookRepository.save(book2);
    }
}
