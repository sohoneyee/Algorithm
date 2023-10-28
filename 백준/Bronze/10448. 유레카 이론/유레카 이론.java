import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스

		int[] seq = new int[46]; // Tn
		for (int i = 1; i < 46; i++) {
			seq[i] = seq[i - 1] + i;
		}
//		System.out.println(Arrays.toString(seq));

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 입력받은 정수
			boolean flag = false; // 출력할 수 있는지 없는지 판별할 flag

			for (int i = 1; i < 46; i++) {
				for (int j = 1; j < 46; j++) {
					for (int k = 1; k < 46; k++) {
						if (seq[i] + seq[j] + seq[k] == n) // 정확히 3개의 삼각수의 합이라면
							flag = true; // true
					}
				}
			}
			if (flag)
				System.out.println(1);
			else
				System.out.println(0);

		} // tc

	} // main
}
