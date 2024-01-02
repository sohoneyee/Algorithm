import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += Integer.parseInt(str[i]);
		}
		System.out.println(ans);
	} // main
}
