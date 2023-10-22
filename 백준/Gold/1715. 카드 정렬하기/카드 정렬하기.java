import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> ans = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (pq.size() > 1) {
			int process = pq.poll() + pq.poll();
			ans.add(process);
			pq.add(process);
		}

		int sum = 0;
		for (int k : ans) {
			sum += k;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		System.out.println(sb);
	} // main
}
