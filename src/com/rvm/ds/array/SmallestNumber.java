package com.rvm.ds.array;

/*
 * Smallest Number whos product of Digit is N
 * 
 * ref - https://www.scaler.com/topics/course/dsa-interviews-java/video/592/
 */
class SmallestNumber {

    public Integer getSmallestNumber(Integer n) {

        String ans = "";
        int div = 9;

        while (div >= 2) {
            if (n % div == 0) {
                ans = div + ans;
                n = n / div;
                continue;
            }
            div--;
        }

        return n != 1 ? -1 : Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();

        System.out.println(smallestNumber.getSmallestNumber(81000));
        System.out.println(smallestNumber.getSmallestNumber(1000));
        System.out.println(smallestNumber.getSmallestNumber(13));
        System.out.println(smallestNumber.getSmallestNumber(77));
    }

}