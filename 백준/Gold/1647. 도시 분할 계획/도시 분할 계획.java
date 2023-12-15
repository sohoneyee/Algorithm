import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int from;
		int to;
		int cost;

		public Node() {
		}

		public Node(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	} // node

	static int fix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			fix = c;
			list[a].add(new Node(a, b, c));
			list[b].add(new Node(b, a, c));
		} // 입력 끝

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		pq.addAll(list[1]);

		int pick = 1;
		
		// ans = 모든 도시를 지나는 유지비를 담아놓을 리스트
		List<Integer> ans = new ArrayList<>();

		while (pick != n) { // n-1까지 해줘야 마지막 out.cost를 빼줄 수 있음
//			System.out.println(pq);
			Node out = pq.poll();
//			System.out.println("out: " + out);

			if (visited[out.to])
				continue;

			pick++;
			ans.add(out.cost);
			visited[out.to] = true;
			pq.addAll(list[out.to]);
		}

		// 우리는 도시를 분할해야 하므로 가장 큰 out.cost를 빼주면 두 개의 마을로 분할이 가능함
		Collections.sort(ans);
		int sum = 0;
		for (int i = 0; i < ans.size() - 1; i++) {
			sum += ans.get(i);
		}
        
		System.out.println(sum);
	} // main
}
