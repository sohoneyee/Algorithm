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
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			String name = st.nextToken();
			String ex = st.nextToken();
			if (map.containsKey(ex)) map.put(ex, map.get(ex) + 1);
			else map.put(ex, 1);
		}
		for (String key : map.keySet()) {
			int value = map.get(key);
			System.out.print(key + " " + value);
			System.out.println();
		}
	} // main
}