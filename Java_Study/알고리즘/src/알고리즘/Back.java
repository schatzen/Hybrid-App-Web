package 알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(st.nextToken());
		int index = Integer.parseInt(st.nextToken());
		int[] list = new int[5000000];
		

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < size; i++) {
			list[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(list, 0, size);
		
		
		bw.write(list[index-1]+"");
		bw.close();

	}
}
