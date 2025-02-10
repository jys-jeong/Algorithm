import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667_단지번호붙이기_문영호 {
    
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌우 
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        int cnt = 0;
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }

   

        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    cnt++;
                    list.add(DFS(i, j));
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for(int i : list){
            System.out.println(i);
        }
        
    }

    static int DFS(int x, int y){
        int size = 1;
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isIn(nx, ny) && !visited[nx][ny] &&arr[nx][ny] == 1){
                size += DFS(nx, ny);
            }
        }

        
        return size;
    }


    static boolean isIn(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

  

}

// 7
// 0110100
// 0110101
// 1110101
// 0000111
// 0100000
// 0111110
// 0111000