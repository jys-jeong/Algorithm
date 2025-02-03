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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		String a = br.readLine();
		Set<String> ans = new HashSet<String>();
		for(int i=1;i<=a.length();i++) {
			for(int s=0;s<a.length()-i+1;s++) {
				ans.add(a.substring(s,s+i));

			}
		}
		System.out.println(ans.size());
	}

}
