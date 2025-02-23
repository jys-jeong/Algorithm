package _0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 시간 10개 테스트케이스 20초
// 100 * 100 배열에 사다리는 1, 빈 공간은 0, 도착지는 2로 표시
// 사다리 타기를 생각해보면
//밑으로 내려가다 왼쪽 있으면 왼쪽 오른쪽 있으면 오른쪽
// 도착지에서 출발지까지 가는 막대는 하나 있으니
// 도착지부터 출발
// 규칙 1. 왼쪽이나 오른쪽이 있다면 이동
// 규칙 2. 왼쪽 오른쪽이 없다면 위로 이동.

// 테스트 케이스당 많아 봐야  150 100 위로 올라가기 50 좌우 이동

// !! 제약사항 한 막대에서 출발한 가로선이 다른 막대를 가로질러서 연속하여
// 이어지는 경우는 없다. -> 왼쪽 아니면 오른쪽 하나이다.

public class SWEA_1210_Ladder1_문영호 {

    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static int[][] ladder;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            // 사다리 표시
            ladder = new int[100][100];
            // 지나간 곳을 다시 안가기 위해 방문 표시
            visited = new boolean[100][100];
            // 도착지 지정하기 위해 x, y 해놓음
            int x = 0;
            int y = 0;

            for(int i = 0; i < 100 ; i++){
                String[] split = br.readLine().split(" ");

                for(int j = 0; j < 100; j++){
                    ladder[i][j] = Integer.parseInt(split[j]);
                    if(ladder[i][j] == 2){
                        // 파싱 하다 도착지인 2를 만나면 x,y값 저장
                        x = i;
                        y = j;
                    }
                }
            }
            // x,y로 시작해서 출발지 찾는 함수
            int result = find(x, y);
            sb.append("#").append(t).append(" ").append(result).append("\n");

            // System.out.println("======================== here ===========================");
            // printArr();
        }

        System.out.println(sb.toString());

    
    }

    static int find(int x, int y){
        int nx = x;
        int ny = y;

        // nx != 0 ㅣ일 때까지 반복
        // nx -> 0 이면 맨 위에도착한거니 그 때 ny값이 막대 번호가 된다.
        while(nx != 0){
            // 왼쪽갔다 오른쪽 갔다 할 수 있음 그래서 방문체크를 하여 반복하는 일이 없어야함
            visited[nx][ny] = true;
            // 자주쓰는 방법
            // isIn -> 배열의 크기 안에 있는지 확인
            // visited -> nx, ny 가 도착하였는지
            // 지금 생각해보니 변수명이 애매함. nx ny 가 아니라 x , y 가 더 좋을듯
            // 올라가다가 왼쪽이 배열의 안에 있음, 방문 안함, 사다리면 왼쪽으로감
            if(isIn(nx, ny - 1) && !visited[nx][ny - 1]  &&  ladder[nx][ny -1] == 1){// 왼쪽 
                ny--;
                // 오른쪽
            } else if(isIn(nx, ny + 1) && !visited[nx][ny + 1]  &&  ladder[nx][ny +1] == 1){// 왼쪽 
                ny++;
            }else{
                // 오른쪽 왼쪽 없으면 사다리타기 게임 특성 상 아래로감 , 그런데 나는 아래부터 시작하니 위로감
                nx--;
            }
        
        }
        // nx == 0 이면 그 때 ny 값이 막대의 인덱스값임
        return ny;
    }


    // 배열안에 존재하는지
    static boolean isIn(int x, int y){
        return 0 <= x && x < 100 && 0 <= y && y < 100;
    }

    // 함수내용 찍어보는용
    static void printArr(){
        for(int[] x : ladder){
            for(int xx : x){
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}
