import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> s = new HashSet<>();
		List<String> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			s.add(str);
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (s.contains(str))
				ans.add(str);
		}

		System.out.println(ans.size());
	}
}
