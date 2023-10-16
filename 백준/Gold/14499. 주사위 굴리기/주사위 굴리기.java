import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// `원래 ````` 동 ````` 서 ````` 북 ````` 남
	// ``0`````` 0 ````` 0 ````` 1 ````` 3
	// 4 1 5 ` 3 4 1 ` 1 5 3 ` 4 2 5 ` 4 0 5
	// ``2`````` 2`````` 2`````` 3`````` 1
	// ``3`````` 5`````` 4`````` 0`````` 2

	// 상단index=1, 하단index=3

	// 조건 : 칸=0 -> down숫자가 칸에 복사, 칸!=0 -> 칸숫자가 down에 복사되고 칸=0
	// 주사위의 첫 좌표에 해당하는 칸은 무조건 0인가봐

	static int n, m, x, y, up, down;
	static int[][] map;
	static int[] dice;

	// 방향이 4까지 있으므로 크기 5로 만듦
	static int[] dr = { 0, 0, 0, -1, 1 }; // 동서북남
	static int[] dc = { 0, 1, -1, 0, 0 }; // 동서북남

	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		x = Integer.parseInt(st.nextToken()); // 주사위 x좌표
		y = Integer.parseInt(st.nextToken()); // 주사위 y좌표
		int k = Integer.parseInt(st.nextToken()); // 명령 개수

		map = new int[n][m];
		dice = new int[6];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(st.nextToken()); // 방향

//			System.out.println(".");
			copy(dir);
//			System.out.println(dir + " " + "dice:" + Arrays.toString(dice));

			if (flag)
				System.out.println(dice[1]);
		} // for

	} // main

	public static void copy(int d) {
		flag = true;
		int nr = x + dr[d];
		int nc = y + dc[d];

		// 범위 벗어나면 해당 명령 무시 & 출력도 X
		// 칸이 0인지 아닌지 조건에 대한 코드를 tumble로 넘겨서 명령을 무시하도록 함
		if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
//			System.out.println("no");
			flag = false;
			return;
		}

		x = nr;
		y = nc;
		tumble(x, y, d);

	} // copy

	// 원래 {0,1,2,3,4,5}
	// 1동 {0,4,2,5,3,1}
	// 2서 {0,5,2,4,1,3}
	// 3북 {1,2,3,0,4,5}
	// 4남 {3,0,1,2,4,5}
	public static void tumble(int x, int y, int d) {
		int tmp = dice[1];
		switch (d) {
		case 1: // 동
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = tmp;
			break;
		case 2: // 서
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = tmp;
			break;
		case 3: // 북
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[0];
			dice[0] = tmp;
			break;
		case 4: // 남
			dice[1] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = tmp;
			break;
		}

		// 원래 copy에 넣었었는데 그러면 범위를 벗어날 경우 명령을 무시하지 못하므로 아예 여기에 넣음!
		if (map[x][y] == 0)
			map[x][y] = dice[3];
//		if (map[x][y] != 0) { // 얘는 틀리는 이유가 멀까?????????
		else {
			dice[3] = map[x][y];
			map[x][y] = 0;
		}
	} // tumble
}
