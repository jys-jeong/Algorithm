import java.io.BufferedReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static StringBuilder sb =new StringBuilder();
	public static Set<String> p = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0 ;i< n;i++) {
			st = new StringTokenizer(br.readLine());
			String person = st.nextToken();
			String chk = st.nextToken();
			if(chk.equals("enter")) {
				p.add(person);
			}
			else if(chk.equals("leave")) {
				if(p.contains(person)) {
					p.remove(person);
				}
			}
		}
		List<String> list = new ArrayList<String>(p);

		list.sort(Comparator.reverseOrder());
		for(String k: list) {
			System.out.println(k);
		}
	}

}