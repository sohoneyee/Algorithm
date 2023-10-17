import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int index;
	int w;

	public Node(int index, int w) {
		this.index = index;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int e = Integer.parseInt(st.nextToken()); // 도로의 수
		int k = Integer.parseInt(st.nextToken()); // 거리정보
		int start = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

		List<Node>[] list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, 1));
		} // 입력 끝

		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0; // 시작정점에서의 거리는 0

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			Node out = pq.poll();
			int t = out.index;
			int w = 1; // 가중치가 무조건 1이므로

			for (Node c : list[t]) {
				if (dist[c.index] > dist[t] + w) {
					dist[c.index] = dist[t] + w;
					pq.add(new Node(c.index, dist[c.index]));
				}
			}
		} // while

		boolean[] flag = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (dist[i] == k) // 최단 거리가 k라면 flag를 true
				flag[i] = true;
		}

		int cnt = 0; // 하나도 존재하지 않을 경우 -1을 출력하기 위함
		for (int i = 1; i < n + 1; i++) {
			if (flag[i]) {
				System.out.println(i);
				continue;
			} else
				cnt++;
		}

		if (cnt == n) // 하나도 존재하지 않음 = cnt==n -> -1 출력
			System.out.println(-1);

	} // main
}