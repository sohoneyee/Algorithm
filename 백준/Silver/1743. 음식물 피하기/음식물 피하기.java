import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] condo = new int[n + 1][m + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			condo[r][c] = 1;
		}

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n + 1][m + 1];
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int ans = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (condo[i][j] == 0) continue;
				int cnt = 1;
				q.add(new int[] { i, j });
				visited[i][j] = true;

				while (!q.isEmpty()) {
					int[] out = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = out[0] + dr[d];
						int nc = out[1] + dc[d];
						if (nr < 1 || nr > n || nc < 1 || nc > m) continue;
						if (visited[nr][nc] || condo[nr][nc] == 0) continue;
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc });
						cnt++;
					}
				} // while
				ans = Math.max(cnt, ans);
			}
		}
		System.out.println(ans);
	} // main
}