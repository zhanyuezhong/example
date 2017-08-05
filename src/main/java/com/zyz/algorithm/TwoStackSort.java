package com.zyz.algorithm;

import java.util.Stack;

/**
 * User: 张月忠
 * Date: 2017/7/21
 * Time: 下午4:24
 * To change this template use File | Settings | File Templates.
 */

public class TwoStackSort {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(2);
        stack.push(49);

        stack.push(3);
        stack.push(1);
        stack.push(0);
        stack.push(-1);
        sortStack(stack);

        while (!stack.isEmpty()){
            //stack.push(helper.pop());
            System.out.println(stack.pop());
        }
    }

    public static void sortStack(Stack<Integer> stack){
        if(stack==null||stack.isEmpty())
            throw new RuntimeException("stack not allow Empty!");
        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()){
            Integer stackTop = stack.pop();
            if(helper.isEmpty()){
                helper.push(stackTop);
            }else{
                Integer helperTop = helper.peek();
                if(stackTop<helperTop){
                    helper.push(stackTop);
                }else{
                    while (!helper.isEmpty()&&stackTop>helper.peek()){
                        stack.push(helper.pop());
                    }
                    helper.push(stackTop);
                }
            }
        }


        //颠倒顺序

        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }

    }
}
