package ru.skvorec.pe;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;


public class BigIntegerHelperTest {

    @DataProvider
    public Object[][] sqrts() {
        BigInteger big = new BigInteger("123456789123456789");
        return new Object[][]{
                {BigInteger.ZERO, BigInteger.ZERO},
                {BigInteger.ONE, BigInteger.ONE},
                {new BigInteger("49"), new BigInteger("7")},
                {new BigInteger("50"), new BigInteger("7")},
                {big.multiply(big), big},
                {big.multiply(big).add(BigInteger.ONE), big},
        };
    }

    @Test(dataProvider = "sqrts")
    public void sqrt(BigInteger number, BigInteger sqrt){
        Assert.assertEquals(BigIntegerHelper.sqrt(number), sqrt);
    }
}
