import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board) {
        int n=board.length;
        boolean[][] visited = new boolean[n][n];
        int[] dr = new int[] {0,1,1,1,0,-1,-1,-1};
        int[] dc = new int[] {1,1,0,-1,-1,-1,0,1};
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (board[i][j]==1) {
                    visited[i][j]=true;
                    for(int d=0; d<8; d++) {
                        int nr=i+dr[d];
                        int nc=j+dc[d];
                        if (nr<0||nr>=n||nc<0||nc>=n) continue;
                        visited[nr][nc]=true;
                    }
                }
            }
        }

        int answer = n*n;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (visited[i][j]) answer--;
            }
        }

        return answer;
    }
}