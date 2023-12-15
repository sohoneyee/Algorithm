import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node() {
		}

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	} // node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		long original = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			original += c;
			list[a].add(new Node(a, b, c));
			list[b].add(new Node(b, a, c));
		} // 입력 끝

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		pq.addAll(list[1]);

		int pick = 1;
		long ans = 0;

		while (pick != n) {
			if (pq.isEmpty()) break;
			
			Node out = pq.poll();
			if (visited[out.to]) continue;

			pick++;
			ans += out.cost;
			visited[out.to] = true;
			pq.addAll(list[out.to]);
		}

		boolean flag = true;
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println(original - ans);
		else
			System.out.println(-1);
	} // main
}
