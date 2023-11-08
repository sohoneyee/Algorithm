import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] triangle = new int[n];
		for (int i = 0; i < n; i++) {
			triangle[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(triangle);

		// 삼각형의 조건 : 가장 긴 변의 길이 < 나머지 두 변의 길이 합
		// 쓰리포인터로 풀자. 최댓값을 구해야 하므로 끝 인덱스 세 개 부터 시작하기
		// 예시) 4, 5, 6, 7, 20
		// 6 7 20 (X) -> 6이나 7이 작아져봤자 어차피 삼각형의 조건을 만족하지 않음 -> a--
		// 5 6 7 (O) = 18 -> a--를 할수록 더 작아지므로 최댓값은 여기서 나옴
		int a = n - 1;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		while (a - 2 >= 0) {
//			System.out.println((a - 2) + "," + (a - 1) + "," + a);
			// 삼각형의 조건을 만족하면 최댓값 갱신
			if (triangle[a] < triangle[a - 1] + triangle[a - 2]) {
				sum = triangle[a] + triangle[a - 1] + triangle[a - 2];
				max = Math.max(max, sum);
				break;
			}
			a--;
		}

		if (max != Integer.MIN_VALUE)
			System.out.println(max);
		else
			System.out.println(-1);
	} // main
}