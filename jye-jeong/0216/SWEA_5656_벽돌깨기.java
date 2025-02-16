package Algorithm;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution {
    
    public static int board[][];
    public static boolean vis[][];
    public static int n,w,h,t,ans;
    public static int dx[]={0,0,1,-1};
    public static int dy[]={1,-1,0,0};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        int tcnt=0;
        while(t-->0){
            tcnt++;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            board= new int[h][w];
            int sum=0;
            for(int i=0 ;i <h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0 ;j < w;j++){
                    board[i][j]=Integer.parseInt(st.nextToken());
                    if(board[i][j]>0){
                        sum++;
                    }
                }
            }
            ans=sum;
            dfs(board,0);
            System.out.println("#"+tcnt+" "+ans);
        }
    }

    public static void dfs(int [][]map,int cnt){

        if(cnt<=n){
            int sum=0;
            for(int i=0 ;i< h;i++){
                for(int j=0 ;j < w;j++){
                    if(map[i][j]>0){
                        sum++;
                    }
                }
            }
//            for(int i=0 ;i<h;i++){
//                for(int j=0;j<w;j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println("다깼다 sum: "+sum);
            ans=Math.min(sum,ans);
            if(cnt==n) {
            	return;
            }
        }
        int tmp[][] = new int[h][w];
        for(int i=0 ;i<h;i++) {
        	for(int j=0 ;j <w;j++) {
        		tmp[i][j]=map[i][j];
        	}
        }
        
        for(int i=0;i<w;i++){

            for(int j=0;j<h;j++){
                if(map[j][i]==0)    continue;
//                System.out.println(j+" "+i);
                dfs(wallBreak(j,i,map),cnt+1);
                for(int a=0;a<h;a++) {
                	for(int b=0;b<w;b++) {
                		map[a][b]=tmp[a][b];
                	}
                }
                break;
            }
        }
    }
    public static int [][] wallBreak(int x, int y,int[][] map){
        if(map[x][y]==1){
            map[x][y]=0;
            return map;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y,map[x][y]});
    	
    	while(!q.isEmpty()) { // 벽돌 깨기 시작
    		int []cur = q.poll();
    		for(int i=cur[0]-cur[2]+1;i<cur[0]+cur[2];i++) { //세로 체크
    			if(i<0||i>=h)	continue;
            	if(map[i][cur[1]]>1) {
            		q.add(new int[] {i,cur[1],map[i][cur[1]]});
            		map[i][cur[1]]=0;
            	}
            	map[i][cur[1]]=0;
            }
        	for(int j=cur[1]-cur[2]+1;j<cur[1]+cur[2];j++) { // 가로 체크
        		if(j<0||j>=w)	continue;
        		if(map[cur[0]][j]>1) {
        			q.add(new int[] {cur[0],j,map[cur[0]][j]});
        			
        		}
        		map[cur[0]][j]=0;
        	}
    	}
//        for(int i=0 ;i<h;i++){
//            for(int j=0;j<w;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        
        return down(map);
    }
    public static int[][] down(int [][] map){
    	// 벽돌을 깬 후 0인 자리를 메꾸는 함수

        for(int i=0;i<w;i++){
            for(int j=h-1;j>=0;j--){
                List<Integer> li =new ArrayList<>();
                if(map[j][i]==0){
                    int a= j;
                    while(a>=0){
                        if(map[a][i]>0){
                            li.add(map[a][i]);
                            map[a][i]=0;
                        }
                        a--;
                    }

                    if(!li.isEmpty()){
                        int idx=0;
                        for(int k =j;k>j-li.size();k--){
                            map[k][i]=li.get(idx++);
                            
                        }
                    }
                    break;
                }
                
            }
        }
        
        return map;
    }
}

