import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			String order;
			int num = 0;
			// 명령어 뒤에 정수가 나올 경우와 안 나올 경우 입력을 나눠 받기
			if (str.length == 1)
				order = str[0];
			else {
				order = str[0];
				num = Integer.parseInt(str[1]);
			}

			// 각 명령어에 따라 수행하기
			switch (order) {
			case "push_front":
				dq.addFirst(num);
				break;
			case "push_back":
				dq.addLast(num);
				break;
			case "pop_front":
				if (dq.size() > 0)
					System.out.println(dq.pollFirst());
				else
					System.out.println(-1);
				break;
			case "pop_back":
				if (dq.size() > 0)
					System.out.println(dq.pollLast());
				else
					System.out.println(-1);
				break;
			case "size":
				System.out.println(dq.size());
				break;
			case "empty":
				if (dq.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (dq.size() > 0)
					System.out.println(dq.peekFirst());
				else
					System.out.println(-1);
				break;
			case "back":
				if (dq.size() > 0)
					System.out.println(dq.peekLast());
				else
					System.out.println(-1);
				break;
			} // switch
		} // for
	} // main
}