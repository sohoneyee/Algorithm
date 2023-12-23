import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> card = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (card.containsKey(a)) card.put(a, card.get(a) + 1);
			else card.put(a, 1);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int b = Integer.parseInt(st.nextToken());
			if (card.get(b) != null) sb.append(card.get(b)).append(" ");
			else sb.append(0).append(" ");
		}
		System.out.println(sb);
	} // main
}