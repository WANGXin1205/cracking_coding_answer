package com.programmer.cracking.coding.answer.chapter1;

import java.util.*;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 20:21
 * @Description
 */
public class Same {

    /*
    给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
    给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。

    测试样例：
    "This is nowcoder","is This nowcoder"
     返回：true
     "Here you are","Are you here"
     返回：false
    */

    /**
     * @param stringA
     * @param stringB
     * @return
     */
    public static boolean checkSam(String stringA, String stringB) {
        String[] array = stringA.split("");
        String[] anotherArray = stringB.split("");

        Boolean simpleFlag = array.length == 0 || anotherArray.length == 0 || array.length != anotherArray.length;
        if (simpleFlag) {
            return false;
        }
        Arrays.sort(array);
        Arrays.sort(anotherArray);

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(anotherArray[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String stringA = "abc";
        String stringB = "bca";
        Boolean flag = Same.checkSam(stringA, stringB);
        System.out.println(flag);
        stringA = "cde";
        flag = Same.checkSam(stringA, stringB);
        System.out.println(flag);
        stringA = "aaa";
        flag = Same.checkSam(stringA, stringB);
        System.out.println(flag);
        stringA = "bca";
        flag = Same.checkSam(stringA, stringB);
        System.out.println(flag);
    }

}
