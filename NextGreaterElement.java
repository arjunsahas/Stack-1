import java.util.Arrays;
import java.util.Stack;
/**
 * LeetCode Problem 503: Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class NextGreaterElement {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    Arrays.fill(result, -1);
    Stack<Integer> s = new Stack<>();
    s.push(0);
    int i = 1;
    int count = 1;
    while (count <= 2 * n) {
      if (i >= n) {
        i = i % n;
      }
      while (nums[i] > nums[s.peek()]) {
        int idx = s.pop();
        result[idx] = nums[i];
        if (s.isEmpty())
          break;
      }
      s.push(i);
      i++;
      count++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result = new NextGreaterElement().nextGreaterElements(new int[] { 1, 2, 3, 4, 3 });
    // Expected output: 2 3 4 -1 4
    print(result);
 
    result = new NextGreaterElement().nextGreaterElements(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
    // Expected output: 74 75 76 72 72 76 -1 74
    print(result);

    result = new NextGreaterElement().nextGreaterElements(new int[] { 30, 40, 50, 60 });
    // Expected output: 40 50 60 -1
    print(result);

    result = new NextGreaterElement().nextGreaterElements(new int[] { 30, 60, 90 });
    // Expected output: 60 90 -1
    print(result);

    result = new NextGreaterElement().nextGreaterElements(new int[] { 90, 80, 70, 60 });
    // Expected output: -1 90 90 90
    print(result);

    result = new NextGreaterElement().nextGreaterElements(new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 });
    // Expected output: 81 53 81 93 93 97 -1 43 78 81
    print(result);

    result = new NextGreaterElement().nextGreaterElements(new int[] { 9, 5, 4, 3, 2, 1, 10 });
    // Expected output: 10 10 10 10 10 10 -1
    print(result);
  }

  private static void print(int[] result) {
    for (int i : result) {
      System.out.print(i + " ");
    }
    System.out.println(" ");
  }
}
