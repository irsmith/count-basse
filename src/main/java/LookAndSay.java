import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * File Name: LookAndSay.java
 * LookAndSay concrete class
 *
 *
 * To Compile: IntUtil.java RandomInt.java LookAndSay.java LookAndSayBase.java
 *
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class LookAndSay extends LookAndSayBase{
	LookAndSay() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}

	@Override
	protected String lookAndSay(String s) {
		//NOTHING CAN BE CHANGED HERE
		return alg(s) ;
	}

	@Override
	protected String lookAndSay(int n) {
		//NOTHING CAN BE CHANGED HERE
		return alg(n) ;
	}

	private String alg(String s) {
		if (s == null) throw new RuntimeException();
		if (s.isEmpty()) return s;


		StringBuilder sb = new StringBuilder();
		int i = 0;
		char cur;
		int qty = 1;
		// start at index 0 and look ahead to next index unless end of string.  End of string is i+1 == length
		while (i<s.length()) {
			cur = s.charAt(i);

			if (i+1 == s.length()) {
				sb.append(Integer.toString(qty)).append(cur);
				break;
			}
			if (cur == s.charAt(i+1)) {
				qty++;
			} else {
				sb.append(Integer.toString(qty)).append(cur);
				qty = 1;
			}
			i++;
		}
		return sb.toString();

	}


	// given index of look-and-say sequence, return its value
	//https://en.wikipedia.org/wiki/Look-and-say_sequence
	private Map<Integer, String> dp = new HashMap<>( );

	private Integer maxCache = null;


	// input range, 0 to INTEGER MAX
	private String alg(int n) {
		long start = System.currentTimeMillis();
		if (n ==  0 || n == 1) {
			dp.put(n,"1");
			return "1";
		}

		//value is available in the cache
		if (dp.get(n) != null) {
			return dp.get(n);
		}

		// calc value from maxCache to n
		String cur="1";
		for (int i=1 ;i<n;i++) {

			cur = alg(cur);
			u.myassert(cur != null);
			dp.put(i, cur);

		}
		System.out.println(String.format("n:%d time:%s", n, System.currentTimeMillis() - start));
		return cur;
	}

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("LookAndSay problem STARTS");
		LookAndSay m = new LookAndSay() ;
		System.out.println("All LookAndSay tests passed. You are genius");
		System.out.println("LookAndSay problem ENDS");
	}

}
