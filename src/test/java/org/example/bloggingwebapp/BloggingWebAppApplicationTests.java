package org.example.bloggingwebapp;

import org.example.bloggingwebapp.Repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BloggingWebAppApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void repoTest()
    {
        String className = this.userRepo.getClass().getName();
        System.out.println(className);
        String packName=this.userRepo.getClass().getPackageName();
        System.out.println(packName);
    }



}
