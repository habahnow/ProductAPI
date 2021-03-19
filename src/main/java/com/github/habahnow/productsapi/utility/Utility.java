package com.github.habahnow.productsapi.utility;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

public class Utility {
    public static boolean isNestedConstraintViolation(Exception exception){
        Throwable throwInstance = exception.getCause();

        while ((throwInstance != null) &&
                !(throwInstance instanceof ConstraintViolationException)) {
            throwInstance = throwInstance.getCause();
        }

        if (throwInstance instanceof ConstraintViolationException) {
            return true;
        }
        return false;
    }
    public static String getNestedConstraintViolationMessages(Exception exception){
        Throwable throwInstance = exception.getCause();
        StringBuilder builder = new StringBuilder();

        while ((throwInstance != null)
                && !(throwInstance instanceof ConstraintViolationException)) {
            throwInstance = throwInstance.getCause();
        }

        if (throwInstance instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> set =
                    ((ConstraintViolationException) throwInstance).getConstraintViolations();
            Iterator<ConstraintViolation<?>> iterator = set.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<?> violation = iterator.next();
                builder.append(violation.getMessage());
                if(violation.getInvalidValue() == null){
                    builder.append(" Problem Value: No value provided. ");
                }
                else {
                    builder.append(" Problem value: " + violation.getInvalidValue() + ". ");
                }
            }
        }

        return builder.toString();

    }

}
