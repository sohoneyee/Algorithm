import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 시작점 위치 찾기
        int start_x=0; int start_y=0;
        int pr = park.length;
        int pc = park[0].length();
        loop: for(int i=0; i<pr; i++) {
            for(int j=0; j<pc; j++) {
                if (park[i].charAt(j)=='S') {
                    start_x=i;
                    start_y=j;
                    break loop;
                }
            }
        }
        
        // 이동하기
        int rr = routes.length;
        int nr = -1; int nc=-1;
        looptwo: for(int i=0; i<rr; i++) {
            switch (routes[i].charAt(0)) {
                case 'E':
                    nr = start_x;
                    nc = start_y+(routes[i].charAt(2)-'0');
                    if (nr<0||nr>=pr||nc<0||nc>=pc) continue;
                    for(int j=start_y; j<=nc; j++) {
                        if (park[start_x].charAt(j)=='X') continue looptwo;
                    }
                    start_x = nr;
                    start_y = nc;
                    break;
                case 'S':
                    nr = start_x+(routes[i].charAt(2)-'0');
                    nc = start_y;
                    if (nr<0||nr>=pr||nc<0||nc>=pc) continue;
                    for(int j=start_x; j<=nr; j++) {
                        if (park[j].charAt(start_y)=='X') continue looptwo;
                    }
                    start_x = nr;
                    start_y = nc;
                    break;
                case 'W':
                    nr = start_x;
                    nc = start_y-(routes[i].charAt(2)-'0');
                    if (nr<0||nr>=pr||nc<0||nc>=pc) continue;
                    for(int j=start_y; j>=nc; j--) {
                        if (park[start_x].charAt(j)=='X') continue looptwo;
                    }
                    start_x = nr;
                    start_y = nc;
                    break;
                case 'N':
                    nr = start_x-(routes[i].charAt(2)-'0');
                    nc = start_y;
                    if (nr<0||nr>=pr||nc<0||nc>=pc) continue;
                    for(int j=start_x; j>=nr; j--) {
                        if (park[j].charAt(start_y)=='X') continue looptwo;
                    }
                    start_x = nr;
                    start_y = nc;
                    break;
            }
        }
        int[] answer = new int[] {start_x, start_y};
        return answer;
    }
}