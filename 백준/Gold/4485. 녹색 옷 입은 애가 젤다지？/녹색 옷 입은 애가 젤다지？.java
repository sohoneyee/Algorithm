import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x;
	int y;
	int w;

	public Node(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
} // class

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = 1; // 출력을 위한 변수
		while (true) {
			int n = Integer.parseInt(br.readLine()); // 그래프의 크기

			// 0이 나오면 테케 끝 -> 루프 탈출
			if (n == 0)
				break;

			int[][] map = new int[n][n]; // 지도
			int[][] dist = new int[n][n]; // 최소 손실루피 담을 배열
			boolean[][] visited = new boolean[n][n]; // 방문처리
			PriorityQueue<Node> pq = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE; // 다익스트라를 위한 초기화
				}
//				System.out.println(Arrays.toString(map[i]));
			}
			dist[0][0] = map[0][0];
			pq.add(new Node(0, 0, dist[0][0])); // 시작점에서의 손실루피로 add

			while (!pq.isEmpty()) {
				Node nd = pq.poll();
				int r = nd.x; // 현재 행
				int c = nd.y; // 현재 열
				int w = nd.w; // 현재 손실루피
                
                // 기저조건
				if (r == n - 1 && c == n - 1) {
					System.out.println("Problem " + k + ": " + dist[r][c]);
				}

				int[] dr = { 0, 1, 0, -1 };
				int[] dc = { 1, 0, -1, 0 };
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d]; // 이동할 행
					int nc = c + dc[d]; // 이동할 열
					if (nr < 0 || nr >= n || nc < 0 || nc >= n)
						continue;
					if (visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					if (dist[nr][nc] > dist[r][c] + map[nr][nc]) { // 갱신
						dist[nr][nc] = dist[r][c] + map[nr][nc];
						pq.add(new Node(nr, nc, dist[nr][nc])); // add
					}
				}
			} // while
			k++;
		} // tc while
	} // main
}