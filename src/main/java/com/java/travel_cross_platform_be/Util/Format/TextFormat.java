package com.java.travel_cross_platform_be.Util.Format;
import org.springframework.stereotype.Component;

@Component
public class TextFormat {
    public String replaceDoubleSpacesAndTrim(String input) {
        String singleSpace = input.replaceAll("\\s{2,}", " ");
        return singleSpace.trim();
    }
}
