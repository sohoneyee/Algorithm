import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node() {
		}

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [index" + index + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	} // node

	static int n;
	static int[][] planet;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		planet = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				planet[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (planet[i][j] > 0) {
					list[i].add(new Node(j, planet[i][j]));
				}
			}
		}

		boolean[] visited = new boolean[n + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited[1] = true;
		int pick = 1;
		long ans = 0;

		for (Node node : list[1])
			pq.add(node);

		while (pick != n) {
			Node out = pq.poll();
			if (visited[out.index])
				continue;
			visited[out.index] = true;
			ans += out.cost;
			pick++;
			pq.addAll(list[out.index]);
		}

		System.out.println(ans);

	} // main
}