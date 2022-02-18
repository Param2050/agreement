package com.agreemenet.utils;

import com.agreemenet.exceptions.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class ExceptionUtil {

    public ExceptionUtil() {
    }

    public static void validateNotEmpty(String str, String message) throws ValidationException {
        if(StringUtils.isEmpty(str)) {
            throw new ValidationException(message);
        }
    }
}
