import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 단어의 개수
		int m = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준

		// <영단어, 빈도 수>를 담는 map 선언
		// TreeMap으로 선언하여 사전순 정렬을 갖고 들어감 -> list에서도 유지됨
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() < m)
				continue;
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		// map의 정렬기준을 다시 잡기 위해 Entry를 요소로 갖는 list로 변환
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// 빈도순
				if (o1.getValue() - o2.getValue() > 0)
					return -1;
				else if (o1.getValue() - o2.getValue() == 0) {
					// 빈도수가 같다면 단어의 길이순
					return o2.getKey().length() - o1.getKey().length();
				} else
					return 1;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Entry<String, Integer> e : list) {
			sb.append(e.getKey()).append("\n");
		}
		System.out.println(sb);

	} // main
}
