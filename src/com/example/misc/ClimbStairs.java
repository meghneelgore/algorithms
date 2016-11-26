package com.example.misc;

import java.util.HashMap;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 * @author meghneel.gore
 *
 */
public class ClimbStairs {

	HashMap<Long, Long> map = new HashMap<>();
	public long climbStairs(long n) {
		map.put(0L, 1L);
		map.put(1L,  1L);
		return climb(n);

	}
	
	public long getMapSize() {
		return map.size();
	}

	private long climb(long n) {
		if(n == 0) return 1;
		//if(n == -1) return 1;

		long one = 0;
		long two = 0;
		if(map.get(n) != null) {
			return map.get(n);
		}
		if(n >= 1) {
			one = climb(n - 1);
		}
		if(n >= 2) {
			two = climb(n - 2);
		}
		map.put(n, one + two);
		return one + two;
	} 


	public static void main(String[] args) {
		ClimbStairs stairClimber = new ClimbStairs();

		long start = System.currentTimeMillis();
		System.out.println(stairClimber.climbStairs(400));
		System.out.println("Took " + (System.currentTimeMillis() - start) + "ms" + " size of hashmap = " + stairClimber.getMapSize());
	}
}
