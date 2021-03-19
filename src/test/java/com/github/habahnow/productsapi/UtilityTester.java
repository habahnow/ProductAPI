package com.github.habahnow.productsapi;

import com.github.habahnow.productsapi.utility.Utility;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class UtilityTester {
    //TODO: probably use mockito to mock a thrown constraint vioalation since i would otherwise
    // create a clase that impleements the constraint violation.
    @Test
    public void isNestedConstraintViolationTrue(){
//        Exception exception = new Exception("Outer exception", new Exception("Inner Exception",
//                new ConstraintViolationException("ConstraintViolation set")));
//        assertTrue(Utility.isNestedConstraintViolation(exception));

        //TODO: use BDDMockito
        //TODO: mock contstraintViolationException, and mock constraintviolation. DONE
        //TODO: given for ConstraintViolationException for getConstraintVIolations will return set
        //      that contains contraintViolation.
        //TODO: given for constraintViolation getMessage() and getInvalidValue() needs to be set.
        ConstraintViolationException exception = mock(ConstraintViolationException.class);
        ConstraintViolation mockedViolation = mock(ConstraintViolation.class);




        Set<ConstraintViolation<?>> violations = new HashSet<>();

        given(mockedViolation.getPropertyPath()).willReturn("something");
        violations.add(mockedViolation);
        given(exception.getContraintViolations()).willReturn(violations);

        ResponseEntity<Object> response = controllerAdvice.handleContraintViolation(exception, webRequest);

        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));

    }
}
