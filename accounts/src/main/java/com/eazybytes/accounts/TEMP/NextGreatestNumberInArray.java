package com.eazybytes.accounts.TEMP;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestNumberInArray {
    public static void main(String[] args) {
        int[] arr={6,2,4,9,1,12};
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack();
        //  for(int i=0;i<=arr.length-1;i++)  --> for previous highest
        //  for(int i=arr.length-1;i>=0;i++)  --> for next highest
        for(int i=0;i<=arr.length-1;i++){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }

            result[i]=stack.isEmpty()? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));
    }
}
