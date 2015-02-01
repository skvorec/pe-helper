package ru.skvorec.pe;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import static ru.skvorec.pe.Utils.*;

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

    @DataProvider
    public Object[][] factorizations() {
        return new Object[][]{
                {7l, aTreeMap("7=>1")},
                {8l, aTreeMap("2=>3")},
                {9l, aTreeMap("3=>2")},
                {10l, aTreeMap("2=>1,5=>1")},
                {12l, aTreeMap("2=>2,3=>1")},
                {32l, aTreeMap("2=>5")},
        };
    }

    @Test(dataProvider = "factorizations")
    public void primeFactorization(Long prime, SortedMap<Long, Integer> etalonFactors) {
        CachedPrimeHelper helper = new CachedPrimeHelper();
        SortedMap<Long, Integer> actualFactors = helper.primeFactorization(prime);
        Assert.assertEquals(actualFactors, etalonFactors, "For prime " + prime);
    }
}
