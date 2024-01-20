import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        st = new StringTokenizer(today, ".");
        // 오늘 날짜
        int year=Integer.parseInt(st.nextToken()); // 연도
        int month=Integer.parseInt(st.nextToken()); // 월
        int day=Integer.parseInt(st.nextToken()); // 일

        int n = privacies.length;
        int[][] check = new int[n][3]; // 개인정보 수집일자
        String[] alpha = new String[n]; // 개인정보 약관 종류
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(privacies[i], ".| ");
            for(int j=0; j<3; j++) {
                check[i][j]=Integer.parseInt(st.nextToken());
            }
            alpha[i]=st.nextToken();
        }
        
        int m = terms.length;
        String[][] rule = new String[m][2]; // 약관종류와 유효기간
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(terms[i], " ");
            rule[i][0]=st.nextToken();
            rule[i][1]=st.nextToken();
        }
        
        // 개인정보 수집일자 유효기간 계산하기
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                if (alpha[i].equals(rule[k][0])) {
                    check[i][1]+=Integer.parseInt(rule[k][1]);
                    if (check[i][1]%12!=0) { // 더해준 월이 24일 수도 있으므로 %로 따지기
                        check[i][0]+=check[i][1]/12;
                        check[i][1]=check[i][1]%12;
                    } else {
                        check[i][0]+=check[i][1]/12-1;
                        check[i][1]=12;
                    }
                    if (check[i][2]-1==0) {
                        check[i][2]=28;
                        check[i][1]-=1;
                    } else check[i][2]-=1;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(check[i][j]+ " ");
            }
            System.out.println();
        }
        // 파기해야 할 개인정보 구하기. 개인정보는 1번부터 시작함.
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if (year>check[i][0]) list.add(i+1);
            else if (year==check[i][0]) {
                if (month>check[i][1]) list.add(i+1);
                else if (month==check[i][1]) {
                    if (day>check[i][2]) list.add(i+1);
                    else continue;
                } else continue;
            } else continue;
        }
        
        // 정답
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i]=list.get(i);
        }
        return answer;
    }
}