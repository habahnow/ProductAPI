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
    public void hasNestedConstraintViolationTrue() {
//        Exception exception = new Exception("Outer exception", new Exception("Inner Exception",
//                new ConstraintViolationException("ConstraintViolation set")));
//        assertTrue(Utility.isNestedConstraintViolation(exception));

        ConstraintViolationException constraintException = mock(ConstraintViolationException.class);

        Exception exception = new Exception("Outer Exception", new Exception("Middle Exception",
                new Exception("Inner Exception", constraintException)));

        boolean answer = Utility.hasNestedConstraintViolation(exception);

        assertTrue(answer);

    }

   @Test
   public void hasNestedContraintViolationTrue2(){
       ConstraintViolationException constraintException = mock(ConstraintViolationException.class);

       Exception exception = new Exception("Outer Exception", new Exception("Middle Exception",
               new Exception("Inner Exception", new Exception( "2nd inner Exception",
                       new Exception("3rd inner exception" , constraintException)))));

       boolean answer = Utility.hasNestedConstraintViolation(exception);

       assertTrue(answer);
   }

    @Test
    public void hasNestedConstraintViolationTrue3(){
        ConstraintViolationException constraintException = mock(ConstraintViolationException.class);

        Exception exception = new Exception("exception" , constraintException);

        boolean answer = Utility.hasNestedConstraintViolation(exception);

        assertTrue(answer);
    }



    @Test
    public void hasNestedConstraintViolationFalse(){

        Exception exception = new Exception("Outer Exception", new Exception("Middle Exception",
                new Exception("Inner Exception")));

        boolean answer = Utility.hasNestedConstraintViolation(exception);

        assertFalse(answer);
    }

    @Test
    public void getNestedConstraintViolations(){

        ConstraintViolationException mockedConstraintException =
                mock(ConstraintViolationException.class);
        Set<ConstraintViolation<?>> violations = new HashSet<>();
        Exception exception = new Exception("exception" , mockedConstraintException);
        given(mockedConstraintException.getConstraintViolations()).willReturn(violations);

        Set<ConstraintViolation<?>> answer = Utility.getNestedConstraintViolations(exception);

        assertEquals( violations, answer);
    }

    @Test
    public void getNestedConstraintViolationsNull(){

        Exception exception = new Exception("exception");

        Set<ConstraintViolation<?>> answer = Utility.getNestedConstraintViolations(exception);

        assertEquals(null, answer);
    }
/*
/*
        //TODO: create test case for getViolationMEssages
        //TODO: use BDDMockito
        //TODO: mock contstraintViolationException, and mock constraintviolation. DONE
        //TODO: given for ConstraintViolationException for getConstraintVIolations will return set
        //      that contains contraintViolation.
        //TODO: given for constraintViolation getMessage() and getInvalidValue() needs to be set.
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
