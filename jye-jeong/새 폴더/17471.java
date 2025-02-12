import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    public static int n;
    public static int []arr;
    public static int []vis;
    public static int vec[][];
    public static int acnt,bcnt,all;
    public static int ans = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        n =Integer.parseInt(st.nextToken());
        vec = new int[n+1][n+1];
        arr = new int[n+1];
        vis = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<=n;i++){
            vis[i]=0;
        }
        for(int i=1 ;i<= n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            all+=arr[i];
        }
        for(int i=1 ;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int m =Integer.parseInt(st.nextToken());
            for(int j=0 ; j<m;j++){
                vec[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n-1;i++){
            dfs(0,i,1);

        }
        if(ans==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }

    public static void dfs(int cnt,int lim,int nxt){
        if(lim==cnt){
            
            boolean flag=false;
            for(int i=1;i<=n ;i++){
                if(vis[i]==1){
                    if(bfs(i,acnt,1)){
                        flag=true;
                        break;
                    }
                }
            }
            if(flag){
                for(int i=1;i<=n ;i++){
                    if(vis[i]==0){
                        
                        if(bfs(i,n-acnt,0)){
                            int sum=0;
                            for(int j=1 ;j<=n;j++){
                                if(vis[j]==1){
                                    sum+=arr[j];
                                    
                                }
                            }
                            int tmp=all-sum;
                            ans =Math.min(ans,Math.abs(tmp-sum));
                            
                        }
                        
                    }
                }
                
            }
            return;
        }
        for(int i=nxt;i<=n;i++){
            if(vis[i]!=0)   continue;
            vis[i]=1;
            ++acnt;
            dfs(cnt+1,lim,i+1);
            vis[i]=0;  
            --acnt;
        }
    }
    
    public static boolean bfs(int num,int cnt,int e){
        
        Queue<Integer> q = new ArrayDeque<>();
        int tmp=1;
        boolean vv [] =new boolean[n+1];
        q.add(num);
        vv[num]=true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0 ;i<vec[cur].length;i++){
                if(vec[cur][i]==0)  continue;
                if(vis[vec[cur][i]]==e){
                    if(vv[vec[cur][i]]) continue;
                    vv[vec[cur][i]]=true;
                    tmp++;
                    q.add(vec[cur][i]);
                }
            }
        }
        if(tmp==cnt){
            return true;
        }
        else{
            return false;
        }
    }
}
