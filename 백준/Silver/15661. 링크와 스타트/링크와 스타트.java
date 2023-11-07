import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, min, k;
	static int[] num, choose;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}

		num = new int[n];
		choose = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			num[i] = i;
		}

		min = Integer.MAX_VALUE;
		k = 0;
		while (k < n) {
			comb(0, 0);
			k++;
		}

		System.out.println(min);
	} // main

	public static void comb(int idx, int cidx) {
		int start = 0;
		int link = 0;

		if (cidx == k) {
			for (int i = 0; i < n - 1; i++) {
				for (int j = i; j < n; j++) {
					if (visited[i] && visited[j]) {
						start += map[i][j];
						start += map[j][i];
					}
					if (!visited[i] && !visited[j]) {
						link += map[i][j];
						link += map[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(start - link));

			return;
		}
		if (idx == n) {
			return;
		}

		choose[cidx] = num[idx];
		visited[choose[cidx]] = true;
		comb(idx + 1, cidx + 1);
		visited[choose[cidx]] = false;
		comb(idx + 1, cidx);

	} // comb

}
