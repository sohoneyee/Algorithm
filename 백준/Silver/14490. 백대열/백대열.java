import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), ":");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int gcd = 0; // 최대공약수
		for (int i = Math.min(n, m); i >= 1; i--) {
			if (n % i == 0 && m % i == 0) {
				gcd = i;
				break;
			}
		}
		
		System.out.println(n / gcd + ":" + m / gcd);

	} // main
}
