import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int p = 2; // 지우지 않은 수 중 가장 작은 소수
		boolean[] num = new boolean[n + 1];

		loop: while (p <= n) {
			for (int i = 2; i <= n; i++) {
				if (num[i]) // 이미 지운 수라면 continue
					continue;
				if (i % p == 0) { // n까지의 수 중에 c로 나눠진다면
					num[i] = true; // true
					k--;
					if (k == 0) { // k번째 수가 지워지면 출력
						System.out.println(i);
						break loop;
					}
				}
			}
			p++; // p
		}
	} // main
}
