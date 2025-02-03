import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static StringBuilder sb =new StringBuilder();
	public static Map<String, Integer> books = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* StringTokenizer st = new StringTokenizer(br.readLine()); */
		
		int n = Integer.parseInt(br.readLine());
		int max=0;
		for(int i=0 ;i< n ;i++) {
			String book = br.readLine();
			books.put(book, books.getOrDefault(book, 0)+1);
			max =Math.max(max, books.get(book));
		}
		List<String> ans = new ArrayList<>();
		for(Map.Entry<String, Integer> entry: books.entrySet()) {
			if(entry.getValue()==max) {
				ans.add(entry.getKey());
			}
		}
		Collections.sort(ans);
		System.out.println(ans.get(0));
		
	}



}