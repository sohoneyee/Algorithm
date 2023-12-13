import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node1967 {
	int to;
	int w;

	public Node1967() {
	}

	public Node1967(int to, int w) {
		this.to = to;
		this.w = w;
	}

	@Override
	public String toString() {
		return "Node [to=" + to + ", w=" + w + "]";
	}
} // node

public class Main {
	static int n, max;
	static List<Node1967>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int plus = Integer.parseInt(st.nextToken());
			list[start].add(new Node1967(end, plus));
			list[end].add(new Node1967(start, plus));
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			dfs(i, 0);
		}
		System.out.println(max);

	} // main

	public static void dfs(int x, int depth) {
		visited[x] = true;

		for (Node1967 node : list[x]) {
			if (visited[node.to])
				continue;
			dfs(node.to, depth + node.w);
		}
		max = Math.max(max, depth);
	} // bfs

}
