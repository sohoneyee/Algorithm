import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int rupee;

		public Node() {
		}

		public Node(int x, int y, int rupee) {
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", rupee=" + rupee + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.rupee - o.rupee;
		}
	} // node

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			int[][] map = new int[n][n];
			int[][] dist = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			PriorityQueue<Node> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			dist[0][0] = map[0][0];
			pq.add(new Node(0, 0, dist[0][0]));
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			while (!pq.isEmpty()) {
				Node out = pq.poll();
				int r = out.x;
				int c = out.y;
				int w = out.rupee;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;
					if (visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						pq.add(new Node(nr, nc, dist[nr][nc]));
					}
				}
			} // while
			System.out.println("Problem " + k + ": " + dist[n - 1][n - 1]);
			k++;
		} // tc
	} // main
}