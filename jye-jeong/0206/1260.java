import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		Stack<Integer> s = new Stack<>();
		List<Integer> bans = new ArrayList<>();
		List<Integer> dans = new ArrayList<>();
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		boolean qvis[] = new boolean[n+1];
		boolean dvis[] = new boolean[n+1];
		ArrayList<Integer>[] arr= new ArrayList[n+1];
		for(int i=0 ;i<n+1;i++) {
			arr[i]= new ArrayList<>();
		}
		for(int i=0 ;i<m;i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(arr[i]);
		}
		q.offer(v);
		qvis[v]=true;
		bans.add(v);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : arr[cur]) {
				if(qvis[nxt])	continue;
				q.offer(nxt);
				qvis[nxt]=true;
				bans.add(nxt);
			}
		}
		s.add(v);
		while(!s.isEmpty()) {
			int cur= s.pop();
			if(dvis[cur])	continue;
			dans.add(cur);
			dvis[cur]=true;
			List<Integer> tmp = new ArrayList<>();
			for(int nxt : arr[cur]) {
				if(dvis[nxt])	continue;
				tmp.add(nxt);
			}
			Collections.sort(tmp);
			for(int i=tmp.size()-1 ;i>=0;i--) {
				s.add(tmp.get(i));
			}
		}
		for(int k : dans) {
			System.out.print(k+" ");
		}
		System.out.println();
		for(int k : bans) {
			System.out.print(k+" ");
		}
		
	}
	

}
