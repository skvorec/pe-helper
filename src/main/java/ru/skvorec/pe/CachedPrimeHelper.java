package ru.skvorec.pe;

import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class CachedPrimeHelper {
    private long maxBound = 1;
    private NavigableSet<Long> primes = new TreeSet<>();

    public NavigableSet<Long> getPrimes(long to) {
        findTo(to);
        return primes.headSet(to, true);
    }


    public SortedMap<Long, Integer> primeFactorization(long number) {
        SortedMap<Long, Integer> result = new TreeMap<>();
        findTo(number);
        if (primes.contains(number)) {
            result.put(number, 1);
            return result;
        }
        NavigableSet<Long> candidates = primes.headSet((long) Math.sqrt(number), true);

        for (Long prime : candidates) {
            if (number % prime == 0) {
                int current = (result.get(prime) == null) ? 0 : result.get(prime);
                result.put(prime, current + 1);
                number = number / prime;
                if (number == 1) {
                    break;
                }
                if (primes.contains(number)) {
                    current = (result.get(number) == null) ? 0 : result.get(number);
                    result.put(number, current + 1);
                    return result;
                }
            }
        }

        return result;
    }

    private void findTo(long bound) {
        for (long candidate = maxBound + 1; candidate <= bound; candidate++) {
            long sqrt = (long) Math.sqrt(candidate);
            boolean wasDivision = false;
            for (Long prime : primes) {
                if (sqrt < prime) {
                    break;
                }
                if (candidate % prime == 0) {
                    wasDivision = true;
                    break;
                }
            }
            if (!wasDivision) {
                primes.add(candidate);
            }
        }
        maxBound = bound;
    }
}
