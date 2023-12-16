import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, size;
	static int[] node;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 트리의 깊이

		size = (int) Math.pow(2, n) - 1; // 노드의 수
		node = new int[size];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		// 문제에서 주어지는 입력=중위순회 => node의 중간값이 루트노드!
		sb.append(node[size / 2]).append("\n");
		repeat(size);
	} // main

	public static void repeat(int length) {
		// 기저조건 : 깊이가 1이 되면 출력
		if (n == 1) {
			System.out.println(sb);
			return;
		}
		n--; // 기저조건을 위함

		// 깊이가 4일 경우 인덱스= 7 / 3 11 / 1 5 9 13 / 0 2 4 6 8 10 12 14 순으로 출력
		// 따라서 반복문의 증감식을 n을 이용하여 설정!
		int r = (length - 1) / 2;
		for (int i = r / 2; i < node.length; i += Math.pow(2, n)) {
			sb.append(node[i]).append(" ");
		}
		sb.append("\n");
		repeat(r);
	} // repeat
}
