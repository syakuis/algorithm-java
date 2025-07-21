package book.hellocoding;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
    Integer binarySearch(int[] nums, int item) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int num = nums[mid];

            if (num == item) {
                return mid;
            } else if (num > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return null;
    }

    @Test
    void test() {
        assertEquals(binarySearch(new int[]{1,3,5,7,9}, 3), 1);
        assertEquals(binarySearch(new int[]{1,3,5,7,9}, -1), null);
    }
}
