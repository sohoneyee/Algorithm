import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int w;

		public Node() {
		}

		public Node(int from, int to, int w) {
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	} // node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

		// 인접리스트
		List<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(a, b, c));
			list[b].add(new Node(b, a, c));
		} // 입력 끝

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		visited[1] = true; // 시작정점 1로 세팅
		int pick = 1; // 하나 뽑아두고 시작
		int ans = 0;

		for (Node node : list[1]) {
			pq.add(node);
		}

		while (pick != n) {
			Node out = pq.poll();
			
			if (visited[out.to])
				continue;
			
			ans += out.w;
			pick++;
			pq.addAll(list[out.to]);
			visited[out.to] = true;
		}
		
		System.out.println(ans);

	} // main
}
