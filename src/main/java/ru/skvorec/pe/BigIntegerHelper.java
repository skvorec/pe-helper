package ru.skvorec.pe;

import java.math.BigInteger;
import static java.math.BigInteger.*;

public class BigIntegerHelper {
    private static final BigInteger TWO = new BigInteger("2");

    public static BigInteger sqrt(BigInteger n){
//        System.out.println("finding sqrt " + n);
        BigInteger current = ONE;
        BigInteger next = current.add(n.divide(current)).divide(TWO);
//        System.out.println("current: " + current);
//        System.out.println("next: " + next);
        while(next.add(current.negate()).abs().compareTo(ONE) > 0){
            current = next;
            next = current.add(n.divide(current)).divide(TWO);
//            System.out.println("current: " + current);
//            System.out.println("next: " + next);
        }
        return next;
    }
}
