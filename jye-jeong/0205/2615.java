import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test5.txt"));
		//---------여기에 코드를 작성하세요.---------------//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[][]= new int[20][20];
		for(int i=1;i<=19;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=19;j++) {
				
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int win=0;
		int winx=0;
		int winy=0;
		int dx[]= {0,1,1,-1};
		int dy[] = {1,0,1,1};
		for(int i=1;i<=19;i++) {
			for(int j=1;j<=19;j++) {
				if(arr[i][j]==0)	continue;
				
				
				for(int dir=0;dir<4;dir++) {
					int cnt=0;
					int x= i;
					int y =j;
					while(arr[i][j]==arr[x][y]){
						
						++cnt;
						x = x+dx[dir];
						y = y+dy[dir];
						if(x<=0||y<=0||x>19||y>19)	break;
					}
					int ax = dx[dir]*-1 + i;
					int ay = dy[dir]*-1 +j;
					
					if(cnt==5) {
						if(arr[ax][ay]==arr[i][j])	continue;	
						System.out.println(arr[i][j]);
						System.out.println(i+" "+j);
						return;
					}
				}
				
			}
		}
		System.out.println(0);
	}
	// 반대방향에 같은 수가 있는지 없는지 확인해야함
}