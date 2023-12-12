import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] tree = new int[n];
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}

		int gcd = 0;
		for (int i = 0; i < n - 1; i++) {
			int gap = tree[i + 1] - tree[i];
			gcd = Euclidean(gap, gcd);
		}

		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += (tree[i + 1] - tree[i]) / gcd - 1;
		}
		System.out.println(sum);
	} // main

	public static int Euclidean(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	} // euclidean
}
