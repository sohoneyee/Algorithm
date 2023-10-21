import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 카드의 수
		int m = Integer.parseInt(st.nextToken()); // 합체 횟수

		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		} // 입력 끝

		// 우선순위 큐에 담았으므로 poll할 때마다 가장 작은 카드들만 더할 수 있음
		while (m > 0) { // 연산횟수만큼 반복문 돌리기
			Long a = pq.poll() + pq.poll(); // 카드 합체
			// 카드 두 장을 poll하고 합쳤으므로 두 번 add해주자
			pq.add(a);
			pq.add(a);
			m--;
		}

		long ans = (long) 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb);

	} // main
}
