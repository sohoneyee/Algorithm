import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int[] usually = new int[8001];
		double avg = 0; // 평균
		int mid = 0; // 중앙값
		int many = 0; // 최빈값
		int cover = 0; // 범위

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			list.add(input); // 입력받은 수들 리스트에 넣어줌
			avg += input;
			if (input > 0) { // 양수면 4000+수를 인덱스로 하는 요소에 +1로 빈도수 올림
				usually[4000 + input]++;
			} else { // 음수면 절댓값을 인덱스로 갖는 요소에 +1로 빈도수 올림
				usually[Math.abs(input)]++;
			}
		}
		int avg2 = (int) (Math.round(avg / n)); // 평균
		Collections.sort(list); // 리스트 정렬 -> 중간값, 범위 구하기
		mid = list.get(n / 2); // 중간값
		cover = list.get(n - 1) - list.get(0); // 범위

		int max = Integer.MIN_VALUE;
		int mIdx = -1;
		int k = 0; // 두번째로 작은 최빈값 찾아내기 위한 변수
		// 최대 빈도수를 갖는 인덱스 찾아내기
		for (int i = 0; i < 8001; i++) {
			if (max < usually[i]) {
				max = usually[i];
				mIdx = i;
			}
		}

		// 최빈값은 여러개라면 두번째로 작은 수를 출력해야 함
		// -4000부터 따져줘야 하므로 범위를 나눠서 반복문 돌림
		for (int i = 4000; i >= 0; i--) {
			if (usually[i] == usually[mIdx]) {
				k++;
			}
			if (k == 2) {
				mIdx = i;
				break;
			}
		}
		if (k != 2) { // 음수에서 안 나왔을 경우 양수에서도 돌려줌
			for (int i = 4001; i < 8001; i++) {
				if (usually[i] == usually[mIdx]) {
					k++;
				}
				if (k == 2) {
					mIdx = i;
					break;
				}
			}
		}

		// 최빈값이 양수라면 인덱스-4000
		if (mIdx > 4000)
			many = mIdx - 4000;
		else // 음수라면 인덱스에 -붙이기
			many = -(mIdx);

		System.out.println(avg2);
		System.out.println(mid);
		System.out.println(many);
		System.out.println(cover);

	} // main
}
