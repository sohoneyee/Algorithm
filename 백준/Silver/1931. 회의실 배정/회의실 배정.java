import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 회의의 수

		int[][] conv = new int[n][2]; // 회의 시간 배열
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				conv[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회의 시간 배열 오름차순 정렬 by 종료시간. 종료시간이 같다면 시작시간 오름차순 정렬
		// 원래는 시작시간을 기준으로 오름차순을 했는데 반례가 있음
		// 4 \n 1 2 \n 3 10 \n 4 5 \n 5 6
		Arrays.sort(conv, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] - o2[1] > 0)
					return 1;
				else if (o1[1] - o2[1] < 0)
					return -1;
				else {
					return o1[0] - o2[0];
				}
			}
		});

		int cnt = 0;
		int next = 0;

		// 종료시간 기준으로 정렬했기 때문에 next만 갱신해주면 반복문이 하나면 됨
		for (int i = 0; i < n; i++) {
			if (next <= conv[i][0]) {
				next = conv[i][1];
//				System.out.println(next);
				cnt++;
			}
		}
		System.out.println(cnt);
	} // main
}
