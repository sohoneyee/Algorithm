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
		int distance;

		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "Node [num=" + num + ", distance=" + distance + "]";
		}
	}

	static int n, m, x, y, z;
	static int[] dist;
	static boolean[] visited, flag;
	static List<Node>[] list;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		} // 입력 끝

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()); // 시작점
		y = Integer.parseInt(st.nextToken()); // 중간 정점
		z = Integer.parseInt(st.nextToken()); // 끝정점

		pq = new PriorityQueue<>();
		flag = new boolean[n + 1]; // y를 안 들리도록 하기 위한 방문처리 배열
		StringBuilder sb = new StringBuilder();

		// y를 거쳐서 최단 거리
		dijk(x);
		int fromXtoY = dist[y];
		dijk(y);
		int fromYtoZ = dist[z];
		if (fromXtoY == Integer.MAX_VALUE || fromYtoZ == Integer.MAX_VALUE)
			sb.append(-1).append(" ");
		else
			sb.append(fromXtoY + fromYtoZ + " ");

		// y를 안 거치고 최단 거리
		flag[y] = true; // y를 방문처리해서 안 들리도록
		dijk(x);
		int fromXtoZ = dist[z];
		if (fromXtoZ == Integer.MAX_VALUE)
			sb.append(-1).append(" ");
		else
			sb.append(fromXtoZ);

		System.out.println(sb);
	} // main

	public static void dijk(int r) {
		visited = new boolean[n + 1]; // 방문처리 배열
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[r] = 0;
		pq.add(new Node(r, dist[r]));

		while (!pq.isEmpty()) {
			Node out = pq.poll();
			if (visited[out.num])
				continue;

			visited[out.num] = true;
			for (Node curr : list[out.num]) {
				// y를 거치지 않고 가야하는 경우
				if (flag[curr.num])
					continue;
				if (dist[curr.num] > dist[out.num] + curr.distance) {
					dist[curr.num] = dist[out.num] + curr.distance;
					pq.add(new Node(curr.num, dist[curr.num]));
				}
			}
//			System.out.println(Arrays.toString(dist));

		}
	} // dijk

}