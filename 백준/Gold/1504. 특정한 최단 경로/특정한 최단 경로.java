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
		int num;
		int w;

		public Node(int num, int w) {
			this.num = num;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	static final int INF = Integer.MAX_VALUE;
	static int n, e, a, b, c, v1, v2;
	static int[] dist;
	static boolean[] visited;
	static List<Node>[] list;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점의 개수
		e = Integer.parseInt(st.nextToken()); // 간선의 수

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // a정점부터
			b = Integer.parseInt(st.nextToken()); // b정점까지
			c = Integer.parseInt(st.nextToken()); // 거리가 c
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c)); // 양방향
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		dist = new int[n + 1];

		// 1-v1-v2-n
		dijk(1);
		int one = dist[v1];
		dijk(v1);
		int two = dist[v2];
		dijk(v2);
		int three = dist[n];

		// 1-v2-v1-n
		dijk(1);
		int first = dist[v2];
		dijk(v2);
		int second = dist[v1];
		dijk(v1);
		int third = dist[n];

		if (one == INF || two == INF || three == INF)
			System.out.println(-1);
		else {
			int sum1 = one + two + three;
			int sum2 = first + second + third;
			System.out.println(Math.min(sum1, sum2));
		}

	} // main

	public static void dijk(int x) {
		Arrays.fill(dist, INF);
		dist[x] = 0;
		pq.add(new Node(x, dist[x]));

		while (!pq.isEmpty()) {
			Node out = pq.poll();

			// 지났던 정점과 간선을 또 지나도 되므로 방문처리 필요 없음!

			for (Node n : list[out.num]) {
				if (dist[n.num] > dist[out.num] + n.w) {
					dist[n.num] = dist[out.num] + n.w;
					pq.add(new Node(n.num, dist[n.num]));
				}
			}
		}
	} // dijk
}
