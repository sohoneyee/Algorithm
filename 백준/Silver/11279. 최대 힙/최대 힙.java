import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < n; i++) {
			int operation = Integer.parseInt(br.readLine());
			// 자연수 : operation 추가
			// 0 : 배열에서 가장 큰 값 출력 후 제거
			// isempty && 0 : 0 출력

			switch (operation) {
			case 0:
				if (!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
				break;

			default:
				pq.add(operation);

			} // switch
		}

	} // main
}