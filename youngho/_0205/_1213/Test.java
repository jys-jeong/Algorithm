package _0205._1213;

public class Test {
    public static void main(String[] args) {

        String s = "aabaa";

        int n = s.length();
        for(int i = 0; i < n/2 ; i++){
            if(s.charAt(i) == s.charAt(n - i - 1)){
                System.out.println(s.charAt(i));

                if(i == n/2 - 1){
                    System.out.println("here");
                    System.out.println(s);
                }
            }
        }

    }
}
