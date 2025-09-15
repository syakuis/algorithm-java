package pattern;

import org.junit.jupiter.api.Test;

/**
 * 슬라이딩 윈도우(Sliding Window)**는 배열이나 문자열에서 연속된 구간(윈도우)을 유지하며 이동시키는 최적화 기법으로, 중복 계산을 줄여 O(n²)를 O(n)으로 개선하는 강력한 패턴이다. 고정 길이와 가변 길이 두 타입이 있으며, 부분 배열/부분 문자열 문제에 널리 쓰인다.
 */
public class SlidingWindowTest {
    // 고정 길이 윈도우 예시: 크기 K 부분 배열의 최대 합
    int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }



    @Test
    void test() {

    }
}
