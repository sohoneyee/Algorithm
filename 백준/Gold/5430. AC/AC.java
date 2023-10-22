import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		center: for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			String[] str = br.readLine().split(""); // 명령어
			int n = Integer.parseInt(br.readLine()); // 수의 개수
			// [나 ]는 이스케이프문자를 붙여야 한다!!
			// |로 구분자를 여러 개 쓸 수 있다
			String[] a = br.readLine().split("\\[|,|\\]");
			// R로 인해 순서가 바뀌므로 첫 인덱스와 마지막 인덱스 접근이 쉬운 덱 사용
			Deque<String> dq = new LinkedList<>();
			for (int i = 1; i < a.length; i++) {
				dq.add(a[i]); // 덱에 입력된 숫자들 add
			}
			int cnt = 0; // 짝수일 때 원래 순서, 홀수일 때 반대 순서, -1일 때 에러
			loop: for (String order : str) {
				switch (order) {
				case "R":
					// 에러가 나오는 경우는 배열이 비어있는데 D를 입력한 경우만 해당
					// 비어있을 때 R을 입력하면 에러가 아니라 빈 배열이 출력되어야 함
					// 1 RD 0 [] -> ERROR 를 위해 str의 길이도 조건에 추가
					if (str.length == 1 && a.length == 0) {
						sb.append("[]");
						// tc를 continue해야 밑의 cnt경우에 걸리지 않음!
						System.out.println(sb);
						continue center;
					}
					cnt++;
					break; // 다음 명령어로 넘기기

				case "D":
					if (dq.isEmpty()) {
						cnt = -1; // 이미 빈 배열에서 D하려고 하면 에러
						break loop; // 다음 명령어 볼 필요 없이 바로 에러 출력
					}
					if (cnt % 2 == 0) // 원래 순서면 처음 숫자 poll
						dq.pollFirst();
					else // 반대 순서면 마지막 숫자 poll
						dq.pollLast();
					break;
				}
			} // loop

			// -1일 때 에러, 짝수일 때 원래 순서, 홀수일 때 반대 순서
			if (cnt == -1) sb.append("error");
			else if (cnt % 2 == 0) {
				// 모든 명령어가 끝난 후 빈 배열 역시 []를 출력해줘야 함
				if (dq.size() == 0) sb.append("[]");
				else {
					sb.append("[");
					while (dq.size() > 1) {
						sb.append(dq.pollFirst()).append(",");
					}
					sb.append(dq.pollFirst());
					sb.append("]");
				}
			} else {
				// 모든 명령어가 끝난 후 빈 배열 역시 []를 출력해줘야 함
				if (dq.size() == 0) sb.append("[]");
				else {
					sb.append("[");
					while (dq.size() > 1) {
						sb.append(dq.pollLast()).append(",");
					}
					sb.append(dq.pollLast());
					sb.append("]");
				}
			}
			System.out.println(sb);
		} // tc
	} // main

}