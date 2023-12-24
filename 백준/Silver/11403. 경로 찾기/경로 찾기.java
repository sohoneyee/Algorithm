import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] adj = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		// i->j에서 가는 길 = i->k->j로 가는 길
		// 이미 입력으로 한 번에 갈 수 있는 경로는 입력해놨으므로 중간 경유지가 있는 경우를 1로 바꿔주면 됨!
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (adj[i][k] + adj[k][j] > 1) {
						adj[i][j] = 1;
//						System.out.println("adj[i][j]: " + i + "," + k + "," + j + ": " + adj[i][j]);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(adj[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	} // main
}