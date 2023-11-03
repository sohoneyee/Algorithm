import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min, sum;
	static int[] nums, choose;
	static boolean[] visited;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()); // 도시의 수
		nums = new int[n]; // 도시 1~n번까지
		choose = new int[n]; // 순열 배열
		visited = new boolean[n]; // 한번 간 도시는 다시 갈 수 없으므로 방문처리 배열
		for (int i = 0; i < n; i++) {
			nums[i] = i; // 1~n이지만 0~n-1로 담았음
		}

		adj = new int[n][n]; // 도시끼리의 관계 인접행렬
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끗

		min = Integer.MAX_VALUE; // 최소 비용
		perm(0);
		System.out.println(min);

	} // main

	public static void perm(int idx) {
		if (idx == n) {
			sum = 0;
			// choose=[0,3,2,1]일 경우 adj[0][3]+adj[3][2]+adj[2][1]+adj[1][0]을 구해야 함
			for (int i = 0; i < n - 1; i++) { 
				// 길이 없다면 다음 순열로 넘어가자
				if (adj[choose[i]][choose[i + 1]]==0) return;
				sum += adj[choose[i]][choose[i + 1]];
			}
			// adj[1][0]은 따로 더해주기
			// 이 경우에도 길이 없으면 다음 순열로 넘어가기
			if (adj[choose[n - 1]][choose[0]]==0) return;
			sum += adj[choose[n - 1]][choose[0]];
			min = Math.min(min, sum); // 최솟값 갱신
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				choose[idx] = nums[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	} // perm
}
