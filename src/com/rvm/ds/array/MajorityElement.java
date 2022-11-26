package com.rvm.ds.array;

/**
 * https://www.scaler.com/topics/course/dsa-interviews-java/video/570/
 * 
 * Moore's Voting Principle
 */
public class MajorityElement {

    public Integer getMajorityElement(int[] arr) {

        int candidate = arr[0];
        int votes = 0;

        for (int i = 0; i < arr.length; i++) {
            if (candidate == arr[i]) {
                votes++;
                continue;
            }
            votes--;
            if (votes == 0) {
                candidate = arr[i];
                votes = 1;
            }
        }

        // TO CHECK THE CANDIDATE IS VALID
        int acutalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate)
                acutalCount++;
        }

        return (acutalCount > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.getMajorityElement(new int[] { 4, 4, 3, 4, 7, 3, 4, 4, 7, 4, 4, 7, 4, 4 }));
        System.out.println(majorityElement.getMajorityElement(new int[] { 1, 2, 3, 4, 5, 1 }));

    }
}
