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
		int n = Integer.parseInt(br.readLine());

		int[][] coor = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coor[i][0] = Integer.parseInt(st.nextToken());
			coor[i][1] = Integer.parseInt(st.nextToken());
		}

		// x좌표 오름차순 -> 같으면 y좌표 오름차순
		Arrays.sort(coor, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) return 1;
				else if (o1[0] < o2[0]) return -1;
				else return o1[1] - o2[1];
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int[] arr : coor) {
			for (int k : arr)
				sb.append(k).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
		
	} // main
}
