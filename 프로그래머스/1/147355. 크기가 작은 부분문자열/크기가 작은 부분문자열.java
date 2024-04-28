class Solution {
    public int solution(String t, String p) {
        int n = p.length();
        String[] arr = t.split("");
        long pLong = Long.parseLong(p);
        
        int answer = 0;
        for(int i=0; i<=t.length()-n; i++) {
            String str = t.substring(i,i+n);
            long num = Long.parseLong(str);
            if (num<=pLong) {
                answer++;
            }
        }
        return answer;
    }
}