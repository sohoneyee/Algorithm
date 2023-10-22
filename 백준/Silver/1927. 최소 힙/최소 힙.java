import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int order = Integer.parseInt(br.readLine());
			switch (order) {
			case 0:
				if (pq.size() != 0) {
					System.out.println(pq.poll());
				} else
					System.out.println(0);
				break;
			default:
				pq.add(order);
				break;
			}
		}
	} // main
}
