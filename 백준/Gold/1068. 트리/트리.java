import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, remove;
	static int[] node;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		node = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		remove = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			if (i == remove)
				continue;
			if (node[i] != -1)
				list[node[i]].add(i);
		}

		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (list[i].size() != 0)
				visited[i] = true;
		}

		dfs(remove);

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				cnt++;
		}

		System.out.println(cnt);
	} // main

	public static void dfs(int x) {
		visited[x] = true;
		for (int c : list[x]) {
			int tmp = c;
			dfs(tmp);
		}
		list[x].clear();
	} // dfs
}