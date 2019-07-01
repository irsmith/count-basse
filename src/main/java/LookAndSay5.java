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
		if (s == null || s.isEmpty() ) throw new RuntimeException("illegal arg");
		if (s == "1" || s == "0") return s;

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<s.length()) {
			int qty = 1;
			char cur = s.charAt(i);
			while (i+qty<s.length() && cur == s.charAt(i+qty)) {
				qty++;
				i++;
			}
			sb.append(Integer.toString(qty)).append(cur);
			i++;
		}


		return sb.toString();

	}


	// Map of index of look-and-say sequence and the value at that index
	// https://en.wikipedia.org/wiki/Look-and-say_sequence
	private Map<Integer, String> dp = new HashMap<>( );


	private Integer maxCachedIndex = 1;

	private String alg(int n) {
		long start = System.currentTimeMillis();
		if (dp.get(1) == null) dp.put(1,"1");

		//value is available in the cache
		if (dp.get(n) != null) {
			return dp.get(n);
		}

        // calc value from 1 to n not using cache
		String cur="1";
		for (int i=1 ;i<n;i++) {
				cur = alg(cur);
		}

		// calc value from maxCache to n
//		String cur = dp.get(maxCachedIndex);
//		for (int i=maxCachedIndex;i<n;i++) {
//			cur = alg(cur);
//			dp.put(i, cur);
//			maxCachedIndex = i;
//		}

		System.out.println(String.format("n:%d time:%s", n, System.currentTimeMillis() - start));
		return cur;// dp.get(n);
	}

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("LookAndSay problem STARTS");
		LookAndSay m = new LookAndSay() ;
		System.out.println("All LookAndSay tests passed. You are genius");
		System.out.println("LookAndSay problem ENDS");
	}

}