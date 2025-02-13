import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        Stack<Double> s = new Stack<>();
        
        int n = Integer.parseInt(st.nextToken());
        String a = br.readLine();
        Double arr[]=new Double[n];
        
        for(int i=0 ;i< n ;i++){
            arr[i]=Double.parseDouble(br.readLine());
        }

        for(int i=0 ;i<a.length();i++){
            if(a.charAt(i)>='A'&&a.charAt(i)<='Z'){
                s.add(arr[a.charAt(i)-'A']);
            }
            else{
                Double tmpa = s.pop();
                Double tmpb = s.pop();
                if(a.charAt(i)=='+'){
                    s.add(tmpa+tmpb);
                }
                else if(a.charAt(i)=='-'){
                    s.add(tmpb-tmpa);
                }
                else if(a.charAt(i)=='*'){
                    s.add(tmpa*tmpb);
                }
                else if(a.charAt(i)=='/'){
                    s.add(tmpb/tmpa);
                }
            }
        }
        String result = String.format("%.2f",s.peek());
        System.out.println(result);
    }
}
