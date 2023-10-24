import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long GCD; // 1000000이 100개 주어지면 조합의 수는 엄청 많음
	static int[] num, choose;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 수의 개수
			num = new int[n]; // 입력 받을 배열
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			} // 입력 끝

			choose = new int[2]; // 가능한 모든 쌍 골라내기 위함
			GCD = 0; // 최대공약수 초기화

			comb(0, 0);
			System.out.println(GCD);
		} // tc
	} // main

	public static void comb(int idx, int cidx) {
		if (cidx == 2) {
			// 쌍 골라냈을 때마다 그 때의 최대공약수 더해주기
			for (int i = Math.min(choose[0], choose[1]); i >= 1; i--) {
				if (choose[0] % i == 0 && choose[1] % i == 0) {
					GCD += i;
					break;
				}
			}
			return;
		}
		if (idx == n)
			return;

		choose[cidx] = num[idx];
		comb(idx + 1, cidx + 1);
		comb(idx + 1, cidx);

	} // comb
}
