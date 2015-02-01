package ru.skvorec.pe;

import java.util.SortedMap;
import java.util.TreeMap;

public class Utils {
    public static SortedMap<Long, Integer> aTreeMap(String str){
        SortedMap<Long, Integer> result = new TreeMap<>();
        String[] split;
        if(!str.contains(",")){
            split = new String[]{str};
        }   else {
            split = str.split(",");
        }
        for(String part: split){
            String key = part.substring(0, part.indexOf("="));
            String value = part.substring(part.indexOf(">") + 1);
            result.put(Long.parseLong(key), Integer.parseInt(value));
        }
        return result;
    }
}
