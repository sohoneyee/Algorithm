import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));

	} // main

	public static int fibo(int x) {
		if (x <= 1)
			return x;

		return fibo(x - 1) + fibo(x - 2);
	} // fibo
}
