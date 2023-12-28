import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			String name = st.nextToken();
			String ex = st.nextToken();
			if (map.containsKey(ex)) map.put(ex, map.get(ex) + 1);
			else map.put(ex, 1);
		}
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			int value = map.get(key);
			sb.append(key).append(" ").append(value).append("\n");
		}
		System.out.println(sb);
	} // main
}