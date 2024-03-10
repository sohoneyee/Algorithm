import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer=new int[2];
        while(!s.equals("1")) {
            String str="";
            String[] arr = s.split("");
            for(String r:arr) {
                if (r.equals("0")) {
                    answer[1]++;
                    continue;
                }
                str+=r;
            }
            s=Integer.toBinaryString(str.length())+"";
            answer[0]++;
        }
        return answer;
    }
}