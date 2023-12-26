import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[][] dist = new int[v + 1][v + 1];
		for (int i = 1; i < v + 1; i++) {
			for (int j = 1; j < v + 1; j++) {
				if (i == j) continue;
				dist[i][j] = 4000001;
			}
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = c;
		} // 입력 끝

		for (int k = 1; k < v + 1; k++) {
			for (int i = 1; i < v + 1; i++) {
				for (int j = 1; j < v + 1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < v + 1; i++) {
			for (int j = 1; j < v + 1; j++) {
				if (dist[i][j] + dist[j][i] >= 4000001 || i == j) continue;
				ans = Math.min(ans, dist[i][j] + dist[j][i]);
			}
		}

		if (ans != Integer.MAX_VALUE) System.out.println(ans);
		else System.out.println(-1);
	}
}