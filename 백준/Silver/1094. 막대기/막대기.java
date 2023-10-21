import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int X, stick;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		stick = 64;
		
		// 23 = 10111, 32 = 100000, 64 = 1000000, 48 = 110000
		// X를 2진수로 변환했을 때 1의 개수를 세주면 됨!!!! 이번엔 찐 ㅎㅎ
		// tobinaryString(2), toOctalString(8), toHexString(16)
		
		// 문자열로 변환되기 때문에 split으롭 배열에 담아주고 1의 개수를 세줌
		String[] two = Integer.toBinaryString(X).split("");
		for(int i =0; i<two.length; i++) {
			if (two[i].equals("1")) {
				ans++;
			}
		}
		
		System.out.println(ans);
	
	} // main

	
}
