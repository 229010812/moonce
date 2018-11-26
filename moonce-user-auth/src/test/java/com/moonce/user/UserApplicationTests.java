package com.moonce.user;

import com.moonce.common.util.CommonUtils;
import com.moonce.user.util.IdWorker;
import org.jasypt.encryption.StringEncryptor;
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
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        System.out.println(CommonUtils.getMD5("马路遥"));
        String result = stringEncryptor.encrypt("MLYCloud1788%");
        System.out.println(result);
    }

}
