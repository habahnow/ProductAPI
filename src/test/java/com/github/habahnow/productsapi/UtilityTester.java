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

    @Test
    public void hasNestedConstraintViolationTrue() {
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
    public void getNestedConstraintViolationsNone(){

        Exception exception = new Exception("exception");

        Set<ConstraintViolation<?>> answer = Utility.getNestedConstraintViolations(exception);

        assertNull(answer);
    }

    @Test
    public void getViolationMessages1(){
        ConstraintViolation mockedConstraintViolation =
                mock(ConstraintViolation.class);
        Set<ConstraintViolation<?>> set = new HashSet<>();
        set.add(mockedConstraintViolation);
        given(mockedConstraintViolation.getMessage()).willReturn("Error Message");
        given(mockedConstraintViolation.getInvalidValue()).willReturn(20L);

        String actual = Utility.getViolationMessages(set);

        assertEquals("Error Message Problem value: 20. " , actual);
    }

    @Test
    public void getViolationMessages3(){

        ConstraintViolation mockedConstraintViolation1 =
                mock(ConstraintViolation.class);
        ConstraintViolation mockedConstraintViolation2 =
                mock(ConstraintViolation.class);
        ConstraintViolation mockedConstraintViolation3 =
                mock(ConstraintViolation.class);
        Set<ConstraintViolation<?>> set = new HashSet<>();
        set.add(mockedConstraintViolation1);
        set.add(mockedConstraintViolation2);
        set.add(mockedConstraintViolation3);
        given(mockedConstraintViolation1.getMessage()).willReturn("Error Message1");
        given(mockedConstraintViolation2.getMessage()).willReturn("Error Message2");
        given(mockedConstraintViolation3.getMessage()).willReturn("Error Message3" );
        given(mockedConstraintViolation1.getInvalidValue()).willReturn(10L);
        given(mockedConstraintViolation2.getInvalidValue()).willReturn(20L);
        given(mockedConstraintViolation3.getInvalidValue()).willReturn(30L);

        String actual = Utility.getViolationMessages(set);

        //Since the method getViolationMessages uses a set iterator (which has a random order),
        // i remove each expected code section so that the resulting string is empty
        actual = actual.replace("Error Message1 Problem value: 10. ", "");
        actual = actual.replace("Error Message2 Problem value: 20. ", "");
        actual = actual.replace("Error Message3 Problem value: 30. ", "");

        assertEquals("", actual);
    }

    @Test
    public void getViolationMessagesNull(){
        ConstraintViolation mockedConstraintViolation =
                mock(ConstraintViolation.class);
        Set<ConstraintViolation<?>> set = new HashSet<>();
        set.add(mockedConstraintViolation);
        given(mockedConstraintViolation.getMessage()).willReturn("Null value was provided");
        given(mockedConstraintViolation.getInvalidValue()).willReturn(null);

        String actual = Utility.getViolationMessages(set);

        assertEquals("Null value was provided Problem value: No value provided. "
                , actual);
    }

    @Test
    public void getViolationMessagesEmpty(){
        ConstraintViolation mockedConstraintViolation =
                mock(ConstraintViolation.class);
        Set<ConstraintViolation<?>> set = new HashSet<>();
        set.add(mockedConstraintViolation);
        given(mockedConstraintViolation.getMessage()).willReturn("No value was provided");
        given(mockedConstraintViolation.getInvalidValue()).willReturn(new String(""));

        String actual = Utility.getViolationMessages(set);

        assertEquals("No value was provided Problem value: No value provided. "
                , actual);
    }

}
