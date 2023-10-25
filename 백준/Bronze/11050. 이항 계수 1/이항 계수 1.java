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

		if (k > n / 2)
			k = n - k;

		int ans = 1;
		for (int i = 0; i < k; i++) {
			ans *= (n - i);
		}
		int divide = 1;
		for (int i = 1; i < k; i++) {
			divide *= (i + 1);
		}

		System.out.println(ans / divide);
	} // main

}
