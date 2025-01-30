import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		int t = Integer.parseInt(br.readLine());
		for(int i=0 ;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(c==0) {
				row.add(num);
			}
			else {
				col.add(num);
			}
		}
		row.add(0);
		row.add(m);
		col.add(0);
		col.add(n);
		Collections.sort(row);
		Collections.sort(col);
		int mxRow =0;
		for(int i=0 ;i<row.size()-1;i++) {
			mxRow = Math.max(mxRow, row.get(i+1)-row.get(i));

		}

		int mxCol =0;
		for(int i=0 ;i<col.size()-1;i++) {
			mxCol = Math.max(mxCol, col.get(i+1)-col.get(i));

		}
		System.out.println(mxRow*mxCol);
	}

}
