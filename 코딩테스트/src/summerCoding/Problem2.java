package summerCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {

	public static void main(String[] args) {
		System.out.println(solution(10000));
		System.out.println(10e9);
	}

	static private List<Long> exp() {
        List<Long> result = new ArrayList<>();
        long x = 1;
        while (x < 10e9) {
            result.add(x);
            x *= 3;
        }
        return result;
    }

    static public long solution(long n) {
        long answer = 0;

        List<Long> exp = exp();
        for (int j = 0; j < exp.size(); j++) {
            if ((n & (1 << j)) != 0) {
                answer += exp.get(j);
            }
        }

        return answer;
    }
}
