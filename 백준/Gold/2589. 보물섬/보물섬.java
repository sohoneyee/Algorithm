import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, max, ans;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static String[][] map;
	static boolean[][] visited;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도의 가로
		m = Integer.parseInt(st.nextToken()); // 지도의 세로

		map = new String[n][m]; // 지도
		q = new LinkedList<>(); // 큐

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = str[j];
			}
		} // 입력 끝

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j].equals("L")) { // 육지라면 bfs 진행
					q.add(new int[] { i, j, 0 });
					visited = new boolean[n][m];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	} // main

	public static void bfs(int r, int c) {
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] out = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = out[0] + dr[d]; // 다음 행
				int nc = out[1] + dc[d]; // 다음 열
				int time = out[2] + 1; // 걸리는 시간
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (visited[nr][nc] || map[nr][nc].equals("W"))
					continue;
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc, time });
				max = Math.max(time, max);
			}
		}
	} // bfs
	
}