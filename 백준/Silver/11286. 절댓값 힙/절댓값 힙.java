import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 연산의 개수

		// 정렬기준 : 절댓값 오름차순 -> 절댓값이 같다면 원래 수 비교 오름차순
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				if (Math.abs(o1) - Math.abs(o2) > 0)
					return 1;
				else if (Math.abs(o1) - Math.abs(o2) == 0) {
					return Long.compare(o1, o2);
				} else
					return -1;
			}
		});

		for (int i = 0; i < n; i++) {
			Long x = Long.parseLong(br.readLine());
			if (x == 0) { // 0이라면
				if (pq.isEmpty()) { // pq가 비었다면 0을 출력하고 넘겨
					System.out.println(0);
					continue;
				}
				System.out.println(pq.poll()); // 절댓값이 가장 작은 값을 출력하고 제거
			} else { // 0이 아니라면
				pq.add(x); // pq에 추가
			}
		}

	} // main
}
