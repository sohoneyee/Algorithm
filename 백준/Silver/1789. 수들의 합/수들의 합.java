import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long n = Long.parseLong(br.readLine());
		long sum = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			cnt++;
			if (sum > n)
				break;
		}
		if (cnt == 1)
			System.out.println(1);
		else
			System.out.println(cnt - 1);
	}
}