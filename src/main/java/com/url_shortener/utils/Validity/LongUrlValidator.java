package com.url_shortener.utils.Validity;

import com.url_shortener.config.LongUrlConfig;
import com.url_shortener.exception.UrlValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

//TODO UrlValidator International symbol check
@Component
@RequiredArgsConstructor
public class LongUrlValidator {
    private final LongUrlConfig longUrlConfig;

    public void validate(String url) throws UrlValidationException {
        if (url.length() >= longUrlConfig.SIZE_UPPER_BOUND) {
            throw new UrlValidationException(String.format("URL size is too big (should be less than %s): %s", longUrlConfig.SIZE_UPPER_BOUND, url));
        }

        if (url.length() < longUrlConfig.SIZE_LOWER_BOUND) {
            throw new UrlValidationException(String.format("URL size is too big (should be less than %s): %s", longUrlConfig.SIZE_LOWER_BOUND, url));
        }

        if (!UrlValidator.getInstance().isValid(url)) {
            throw new UrlValidationException("URL is not valid (if valid contact developer)");
        }
    }
}
