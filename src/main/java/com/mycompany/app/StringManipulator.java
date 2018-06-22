package com.mycompany.app;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class StringManipulator
{

    static final String filterNonAlphaRegex = "[^A-Za-z]";

    public static String cleanString(final String str) {
        assert(str !=null);
        return str.replaceAll(filterNonAlphaRegex, "").toUpperCase();
    }

    public static Boolean hasUniqueChars(final String word){
        assert(word !=null);
        char[] alphaString = cleanString(word).toCharArray();
        Arrays.sort(alphaString);
        for(int i=0; i<alphaString.length-1; i++)
        {
            if (alphaString[i] == alphaString[i+1])
                return false;
        }
        return true;
    }

    public static float getWeight(final String word) {
        assert(word !=null);
        int weight =0;
        String alphaString= word.replaceAll(filterNonAlphaRegex, "").toUpperCase();
        for (char c : alphaString.toCharArray()) {
         weight = weight + (int)c;
        }
        return ((float) weight/(float) alphaString.length());
    }

    static class StringWeightCompartor implements Comparator<String> {

        public int compare(String o1, String o2) {
            if (getWeight(o1) > getWeight(o2))
                    return 1;
            else if (getWeight(o1) < getWeight(o2))
                return -1;
            else
                return 0;
        }
    }

    public static String[] sortStrings(final String[] words){
        String[] sortedWords = words;
        Arrays.sort(sortedWords, new StringWeightCompartor());
        return sortedWords;
    }

    public static void main( String[] args ) {

        String[] input = {"RED", "APPLE", "BLUE", "COMPUTER"};

        Stream.of(input).forEach(x -> {
            System.out.println(x +", " + hasUniqueChars(x) + "," + getWeight(x));
        });


    }
}
