package com.eazybytes.accounts.TEMP;

import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int [] nums={2,1,5,4,3,5,3,2};
        System.out.println(findDuplicates(nums));

    }

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                res.add(idx + 1);
            nums[idx] = -nums[idx];
        }
        return res;
    }

}
