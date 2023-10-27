import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(fact(n));
	} // main

	public static long fact(int x) {
		if (x == 0 || x == 1) return 1;
		return x * fact(x - 1);
	} // fact
}
