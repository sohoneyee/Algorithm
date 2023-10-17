import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<String> s = new HashSet<>(); // treeset은 오름차순으로 담아짐
		Set<String> ans = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (s.contains(str))
				ans.add(str);
		}
		
		// set은 인덱스로 조회가 안되므로 iterator에 담아 next로 조회, 출력해야 함
		Iterator<String> it = ans.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append(ans.size()).append("\n");
		while (it.hasNext()) {
			sb.append(it.next()).append("\n");
		}
		System.out.println(sb);

	} // main
}
