import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        s=s.toLowerCase();
        String[] arr = s.split("");
        // System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++) {
            if (i==0) arr[i]=arr[i].toUpperCase();
            if (arr[i].equals(" ")) {
                if (i+1>=arr.length) continue;
                arr[i+1]=arr[i+1].toUpperCase();
            }
        }
        String answer = "";
        for(String str : arr) {
            answer+=str;
        }
        return answer;
    }
}