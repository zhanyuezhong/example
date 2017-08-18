package com.zyz.jdk8;


import java.text.DateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * User: 张月忠
 * Date: 2017/8/18
 * Time: 上午11:54
 * To change this template use File | Settings | File Templates.
 */

public class LambdaTest{
    static Supplier<DateFormat> dataFormatSupplier =()-> DateFormat.getDateInstance();
    static ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(dataFormatSupplier);
    interface IntPred {
        boolean test(Integer value);
    }
   static boolean check(Integer value,Predicate<Integer> predicate){
        return predicate.test(value);
    }
//   static boolean check(Integer value,IntPred predicate){
//        return predicate.test(value);
//    }

    public static void main(String[] args){

        //check(a,x -> x % 5==0);
//        List<String> strings = Arrays.asList("A","B","C","D");
//        List<String> c = strings.stream().filter(str -> {
//            System.out.println(str);
//            return str.compareTo("C") > 0;
//        }).collect(Collectors.toList()).stream().filter(str -> str.length() > 0).collect(toList());
        Optional<Integer> reduce = Stream.of(1, 2, 4, 5, 6, 7, 8, 9, 1000).reduce((a, b) -> a + b);
        System.out.println(reduce.get());
        //System.out.println(count);
    }
}
