package com.example.misc;

import java.util.HashMap;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        int[] retValues = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(hash.get(nums[i]) != null) {
                retValues[0] = i;
                retValues[1] = hash.get(nums[i]);
                return retValues;
            } else {
                hash.put(target - nums[i], i);
            }
        }
        return retValues;
    }
    
    public static void main(String[] args) {
    	TwoSums s = new TwoSums();
    	int[] a = s.twoSum(new int[]{3, 2, 4, 2}, 6);
    	for(int i = 0; i < 2; i++) {
    		System.out.println(a[i] + " ");
    	}
    }
}