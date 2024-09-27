package com.java.travel_cross_platform_be.Util.Authentication;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpUtil {

    public static String generateOtp() {
        Random random = new Random();
        int randomNumber = random.nextInt(9999);
        String output = Integer.toString(randomNumber);

        while (output.length() < 5) {
            output = "0" + output;
        }
        return output;
    }
}