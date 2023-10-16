import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
} // class

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[v].add(new Node(e, w));
		} // 입력 끝

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작점
		int end = Integer.parseInt(st.nextToken()); // 도착점

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0; // 시작점까지의 비용은 0

		pq.add(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			int now = pq.poll().index;

			if (now == end) { // 도착점에 도달하면 출력 후 루프 탈출
				System.out.println(dist[end]);
				break;
			}

			if (visited[now])
				continue;
			visited[now] = true;
			for (Node node : list[now]) {
				if (dist[node.index] > dist[now] + node.cost) { // 갱신
					dist[node.index] = dist[now] + node.cost;
					pq.add(new Node(node.index, dist[node.index]));
				}
			}
		}

	} // main
}