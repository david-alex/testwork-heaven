package com.david.varga.pages.element;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardTest
{
    @Test
    public void testFormFieldsNotNull() {
        CreditCard creditCard = new CreditCard.Builder().build();

        Assert.assertNotNull("Credit Card name is null", creditCard.getCcName());
        Assert.assertNotNull("Credit card number is null", creditCard.getCcNumber());
        Assert.assertNotNull("Credit card month is null", creditCard.getCcMonth());
        Assert.assertNotNull("Credit card year is null", creditCard.getCcYear());
        Assert.assertNotNull("Credit card security code is null", creditCard.getCcSecurityNumber());
        Assert.assertNotNull("Credit card amount is null", creditCard.getCcAmount());
    }

    @Test
    public void testNumber() {
        String number = "2211";
        CreditCard creditCard = new CreditCard.Builder().ccNumber(number).build();

        Assert.assertEquals("Credit Card number mismatch", creditCard.getCcNumber(),String.valueOf(number));
    }


    @Test
    public void testAmount() {
        double amount = 22.14;
        CreditCard creditCard = new CreditCard.Builder().ccAmount(amount).build();

        Assert.assertEquals("Credit Card amounts mismatch", creditCard.getCcAmount(),String.valueOf(amount));
    }

    @Test
    public void testName() {
        String name = "Mr Brightside";
        CreditCard creditCard = new CreditCard.Builder().ccName(name).build();

        Assert.assertEquals("Credit Card names mismatch", creditCard.getCcName(),name);
    }

    @Test
    public void testMonth() {
        String month = "06";
        CreditCard creditCard = new CreditCard.Builder().ccMonth(month).build();

        Assert.assertEquals("Credit Card months mismatch", creditCard.getCcMonth(),String.valueOf(month));
    }

    @Test
    public void testYear() {
        String year = "22";
        CreditCard creditCard = new CreditCard.Builder().ccYear(year).build();

        Assert.assertEquals("Credit Card years mismatch", creditCard.getCcYear(),String.valueOf(year));
    }

    @Test
    public void testSecurityNumber() {
        String secNumber = "987";
        CreditCard creditCard = new CreditCard.Builder().ccSecurityNumber(secNumber).build();

        Assert.assertEquals("Credit Card security numbers mismatch", creditCard.getCcSecurityNumber(),String.valueOf(secNumber));
    }
}
