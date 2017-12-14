package com.lab.test.annotationFeature;

import java.util.List;

/**
 * Created by elotoma on 2017/12/12.
 */
public class PasswordUtils {

    @UseCase(id=47, decription = "password must contain at least onr numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id=48)
    public String encryptPassword(String password) {
        return new StringBuffer(password).reverse().toString();
    }

    @UseCase(id=49, decription = "new password can't equal previous used ones")
    public boolean checkForNewPassword(List<String> prePasswords, String password) {
        return !prePasswords.contains(password);
    }
}
