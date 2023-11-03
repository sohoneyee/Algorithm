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
	static boolean[] visited;
	static List<Integer> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList<Integer>();
		visited = new boolean[10001];
		choose = new int[m];

		st = new StringTokenizer(br.readLine());
		int input = Integer.parseInt(st.nextToken());
		visited[input] = true;
		list.add(input);
		for (int i = 1; i < n; i++) {
			input = Integer.parseInt(st.nextToken());
			if (visited[input])
				continue;
			visited[input]=true;
			list.add(input);
		}
		Collections.sort(list);

		comb(0, 0);
		System.out.println(sb);
	} // main

	public static void comb(int idx, int cidx) {
		if (cidx == m) {
			for (int c : choose) {
				sb.append(c).append(" ");
			}
			sb.append("\n");
			return;
		}
		if (idx == list.size())
			return;

		choose[cidx]=list.get(idx);
		comb(idx, cidx + 1);
		comb(idx+1, cidx);
	} // comb
}
