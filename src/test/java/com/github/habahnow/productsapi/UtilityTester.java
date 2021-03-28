package com.github.habahnow.productsapi;

import com.github.habahnow.productsapi.utility.Utility;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class UtilityTester {
    //TODO: probably use mockito to mock a thrown constraint vioalation since i would otherwise
    // create a clase that impleements the constraint violation.
    @Test
    public void hasNestedConstraintViolationTrue(){
//        Exception exception = new Exception("Outer exception", new Exception("Inner Exception",
//                new ConstraintViolationException("ConstraintViolation set")));
//        assertTrue(Utility.isNestedConstraintViolation(exception));

        //TODO: use BDDMockito
        //TODO: mock contstraintViolationException, and mock constraintviolation. DONE
        //TODO: given for ConstraintViolationException for getConstraintVIolations will return set
        //      that contains contraintViolation.
        //TODO: given for constraintViolation getMessage() and getInvalidValue() needs to be set.
        ConstraintViolationException constraintException = mock(ConstraintViolationException.class);
        ConstraintViolation mockedViolation = mock(ConstraintViolation.class);

        Set<ConstraintViolation<?>> violations = new HashSet<>();
        violations.add(mockedViolation);

        Exception exception = new Exception("Outer Exception" , new Exception("Middle Exception",
                new Exception("Inner Exception" , constraintException)));

        boolean answer = Utility.hasNestedConstraintViolation(exception);

        assertTrue(answer);
/*
        given(mockedViolation.getMessage()).willReturn("Please include the import price");
        given(mockedViolation.getInvalidValue()).willReturn(null);
        given(exception.getConstraintViolations()).willReturn(violations);

        Set<ConstraintViolation<?>> violations = new HashSet<>();

        given(mockedViolation.getPropertyPath()).willReturn("something");
        violations.add(mockedViolation);
        given(exception.getContraintViolations()).willReturn(violations);

        ResponseEntity<Object> response = controllerAdvice.handleContraintViolation(exception, webRequest);

        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));

 */

    }
}
