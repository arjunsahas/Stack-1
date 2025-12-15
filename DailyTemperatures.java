import java.util.Stack;
/**
 * 739. Daily Temperatures
 * url: https://leetcode.com/problems/daily-temperatures/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int i = 1;
        while (!s.isEmpty()) {
            if (i < n) {
                while (temperatures[i] > temperatures[s.peek()]) {
                    int idx = s.pop();
                    result[idx] = i - idx;
                    if (s.isEmpty())
                        break;
                }
                s.push(i);
            } else {
                result[i - 1] = 0;
                if (temperatures[i - 1] < temperatures[i - 2])
                    result[i - 2] = 0;
                s.clear();
            }
            i++;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new DailyTemperatures().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });

        // Expected output: 1 1 4 2 1 1 0 0
        print(result);

        result = new DailyTemperatures().dailyTemperatures(new int[] { 30, 40, 50, 60 });
        // Expected output: 1 1 1 0
        print(result);

        result = new DailyTemperatures().dailyTemperatures(new int[] { 30, 60, 90 });
        // Expected output: 1 1 0
        print(result);

        result = new DailyTemperatures().dailyTemperatures(new int[] { 90, 80, 70, 60 });
        // Expected output: 0 0 0 0
        print(result);

        result = new DailyTemperatures().dailyTemperatures(new int[] { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 });
        // Expected output: 3 1 1 2 1 1 0 2 1 0
        print(result);

        result = new DailyTemperatures().dailyTemperatures(new int[] { 9, 5, 4, 3, 2, 1, 10 });
        // Expected output: 6 5 4 3 2 1 0
        print(result);

    }

    private static void print(int[] result) {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
}
