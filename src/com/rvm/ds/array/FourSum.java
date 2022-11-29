package com.rvm.ds.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/4sum/description/
 * 
 * kSum - https://leetcode.com/problems/4sum/solutions/238725/ksum-java-solution-intuitive-and-clean/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(4, nums, target, 0);
    }

    // k sum alogorithm
    private static List<List<Integer>> kSum(int k, int[] nums, int target, int startIndex) {
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();

        // if the k of greater than the elements we will return empty list
        if (k > len - startIndex) {
            return res;
        }

        // if K is 2
        if (k == 2) {
            int i = startIndex;
            int j = len - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    // linked list for add the num value before to this list for k > 2
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);

                    // duplicate case skipping
                    while (i < j && nums[i] == nums[++i])
                        ;
                    while (i < j && nums[j] == nums[--j])
                        ;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = startIndex; i < len; i++) {
                // duplicate case skipping
                if (i > startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }
                // if the value is not in integer limit we will skipping those
                long differenceInLong = (long) target - nums[i];
                if (differenceInLong > Integer.MAX_VALUE || differenceInLong < Integer.MIN_VALUE) {
                    continue;
                }
                List<List<Integer>> result = kSum(k - 1, nums, target - nums[i], i + 1);
                for (List<Integer> temp : result) {
                    // adding the value before to the result get from k-1
                    temp.add(0, nums[i]);
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        System.out.println(f.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
        System.out.println(f.fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
    }

}
