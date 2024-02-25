class Solution {
    public int solution(int n) {
        long[] fibo = new long[100001];
        fibo[0]=0L;
        fibo[1]=1L;
        for(int i=2; i<n+1; i++) {
            fibo[i]=(fibo[i-1]%1234567+fibo[i-2]%1234567)%1234567;
        }
        return (int) fibo[n];
    }
}