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
		int to;
		int time;

		public Node() {
		}

		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	} // node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 마을의 수
		int m = Integer.parseInt(st.nextToken()); // 단방향 도로의 수
		int x = Integer.parseInt(st.nextToken()); // 파티하는 마을

		List<Node>[] list = new ArrayList[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][] dist = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, w));
		} // 입력 끝

		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		// 다익스트라
		for (int i = 1; i < n + 1; i++) {
			boolean[] visited = new boolean[n + 1];
			dist[i][i] = 0;

			pq.add(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node out = pq.poll();
//				System.out.println(out+","+visited[out.to]);
				if (visited[out.to])
					continue;

				visited[out.to] = true;
				for (Node node : list[out.to]) {
					if (dist[i][node.to] > dist[i][out.to] + node.time) {
						dist[i][node.to] = dist[i][out.to] + node.time;
						pq.add(new Node(node.to, dist[i][node.to]));
					}
				}
			} // while
		} // for

//		for (int j = 0; j < n + 1; j++) {
//			System.out.println(Arrays.toString(dist[j]));
//		}

		int sum = 0;
		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			sum = dist[i][x] + dist[x][i]; // x마을로 갔다가 다시 내 마을로 돌아와야 함
			max = Math.max(sum, max);
		}
		
		System.out.println(max);
	} // main
}