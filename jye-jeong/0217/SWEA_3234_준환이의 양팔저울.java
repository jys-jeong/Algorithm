

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;
import java.util.*;

public class Solution {
	
	public static int n,ans;
	public static int arr[], select[];
	public static boolean vis[];
	public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int tcnt = 0;
		while (t-- > 0) {
			tcnt++;
			st =new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr=new int[n];
            select=new int[n];
			vis =new boolean[n];

			st =new StringTokenizer(br.readLine());
			for(int i=0;i< n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			
			dfs(0);
			
			System.out.printf("#%d %d\n",tcnt,ans);
			ans=0;
		}
		System.out.println(sb);
	}
	static void dfs(int cnt) {
		if(n==cnt) {
			scale(0,0,0);
		}
		
		for(int i=0 ;i<n;i++) {
			if(vis[i])	continue;
			vis[i]=true;
            select[cnt]=arr[i];
			dfs(cnt+1);
			vis[i]=false;
		}
	}
    static void scale(int cnt,int left,int right){
        if(left<right)  return;
        if(cnt==n){
            ans++;
            return;
        }
        scale(cnt+1,left+select[cnt],right);
        scale(cnt+1,left,right+select[cnt]);
    }

}
