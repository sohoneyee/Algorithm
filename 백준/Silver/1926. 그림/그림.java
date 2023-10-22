import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, area;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] paper;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		paper = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(paper[i]));
		}

		int painting = 0;

		visited = new boolean[n][m];
		int max = 0; // 아무런 그림이 없을 때 0으로 나와야 하므로 integer.minvalue는 안됨
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (paper[i][j] == 1) {
					if (!visited[i][j])
						painting++; // 그림의 개수
					area = 1; // 처음 시작점도 넓이에 포함되어야 하므로 1로 초기화
					dfs(i, j);
					max = Math.max(area, max); // 최대 넓이 구하기
				}
			}
		}
		System.out.println(painting);
		System.out.println(max);

	} // main

	public static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (paper[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					area++;
					dfs(nr, nc);
				}
			}
		}
	} // dfs
}
