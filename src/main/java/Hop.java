/**
 * File Name: Hop.java 
 * Hop concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Hop.java HopBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Hop extends HopBase{
	//You cannot have any functions or data here
	Hop() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}
	
	@Override
  int hopSmart(int [] s, int x) {
		//NOTHING CAN BE CHANGED HERE
    return alg(s,x) ;
	}

	/*
	 * WRITE CODE IN alg
	 *  YOU CANNOT USE ANY static variable in this function
	 *  YOU can use many local variables inside the function
	 *  Cannot use any loop statements like:  for, while, do, while, go to
	 *  Can use if
	 *  ONLY AFTER THE execution of this routine array s MUST have the same contents as you got it.
	 *  YOU cannot call any subroutine inside this function except alg itself 
	 *  
	 */

    int alg(int [] s, int x) {

        if (s[x] == x ) {
            return 0;
        }

        // mutate array as we recur
        int tmp = s[x];   //value of array at x
        s[x] = s[tmp];
        int rv = 1 + alg(s, s[x]);
        s[x] = tmp;  //restore at the unwind
        return rv;
	}



	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Hop problem STARTS");
		Hop m = new Hop() ;
		System.out.println("All Hop tests passed. You are great");
		System.out.println("Hop problem ENDS");
	}
}