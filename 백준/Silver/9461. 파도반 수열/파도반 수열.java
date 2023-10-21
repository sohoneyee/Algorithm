import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			long[] tri = new long[101];
			tri[1] = 1;
			tri[2] = 1;
			tri[3] = 1;
			for (int i = 4; i < 101; i++) {
				tri[i] = tri[i - 3] + tri[i - 2];
			}

			System.out.println(tri[n]);
		}

	} // main
}
