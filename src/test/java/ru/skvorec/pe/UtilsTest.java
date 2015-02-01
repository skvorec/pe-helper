package ru.skvorec.pe;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedMap;
import java.util.TreeMap;

public class UtilsTest {

    @Test
    public void aTreeMap(){
        SortedMap<Long, Integer> etalonMap = new TreeMap<>();
        etalonMap.put(2l, 3);
        Assert.assertEquals(etalonMap, Utils.aTreeMap("2=>3"));
        etalonMap.put(5l, 1);
        Assert.assertEquals(etalonMap, Utils.aTreeMap("2=>3,5=>1"));

    }
}
