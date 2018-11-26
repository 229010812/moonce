package com.moonce.user;

import com.moonce.user.util.id.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private IdWorker idWorker;

    @Test
    public void contextLoads() {
        long time = new Date().getTime();
//        IdWorker idWorker = new IdWorker(0, 0);
        for (int i = 0; i < 100; i++) {
            long id = idWorker.nextId();
            System.out.println(id);
        }

        System.out.println(time - new Date().getTime());
    }

}
