import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		for (int i = 0; i < str.length; i++) {
			if (i % 10 == 0 && i > 0) {
				System.out.println();
			}
			System.out.print(str[i]);
		}
	} // main
}
