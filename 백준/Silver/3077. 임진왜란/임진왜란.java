import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 해전의 개수

		Map<String, Integer> correct = new HashMap<String, Integer>(); // 정답
		String[] test = new String[n]; // 현우
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			correct.put(st.nextToken(), i);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			test[i] = st.nextToken();
		}

		int score = 0; // 추월한 경우의 수

		// 현우의 배열에서 0번째부터 순서대로 골라서 그 다음 인덱스들과 비교하는데
		// 정답배열의 순서비교와 대소관계가 다르다면 ++ = 추월한 것임
		for (int i = 0; i < n; i++) {
			int origin = correct.get(test[i]);
//			System.out.println(test[i] + ":" + origin);
			for (int j = i + 1; j < n; j++) {
				if (origin > correct.get(test[j])) {
//					System.out.println(test[j] + ":" + correct.get(test[j]));
//					System.out.println(test[i] + "," + test[j]);
//					System.out.println();
					score++;
				}
			}
		}

		int child = n * (n - 1) / 2;
		int parent = child - score; // 추월한 경우를 빼줘야 함

		System.out.println(parent + "/" + child);

	} // main
}
