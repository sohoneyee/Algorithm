import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue q = new LinkedList();

		// 큐에 카드 숫자들 담아주기
		for (int i = 0; i < n; i++) {
			q.add(i + 1);
		}

		// 마지막에 남는 카드 숫자를 얻자
		while (q.size() != 1) {
			q.poll(); // 맨 위의 카드는 버리고
			q.add(q.poll()); // 그 다음 위에 있는 카드는 제일 아래로 옮기기
		}

		// 마지막 숫자 출력
		System.out.println(q.poll());

	} // main
}