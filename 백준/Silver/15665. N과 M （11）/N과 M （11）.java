import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] choose;
	static List<Integer> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n개의 수 중에서
		m = Integer.parseInt(st.nextToken()); // 중복을 허용하여 m개를 뽑는다

		// 같은 숫자를 또 뽑아도 되지만 중복되는 수열이 여러번 출력되는 것은 불가능 -> 애초에 입력리스트에 담지 말자!
		list = new ArrayList<>();
		choose = new int[m];
		boolean[] visited = new boolean[10001]; // 방문처리로 담지 말자

		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		visited[first] = true;
		list.add(first);
		loop: for (int i = 1; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (visited[input]) continue loop;
			list.add(input);
			visited[input] = true;
		}
		Collections.sort(list); // 사전순 출력을 위해 정렬

		perm(0);
		System.out.println(sb);

	} // main

	public static void perm(int idx) { // 중복순열
		if (idx == m) {
			for (int c : choose) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			choose[idx] = list.get(i);
			perm(idx + 1);
		}
	} // perm
}
