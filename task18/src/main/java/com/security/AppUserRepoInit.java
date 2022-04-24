package com.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class AppUserRepoInit implements CommandLineRunner {
    private AppUserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AtomicLong counter = new AtomicLong();

    @Autowired
    public AppUserRepoInit(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Insert users");
        this.userRepository.deleteAll();
        AppUser user = new AppUser(counter.incrementAndGet(), "dan", passwordEncoder.encode("pass"));
        userRepository.save(user);
    }
}
