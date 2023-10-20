import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int m, n, k;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int cnt, area; // 영역의 수, 각 영역의 넓이
	static List<Integer> list; // 각 영역의 넓이 담아줄 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 행
		n = Integer.parseInt(st.nextToken()); // 열
		k = Integer.parseInt(st.nextToken()); // 직사각형 개수

		paper = new int[m][n];
		visited = new boolean[m][n];
		list = new ArrayList<Integer>();

		// 좌표 (x,y)를 2차원 배열로 바꿔서 생각해보면 x는 열이 되고 y는 행이 된다.
		// (0,2)와 (4,4)로 직사각형이 주어지면 2차원 배열에서는 [2,0]이상 [4,4]미만이 된다.
		// 주어진 직사각형만큼은 +1씩 해주고 반복문 돌면서 0인 부분의 넓이를 각각 구해주자.
		for (int h = 0; h < k; h++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					paper[i][j]++;
				}
			}
		}

		cnt = 0; // 영역의 수
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && paper[i][j] == 0) {
					area = 1; // 각 영역의 넓이
					cnt++;
//					System.out.println("cnt:" + cnt);
					dfs(i, j);
					list.add(area);
				}
			}
		}
		Collections.sort(list); // 오름차순으로 출력
		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	} // main

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
				if (!visited[nr][nc] && paper[nr][nc] == 0) {
					area++;
					dfs(nr, nc);
				}
			}
		}
	} // dfs

}
