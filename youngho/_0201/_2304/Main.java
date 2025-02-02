package _0201._2304;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer>  gidung = new HashMap<>();
        int tallest_position = 0;
        int tallest_height = 0;

        int[] positions = new int[N];
        for(int i = 0; i < N; i++){
            int position = sc.nextInt();
            int height = sc.nextInt();

            positions[i] = position;

            if(height > tallest_height){
                tallest_height = height;
                tallest_position = position;
            }

            gidung.put(position, height);
        }

        Arrays.sort(positions);

        int result = 0;



    }
}
//7
//2 4
//11 4
//15 8
//4 6
//5 3
//8 10
//13 6
