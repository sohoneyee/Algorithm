import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fact(n));
	}

	public static int fact(int x) {
		if (x == 0)
			return 1;
		if (x == 1)
			return x;

		return x * fact(x - 1);
	} // fact
}