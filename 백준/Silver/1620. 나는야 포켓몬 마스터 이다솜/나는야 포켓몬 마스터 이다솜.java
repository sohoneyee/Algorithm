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
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> mapString = new HashMap<>();
		Map<Integer, String> mapInteger = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			mapString.put(str, i + 1);
			mapInteger.put(i + 1, str);
		}
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (mapString.containsKey(str))
				sb.append(mapString.get(str)).append("\n");
			else
				sb.append(mapInteger.get(Integer.parseInt(str))).append("\n");
		}
		System.out.println(sb);
	} // main
}