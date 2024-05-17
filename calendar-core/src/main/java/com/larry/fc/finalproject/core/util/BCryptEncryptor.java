package com.larry.fc.finalproject.core.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * @author Larry
 */
@Component
public class BCryptEncryptor implements Encryptor {
    @Override
    public String encrypt(String origin) {
        return BCrypt.hashpw(origin, BCrypt.gensalt());
    }

    @Override
    public boolean isMatch(String origin, String hashed) {
        try {
            return BCrypt.checkpw(origin, hashed);
        } catch (Exception e) { // 여러 예외가 있다.
            return false;
        }
    }
}
