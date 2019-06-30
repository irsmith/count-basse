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
		//if (s.startsWith("-") ... negative
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<s.length()) {
			int qty = 1;
			char cur = s.charAt(i);
			int j=1;
			while (i+j<s.length() && cur == s.charAt(i+j)) {
				j++;
				qty++;
			}
			sb.append(Integer.toString(qty)).append(cur);
			i++;
		}


		return sb.toString();

	}

	private String alg(int n) {
		String rv="";

		return rv;
	}

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("LookAndSay problem STARTS");
		LookAndSay m = new LookAndSay() ;
		System.out.println("All LookAndSay tests passed. You are genius");
		System.out.println("LookAndSay problem ENDS");
	}

}