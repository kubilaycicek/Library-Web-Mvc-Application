package com.kubilaycicek.mylib.bootstrap;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.service.AuthorService;
import com.kubilaycicek.mylib.service.BookService;
import com.kubilaycicek.mylib.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, PublisherService publisherService, BookService bookService) {
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        PublisherDto publisher = new PublisherDto();
        publisher.setName("İş Bankası Kültür Yayınları");
        publisher.setDescription("Türkiye İş Bankası kuruluşudur.");
        PublisherDto publisherDTO = publisherService.addPublisher(publisher);

        PublisherDto publisher2 = new PublisherDto();
        publisher2.setName("Yapı Kredi Yayınları");
        publisher2.setDescription("Yapı Kredi Bankası kuruluşudur.");
        publisherService.addPublisher(publisher2);

        AuthorDto author = new AuthorDto();
        author.setName("William Shakespeare");
        author.setDescription("İngiliz oyun yazarı.");
        authorService.addAuthor(author);

        AuthorDto author2 = new AuthorDto();
        author2.setName("Jane Austen");
        author2.setDescription("19 yüzyıl İngiliz kadın yazarı.");
        authorService.addAuthor(author2);

        BookDto book = new BookDto();
        book.setName("Aşk ve Gurur");
        book.setIsbnNumber("1234");
        book.setSerialName("Serial Name");
        book.setSubName("Sub Name");
        book.setAuthorDto(author2);
        book.setPublisherDto(publisher2);
        bookService.addBook(book);

        BookDto book2 = new BookDto();
        book2.setName("Aşk ve Gurur");
        book2.setIsbnNumber("1234");
        book2.setSerialName("Serial Name");
        book2.setSubName("Sub Name");
        book2.setAuthorDto(author);
        book2.setPublisherDto(publisher);
        bookService.addBook(book2);


    }
}
