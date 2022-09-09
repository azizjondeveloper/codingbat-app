package uz.pdp.codingbat.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.pdp.codingbat.controller.AuthController;
import uz.pdp.codingbat.controller.LanguageController;

import java.text.Normalizer;
import java.util.Objects;
import java.util.regex.Pattern;

public interface RestConstants {

    String[] OPEN_PAGES = {
            "/**",
            AuthController.AUTH_CONTROLLER_BASE_PATH + "/**",
            LanguageController.LANGUAGE_CONTROLLER_BASE_PATH+"/**"
    };

    Pattern NON_LATIN = Pattern.compile("[^\\w-]");
    Pattern WHITESPACE = Pattern.compile("[\\s]");
    Pattern EDGES_DASHES = Pattern.compile("(^-|-$)");

    ObjectMapper objectMapper = new ObjectMapper();


    /**
     * @param input String
     * @return
     */
    static String makeUrl(String input) {
        if (Objects.isNull(input))
            throw new IllegalArgumentException("For make url given input must not be null");

        String nonWhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nonWhitespace, Normalizer.Form.NFD);
        String slug = NON_LATIN.matcher(normalized).replaceAll("");
        slug = EDGES_DASHES.matcher(slug).replaceAll("");
        return slug.toLowerCase();
    }


    static String objectToJSON(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
