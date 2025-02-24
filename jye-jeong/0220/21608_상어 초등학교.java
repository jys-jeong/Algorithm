import java.util.;
import java.io.;

public class Main {

	static int n;
	static int board[][];
	static int rel[][];
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		rel =new int[nn+1][4];
		board=new int[n][n];
		for(int i=0 ;inn;i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0;j4;j++) {  a가 좋아하는 친구 넣기
				rel[a][j]=Integer.parseInt(st.nextToken());
			}
			int mxlike=0; 모든 점 중에 각 점에서 인근에 좋아하는 친구의 최대 수
			int mxem=0;  모든 점 중에 각 점에서 인근에 빈 칸의 최대 수
			int sx=n-1; a를 넣을 좌표 sx,sy
			int sy=n-1; 
			for(int k=0;kn;k++) {
				for(int l=0;ln;l++) {
					if(board[k][l]0)	continue;
					int like=0;
					int em=0;
					for(int dir=0;dir4;dir++) {
						int x= k+dx[dir];
						int y= l+dy[dir];
						if(x0y0x=ny=n)	continue;
						if(board[x][y]0) {  인근에 좋아하는 친구 세기
							for(int ii=0;ii4;ii++) {
								if(rel[a][ii]==board[x][y]) {
									++like;
									break;
								}
							}
						}
						if(board[x][y]==0) { 빈 칸 세기
							++em;
						}
					}
					if(mxlikelike) {  비어있는 칸중에서 좋아하는 학생이 인접한 칸에 가장 많은지
						sx=k;
						sy=l;
						mxlike=like;
						mxem=em;
					}
					else if(mxlike==like) {  인접한 칸에 좋아하는 학생의 수가 같다면 빈칸의 수가 많은지
						if(emmxem) {
							sx=k;
							sy=l;
							mxem=em;
						}
						else if(em==mxem) {인접한 칸에 빈칸의 수가 같아면 행의번호가 작은 칸인지
							if(sxk) {
								sx=k;
								sy=l;
							}
							else if(sx==k) {행의 번호가 같다면 열의 번호가 작은 칸인지
								if(syl) {
									sy=l;
								}
							}
						}
					}

					
				}
			}
			board[sx][sy]=a;


			
		}


		int sum=0;
		for(int i=0 ;in;i++) {
			for(int j=0;jn;j++) {
				int cnt=0;
				for(int dir=0;dir4;dir++) {
					int x= dx[dir]+i;
					int y= dy[dir]+j;
					if(x0y0x=ny=n)	continue;
					for(int k=0;k4;k++) {
						if(rel[board[i][j]][k]==board[x][y]) { 인접한 칸에 좋아하는 친구가 몇명 있는지 세기
							++cnt;
						}
					}
					
				}
				if(cnt==0) {값이 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000
					sum+=0;
				}
				else if(cnt==1) {
					sum+=1;
				}
				else if(cnt==2) {
					sum+=10;
				}else if(cnt==3) {
					sum+=100;
				}else if(cnt==4) {
					sum+=1000;
				}
			}
			
		}
		System.out.println(sum);

	}
	
	

}
