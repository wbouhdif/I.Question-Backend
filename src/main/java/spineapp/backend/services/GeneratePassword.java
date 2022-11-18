package spineapp.backend.services;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratePassword {

    public String generateNewPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 15, characters );
        return pwd;
    }


    private static GeneratePassword instance;
    public static GeneratePassword getInstance() {
        if (instance == null) {
            instance = new GeneratePassword();
        }
        return instance;
    }

}
