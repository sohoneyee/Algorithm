import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// R+B=방의 넓이 -> 최대한 시간을 줄이기 위해 중간부터 반복문을 돌리기로 함
		loop: for (int i = (int) Math.sqrt(R + B); i >= 1; i--) { // W
			for (int j = i; j <= (R + B); j++) { // L
				if (i * j != (R + B)) continue;
				if (2 * j + 2 * (i - 2) == R) {
					sb.append(j).append(" ").append(i);
					break loop;
				}

			}
		} // for
		System.out.println(sb);
	} // main
}
