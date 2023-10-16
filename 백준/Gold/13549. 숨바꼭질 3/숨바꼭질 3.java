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
	int cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
} // class

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int k = Integer.parseInt(st.nextToken()); // 동생의 위치

		// 이동할 필요가 없는 경우 0 출력하고 끝내기
		if (n == k) {
			System.out.println("0");
			return;
		}

		// k가 n보다 작을 경우 가능한 방법은 x-1밖에 없으므로 n-k로 출력하고 끝내기
		if (k < n) {
			System.out.println(n - k);
			return;
		}

		// 이동한 위치가 2*k+1보다 커질 경우에는 넘길 것
		List<Node>[] list = new ArrayList[k * 2 + 1];
		for (int i = 0; i < k * 2 + 1; i++) {
			list[i] = new ArrayList<>();
		}

		// 수빈이가 이동하는 방법 = 1초 후 : (x-1,1), (x+1,1) / 0초 후 : (2*x,0)
		for (int i = 0; i < k * 2 + 1; i++) {
			if (i == 0) {
				list[i].add(new Node(i + 1, 1));
				list[i].add(new Node(i * 2, 0));
				continue;
			}
			list[i].add(new Node(i - 1, 1));
			list[i].add(new Node(i + 1, 1));
			list[i].add(new Node(i * 2, 0));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[k * 2 + 1]; // 이미 지나친 점은 넘기기 위해 방문처리
		int[] dist = new int[k * 2 + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;

		pq.add(new Node(n, dist[n]));

		while (!pq.isEmpty()) {
			Node out = pq.poll();
			int now = out.index; // 현재 위치
			int time = out.cost; // 현재 시간

//			System.out.println("n:" + now + " , t: " + time);
			// 동생의 위치에 도달한 경우 출력 후 루프 탈출
			if (now == k) {
				System.out.println(time);
				break;
			}

			if (visited[now]) // 이미 지난 점이라면 continue
				continue;
			visited[now] = true;

			for (Node node : list[now]) {
				if (node.index > k + 1 || node.index < 0) // k+1을 넘기면 굳이 돌지 않고 continue
					continue;
				if (dist[node.index] > dist[now] + node.cost) {
					dist[node.index] = dist[now] + node.cost;
					pq.add(new Node(node.index, dist[node.index]));
				}
			}
		}

	} // main
}