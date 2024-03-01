class Solution {
    public int solution(String number) {
        String[] str = number.split("");
        int sum=0;
        for(int i=0; i<str.length; i++) {
            sum+=Integer.parseInt(str[i]);   
        }
        int answer = sum%9;
        return answer;
    }
}