package apiEndpoints;

import java.util.Random;
import java.util.UUID;

public class Utilities {
	
	// String randomEmail = "user_" + UUID.randomUUID().toString() + "@gmail.com";
	
    // Method to generate a random string of given length
    public String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

}
