package com.np;

import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();
        nums.add(213);
        nums.add(0, 123);
        System.out.println(nums.pop());
        nums.add(0, 2134);
        nums.add(0, 111);
        nums.add(0, 222);

        System.out.println(nums.pop());
        System.out.println(nums.pop());

        ArrayList<Integer> nums2 = new ArrayList<>();
//        nums2.
    }
}
