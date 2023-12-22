import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int[][] receipt = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			receipt[i][0] = Integer.parseInt(st.nextToken());
			receipt[i][1] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += receipt[i][0] * receipt[i][1];
		}
		if (sum == x)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}