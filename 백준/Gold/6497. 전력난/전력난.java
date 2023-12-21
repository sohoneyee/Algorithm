import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node() {
		}

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	} // node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 집의 수
			int n = Integer.parseInt(st.nextToken()); // 길의 수

			if (m == 0 && n == 0)
				break; // 무한루프 탈출

			List<Node>[] list = new ArrayList[m];
			for (int i = 0; i < m; i++) {
				list[i] = new ArrayList<>();
			}

			int total = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				total += c;
				list[a].add(new Node(b, c));
				list[b].add(new Node(a, c));
			} // 입력 끝

			// 프림
			boolean[] visited = new boolean[m];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			visited[0] = true;
			pq.addAll(list[0]);
			int pick = 1;
			int ans = 0;

			while (pick != m) {
				Node out = pq.poll();
				if (visited[out.index])
					continue;
				visited[out.index] = true;
				pq.addAll(list[out.index]);
				pick++;
				ans += out.cost;
			}

			System.out.println(total - ans);
		} // tc
	} // main
}