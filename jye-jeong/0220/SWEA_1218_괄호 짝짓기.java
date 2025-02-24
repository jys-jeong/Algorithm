

import java.util.*;
import java.io.*;

public class Solution {

	static int n; //문자열 길이 변수
	static String s; //괄호 문자열 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		for(int i=1;i<=10;i++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			s=br.readLine();
			
			int idx=0;
			Stack<Character> ss = new Stack<>();
			boolean flag=false;
			while(idx<s.length()) {
				
				if(s.charAt(idx)=='('||s.charAt(idx)=='['||s.charAt(idx)=='{'||s.charAt(idx)=='<') { //여는 괄호는 stack에 넣는다.
					ss.add(s.charAt(idx));
				}
				else if((s.charAt(idx)==')'||s.charAt(idx)==']'||s.charAt(idx)=='}'||s.charAt(idx)=='>')) { // 닿는 괄호일 때
					if(ss.isEmpty()) { // stack이 비어있으면 더이상 여는괄호가 없는 것이므로 실패
						flag=true;
						break;
					}
					if(s.charAt(idx)==')') {
						if(ss.peek()=='(') { // stack 맨위에 올라와 있는 게 ')'면 짝이 맞으므로 stack에서 제거
							ss.pop();
						}
						else { //stack 맨위에 올라와 있는게 '('가 아니라면 성립하지 않음
							flag=true;
							break;
						}
					}
					else if(s.charAt(idx)==']') {// stack 맨위에 올라와 있는 게 ']'면 짝이 맞으므로 stack에서 제거
						if(ss.peek()=='[') {
							ss.pop();
						}
						else {//stack 맨위에 올라와 있는게 '['가 아니라면 성립하지 않음
							flag=true;
							break;
						}
					}
					else if(s.charAt(idx)=='}') {// stack 맨위에 올라와 있는 게 '}'면 짝이 맞으므로 stack에서 제거
						if(ss.peek()=='{') {
							ss.pop();
						}
						else {//stack 맨위에 올라와 있는게 '{'가 아니라면 성립하지 않음
							flag=true;
							break;
						}	
					}
					else if(s.charAt(idx)=='>') {// stack 맨위에 올라와 있는 게 '>'면 짝이 맞으므로 stack에서 제거
						if(ss.peek()=='<') {
							ss.pop();
						}
						else {//stack 맨위에 올라와 있는게 '<'가 아니라면 성립하지 않음
							flag=true;
							break;
						}
					}
				}
				++idx;
				
			}
			System.out.print("#"+i+" ");
			if(flag) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
		}


	}

}
