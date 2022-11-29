package spineapp.backend.services;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratePassword {

    /**
     * Generates new random password.
     * @return
     * Returns randomly generated password.
     */
    public static String generateNewPassword(){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 15, characters );
        return pwd;
    }

}
