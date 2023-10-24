import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = 0; // 최대공약수
		int lcm = a; // 최소공배수, 최소공배수는 a나 b를 약수로 함(필수)
		for (int i = Math.min(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				break;
			}
		}

		// a*b = lcm*gcd -> lcm = a*(b/gcd)
		lcm *= b / gcd;

		System.out.println(gcd);
		System.out.println(lcm);
	} // main
}
