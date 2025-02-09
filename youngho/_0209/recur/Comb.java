package _0209.recur;

public class Comb {
    private static int  comb(int n, int k){
        // basis
        if(k == 0){
            return 1;
        } else if (n == k) {
            return 1;
        }

        // inductive
        System.out.println("n : " + n + ", k : " + k);
        return comb(n - 1, k - 1) + comb(n - 1, k);
    }

    public static void main(String[] args) {

        int result = comb(5, 3);

        System.out.println("result:" + result);

    }
}
