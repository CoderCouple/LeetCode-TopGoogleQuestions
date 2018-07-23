package TopGoogleQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 *
 **/
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {

        char array [] = s.toCharArray();
        int start=0;
        int end=s.length()-1;
        Set<Character> set =new HashSet<Character>();
        set.addAll(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));

        while(start<end){

            while(start<end){
                if(set.contains(array[start]))
                    break;
                start++;
            }

            while(start<end){
                if(set.contains(array[end]))
                    break;
                end--;
            }

            swap(array,start,end);
            start++;
            end--;
        }
        return new String(array);
    }

    public void swap(char [] array,int start,int end){
        char ch = array[start];
        array[start]=array[end];
        array[end]=ch;
    }
}
