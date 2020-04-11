package com.kubilaycicek.mylib.bootstrap;

import com.kubilaycicek.mylib.entity.Role;
import com.kubilaycicek.mylib.entity.User;
import com.kubilaycicek.mylib.repository.RoleRepository;
import com.kubilaycicek.mylib.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
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
        userNormal.setEmail("normaluser");
        userNormal.setUsername("normaluser");
        userNormal.setPassword(bCryptPasswordEncoder.encode("1234"));
        userNormal.setRole(roleUser);
        userNormal.setName("kubilay");
        userNormal.setSurname("cicek");
        userRepository.save(userNormal);
        System.out.println("Normal User" + userNormal);
    }
}
