import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] babbling) {
        int n = babbling.length;
        int answer = 0;
        String[] str = new String[] {"aya", "ye", "woo", "ma"};
        for(int i=0; i<n; i++) {
            for(int j=0; j<4; j++) {
                babbling[i] = babbling[i].replace(str[j], "@");
            }
        }
        for(int i=0; i<n; i++) {
            babbling[i] = babbling[i].replace("@", "");
            if (babbling[i].equals("")) answer++;
        }
        // System.out.println(Arrays.toString(babbling));
        return answer;
    }
}