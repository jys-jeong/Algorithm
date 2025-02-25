/**
 * 아이디어 : 1~N까지의 모든 수열을 구하고 칼로리의 총합이 제한선을 넘지 않는 애들만 따로 저장, 그 후 맛 선호도 최디 갮을 찾음
 * 시간 : 1,090 ms
 * 메모리 : 115,776 kb
 * 난이도 : 중 (수열 개념에 칼로리 체크와 선호도 최대값 도출 로직만 추가하면되서 무난하게 풀 수 있었습니다.)
 */

import java.io.*;
import java.util.*;

// 재료의 정보를 저장할 클래스 선언
class Ingredient {
    int flavor;     // 맛 선호도 점수
    int calorie;    // 칼로리

    // 생성자
    public Ingredient(int flavor, int calorie) {
        this.flavor = flavor;
        this.calorie = calorie;
    }
}

public class Solution {
    static int N, L;                        // 재료의 개수와 최대 칼로리
    static Ingredient[] ingredients;        // 재료를 저장할 배열
    static Ingredient[] selections;         // 선택한 재료를 저장할 배열
    static ArrayList<Ingredient[]> result;  // 수열을 통해 찾은 모든 경우의 수를 저장할 리스트

    // 수열 조합 세트 중 맛에 대한 선호도 합이 가장 높은 세트의 선호도 합을 반환하는 함수
    static int getMaxFlavor() {
        int maxFlavor = 0;  // 최대 선호도 합

        // 반복문을 돌며 수열 케이스를 하나씩 뽑음
        for (Ingredient[] selectedIngredients: result) {
            int sumFlavor = 0;  // 수열 케이스에서 맛 점수의 합

            // 수열 케이스를 하나씩 돌며 재료를 하나씩 꺼내 맛 점수의 합을 구함
            for (Ingredient selectedIngredient: selectedIngredients) {
                sumFlavor += selectedIngredient.flavor;
            }

            // 최대 선호도 합 보다 현재 선호도 합이 더 크면 대입
            if (maxFlavor < sumFlavor)
                maxFlavor = sumFlavor;
        }

        return maxFlavor;   // 최대 맛 점수를 반환
    }

    static void combination(int cnt, int start, int R) {
        // 햄버거 재료 수열을 완성했으면
        if (cnt == R) {
            int sum = 0;    // 칼로리의 총합을 저장할 변수

            // 칼로리의 총합을 구한 후
            for (Ingredient i: selections) {
                sum += i.calorie;
            }

            // 제한된 칼로리 이하면
            if (sum <= L)
                // 모든 경우의 수를 저장할 리스트에 추가
                result.add(Arrays.copyOf(selections, selections.length));

            return; // 함수 종료
        }

        // 첫번째 부터 마지막 재료까지 돌면서 탐색 진행
        for (int i = start; i < N; i++) {
            selections[cnt] = ingredients[i];       // 선택한 재료에 현재 재료 추가
            combination(cnt+1, i+1, R);    // 다음 재료를 찾으러 감
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수를 입력받음

        // 테스트 케이스 개수만큼 연산 처리
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 재료 개수를 입력받음
            L = Integer.parseInt(st.nextToken());   // 최대 칼로리를 입력받음

            ingredients = new Ingredient[N];    // ingredients 배열 초기화

            // 반복문을 돌며 재료를 입력받음
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                int flavor = Integer.parseInt(st.nextToken());  // 맛 점수를 입력받음
                int calorie = Integer.parseInt(st.nextToken()); // 칼로리를 입력받음

                ingredients[j] = new Ingredient(flavor, calorie); // 새로운 재료 추가
            }

            int totalMaxFlavor = 0; // 전체 최대 맛 점수 합

            // 재료를 1개 부터 N개 고르는 모든 수열을 구해서 최대 맛 점수 합을 구함
            for (int j = 1; j <= N; j++) {
                selections = new Ingredient[j];  // selections 배열 초기화
                result = new ArrayList<>();      // result 리스트 초기화
                combination(0, 0, j);   // nCj 수열을 찾으러 감
                int maxFlavor = getMaxFlavor();  // 최대 맛 점수 합을 구함

                // 전체 최대 맛 점수 합 보다 현재 맛 점수 합이 더 높으면 대입
                if (totalMaxFlavor < maxFlavor)
                    totalMaxFlavor = maxFlavor;
            }

            // 결과를 StringBuilder에 저장
            sb.append("#").append(i).append(" ").append(totalMaxFlavor).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}