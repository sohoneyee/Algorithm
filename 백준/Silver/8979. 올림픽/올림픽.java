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
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] medal = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				medal[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(medal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) return o2[1] - o1[1];
				else {
					if (o1[2] != o2[2]) return o2[2] - o1[2];
					return o2[3] - o1[3];
				}
			}
		});

		medal[0][4] = 1;
		for (int i = 1; i < n; i++) {
			if (medal[i - 1][1] == medal[i][1]&&medal[i - 1][2] == medal[i][2]&&medal[i - 1][3] == medal[i][3])
				medal[i][4] = medal[i - 1][4];
			else medal[i][4] = medal[i - 1][4] + 1;
		}
		
		for(int i=0; i<n; i++) {
			if (k==medal[i][0]) {
				System.out.println(medal[i][4]);
				break;
			}
		}
		
	} // main
}