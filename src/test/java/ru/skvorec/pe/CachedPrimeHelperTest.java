package ru.skvorec.pe;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class CachedPrimeHelperTest {

    @Test
    public void getPrimes() {
        CachedPrimeHelper helper = new CachedPrimeHelper();
        NavigableSet<Long> primes = helper.getPrimes(3);
        NavigableSet<Long> etalon = new TreeSet<>();
        etalon.add(2l);
        etalon.add(3l);
        Assert.assertEquals(primes, etalon);
        primes = helper.getPrimes(5);
        etalon.add(5l);
        Assert.assertEquals(primes, etalon);
    }

    @Test
    public void primeFactorization() {
        CachedPrimeHelper helper = new CachedPrimeHelper();
        SortedMap<Long, Integer> factors = helper.primeFactorization(7);
        SortedMap<Long, Integer> etalonMap = new TreeMap<>();
        etalonMap.put(7l, 1);
        Assert.assertEquals(factors, etalonMap);
        factors = helper.primeFactorization(10);
        etalonMap = new TreeMap<>();
        etalonMap.put(2l, 1);
        etalonMap.put(5l, 1);
        Assert.assertEquals(factors, etalonMap);
        factors = helper.primeFactorization(12);
        etalonMap = new TreeMap<>();
        etalonMap.put(2l, 2);
        etalonMap.put(3l, 1);
        Assert.assertEquals(factors, etalonMap);
        factors = helper.primeFactorization(9);
        etalonMap = new TreeMap<>();
        etalonMap.put(3l, 2);
        Assert.assertEquals(factors, etalonMap);
    }
}
