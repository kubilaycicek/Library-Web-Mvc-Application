package com.kubilaycicek.mylib.bootstrap;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.entity.Role;
import com.kubilaycicek.mylib.entity.User;
import com.kubilaycicek.mylib.repository.RoleRepository;
import com.kubilaycicek.mylib.repository.UserRepository;
import com.kubilaycicek.mylib.service.AuthorService;
import com.kubilaycicek.mylib.service.BookService;
import com.kubilaycicek.mylib.service.PublisherService;
import com.kubilaycicek.mylib.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        PublisherDto publisher = new PublisherDto();
        publisher.setName("İş Bankası Kültür Yayınları");
        publisher.setDescription("Türkiye İş Bankası kuruluşudur.");
        publisherService.addPublisher(publisher);

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

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleUser.setDescription("Standart User");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleAdmin.setDescription("Admin User");
        roleRepository.save(roleAdmin);

        User user = new User();
        user.setEmail("kubilaycicek");
        user.setUsername("kubilaycicek");
        user.setName("kubilay");
        user.setSurname("cicek");
        user.setRole(roleAdmin);
        user.setPassword(bCryptPasswordEncoder.encode("1234"));
        userRepository.save(user);
        System.out.println("Admin User " + user);

        User userNormal = new User();
        userNormal.setEmail("normaluser@gmail.com");
        userNormal.setUsername("normaluser");
        userNormal.setPassword(bCryptPasswordEncoder.encode("1234"));
        userNormal.setRole(roleUser);
        userNormal.setName("kubilay");
        userNormal.setSurname("cicek");
        userRepository.save(userNormal);
        System.out.println("Normal User" + userNormal);
    }
}
