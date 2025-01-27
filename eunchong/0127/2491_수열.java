/**
 * 아이디어 : 인덱스마다 오름차순 수열, 내림차순 수열을 구한 후 각각 최대 길이를 배열에 저장해줍니다. 이후 최종적으로 두 수열 중 긴 수열의 길이를 출력합니다.
 * 시간 : 1948 ms
 * 메모리 : 23252 KB
 * 난이도 : 하 (어떻게 구현해야 할지 금방 떠올라서 쉬웠던거 같습니다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int length;          // 입력 받을 숫자의 개수
    static int [] numbers;     // 입력 받은 숫자

    // 주어진 인덱스를 기준으로 오름차순 수열을 찾아 길이를 반환하는 함수
    static int calcAscSequenceLength(int index) {
        int result = 1; // 수열의 길이

        // 반복문을 돌며 수열인지 확인하여 수열의 길이를 구함
        for (int i = index+1; i < length; i++) {
            int prev = numbers[i-1];   // 이전 값을 저장할 배열

            // 이전 값 보다 현재 값이 더 크거나 같으면 수열이기 때문에 수열의 길이를 1 증가
            if (prev <= numbers[i]) {
                result++;
            }
            // 아니면 수열이 아니기 때문에 break
            else {
                break;
            }
        }

        return result;  // 수열의 길이 반환
    }

    // 주어진 인덱스를 기준으로 낼미차순 수열을 찾아 길이를 반환하는 함수
    static int calcDescSequenceLength(int index) {
        int result = 1; // 수열의 길이

        // 반복문을 돌며 수열인지 확인하여 수열의 길이를 구함
        for (int i = index+1; i < length; i++) {
            int prev = numbers[i-1];   // 이전 값을 저장할 배열

            // 이전 값 보다 작거나 같으면 수열이기 때문에 길이를 1 증가
            if (prev >= numbers[i]) {
                result++;
            }
            // 아니면 수열이 아니기 때문에 break
            else {
                break;
            }
        }

        return result;  // 수열의 길이 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());   // 입력받을 숫자의 길이
        numbers = new int[length];  // 입력 받은 숫자

        // 숫자를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int ascSeqLength = calcAscSequenceLength(0);    // 오름차순 수열의 최대 길이
        int descSeqLength = calcDescSequenceLength(0);  // 내림차순 수열의 최대 길이

        // 인덱스를 돌며 오름차순, 내림차순 각각 수열의 최대 길이를 구함
        for (int i = 1; i < length; i++) {
            int asc = calcAscSequenceLength(i);     // 오름차순 수열의 길이
            int desc = calcDescSequenceLength(i);   // 내림차순 수열의 길이

            ascSeqLength = Math.max(ascSeqLength, asc);     // 오름차순 수열의 최대 길이를 계산
            descSeqLength = Math.max(descSeqLength, desc);  // 내림차순 수열의 최대 길이를 계산
        }

        System.out.println(Math.max(ascSeqLength, descSeqLength));  // 최대 수열의 길이를 출력
    }
}
