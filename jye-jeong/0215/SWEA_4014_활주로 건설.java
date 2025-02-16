import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution {
    
    public static int board[][],reverse[][];
    public static boolean vis[][];
    public static int n,x,t,ans;


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        t = Integer.parseInt(st.nextToken());
        int tcnt=0;
        while(t-->0){
            tcnt++;
            st=new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x=Integer.parseInt(st.nextToken());
            board=new int[n][n];
            reverse=new int[n][n];
            vis = new boolean[n][n];
            for(int i=0 ;i<n ;i++){ // board 입력 받기
                st=new StringTokenizer(br.readLine());
                for(int j=0 ;j < n ;j++){
                    board[i][j]=Integer.parseInt(st.nextToken());
                    reverse[j][i]=board[i][j];
                }  
            }
            dfs(board);
            vis = new boolean[n][n];
            dfs(reverse);


            System.out.println("#"+tcnt+" "+ans);

            ans=0;

        }
    }

    public static void dfs(int [][]map){

        for(int i=0 ;i< n;i++){
            boolean flag=false;
            for(int j=0;j<n;j++){
                if(j==n-1){

                    ans++;
                    break;
                }
                if(map[i][j]==map[i][j+1]){
                    continue;
                }
                else if((map[i][j+1] -map[i][j])==1){
                    if(x-1>j){//왼쪽에 남은 길이 경사로의 길이보다 짧다면
                        flag=true;
                        break;
                    }
                    for(int k=j;k>j-x;k--){
                        
                        if(vis[i][k]){
                            flag=true;
                            break;
                        }   
                        vis[i][k]=true;
                    }
                    
                }
                else if((map[i][j]-map[i][j+1])==1){ // 3 2 1 1
                    if((n-j-1)<x){
                        flag=true;
                        break;// 오른쪽에 남은 길이가 경사로의 길이보다 짧다면
                    } 
                    
                    for(int k=j+1;k<=j+x;k++){
                        if(map[i][k]!=map[i][j+1] || vis[i][k]){
                            flag=true;
                            break;
                        }
                        vis[i][k]=true;
                        
                    }
                    
                }
                else{//다음 칸이 현재 칸보다 2이상 크다면
                    flag=true;
                }
                if(flag)    break;
            }
        }
    }
    
}
