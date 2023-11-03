import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, melt, land, time;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] ice;
	static boolean flag;
	static boolean[][] visited, move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열

		ice = new int[n][m]; // 빙산

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (land < 2) {
			land = 0; // 덩어리
			visited = new boolean[n][m]; // 주변이 0일 때 마이너스 해주기 위한 방문처리 배열
			move = new boolean[n][m]; // 덩어리 세주기 위한 방문처리 배열
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && ice[i][j] > 0) {
						dfs(i, j);
					}
				}
			}
//			for (int i = 0; i < n; i++) {
//				System.out.println(Arrays.toString(ice[i]));
//			}
			time++;
			// 1년이 지날 때마다 덩어리 개수 세주기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!move[i][j] && ice[i][j] > 0) {
						count(i, j);
						land++;
					}
				}
			}
			flag = true; // 다 녹기 전에 덩어리가 분리됨

			// 이미 다 0으로 주어져 시간만 흐르거나, 덩어리가 계속 1로 유지되다가 녹아버리는 경우 0으로 출력
			if (land == 0 && time > 0) {
				time = 0;
				break;
			}
		} // while

		System.out.println(time);
	} // main

	public static void dfs(int r, int c) { // 모든 빙산 녹이기
		melting(r, c);
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!visited[nr][nc] && ice[nr][nc] > 0) {
					dfs(nr, nc);
				}
			}
		}
	} // dfs

	public static void melting(int r, int c) { // 0의 개수 세주기
		melt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!visited[nr][nc] && ice[nr][nc] == 0) {
					melt++;
				}
			}
		}
		minus(r, c);
	} // melting

	public static void minus(int r, int c) { // 녹이기
		ice[r][c] -= melt;
		if (ice[r][c] < 0)
			ice[r][c] = 0;
	} // minus

	public static void count(int r, int c) { // 덩어리 카운팅
		move[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!move[nr][nc] && ice[nr][nc] > 0)
					count(nr, nc);
			}
		}
	} // count

}
