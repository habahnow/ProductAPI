package com.github.habahnow.productsapi.utility;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

public class Utility {
    public static boolean hasNestedConstraintViolation(Exception exception){
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
    public static Set<ConstraintViolation<?>> getNestedConstraintViolations(Exception exception){
        Throwable throwInstance = exception.getCause();
        StringBuilder builder = new StringBuilder();

        while ((throwInstance != null)
                && !(throwInstance instanceof ConstraintViolationException)) {
            throwInstance = throwInstance.getCause();
        }

        if (throwInstance instanceof ConstraintViolationException) {
            return ((ConstraintViolationException) throwInstance).getConstraintViolations();

        }
        return null;


    }

    public static String getViolationMessages(Set<ConstraintViolation<?>> set){
        StringBuilder builder = new StringBuilder();

        Iterator<ConstraintViolation<?>> iterator = set.iterator();
        while(iterator.hasNext()){
            ConstraintViolation<?> violation = iterator.next();
            builder.append(violation.getMessage());
            if(violation.getInvalidValue() == null){
                builder.append(" Problem Value: No value provided. ");
            }
            else {
                builder.append(" Problem value: " + violation.getInvalidValue() + ". ");
                System.out.println("Invalid Value type: "+  violation.getInvalidValue().getClass());
            }
        }

        return builder.toString();
    }

}
