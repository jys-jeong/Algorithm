/**
 * 아이디어 : 두 번째 수가 첫 번째 수의 절반 부터는 길이가 가장 짧아지기 때문에, 두 번째 수가 첫 번째 수의 절반이 되기까지 브루트포싱을 해서 최대 길이를 계산
 * 시간 : 156 ms
 * 메모리 : 18852 KB
 * 난이도 : 중 (자잘한 부분들이 계속 잘못된 결과를 만들어내서 디버깅이 좀 힘들었습니다.)
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // n 입력받기
        StringBuilder numbers = new StringBuilder();    // 가장 긴 숫자들을 저장할 변수

        // 0이면 0 0 출력하고 종료
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        // 두 번째 수가 첫 번째 수의 절반 미만으로 가면 짧은 숫자들이 나올 수 밖에 없기 때문에 범위를 n / 2로 제한
        for (int i = n; i >= n / 2; i--) {
            StringBuilder sb = new StringBuilder();

            // 첫 번째 수 추가
            sb.append(n).append(" ");
            int first = n;  // 첫 번째수
            int second = i; // 두 번째수

            // 음의 정수가 되기 전까지 앞 두를 빼서 뒤 수를 구하는 연산 반복
            while (second >= 0) {
                sb.append(second).append(" ");  // 두 번째 수 추가
                int tmp = first;
                first = second; // 첫번째 수 변경
                second = tmp - second;  // 두 번째 수 변경
            }

            // 새롭게 구한 수들이 기존의 수들보다 길다면 변경
            if (numbers.toString().length() < sb.toString().length())
                numbers = sb;
        }

        String[] result = numbers.toString().split(" ");

        // 가장 긴 숫자들의 길이를 출력
        System.out.println(result.length);

        // 가장 긴 숫자들을 출력
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
