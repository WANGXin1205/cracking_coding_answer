package com.programmer.cracking.coding.answer.chapter1;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 21:12
 * @Description
 */
public class Zipper {

    /*
    利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
    若压缩后的字符串没有变短，则返回原先的字符串。
    给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，
    为所求的压缩后或未变化的串。

    测试样例
    "aabcccccaaa"
    返回："a2b1c5a3"
    "welcometonowcoderrrrr"
    返回："welcometonowcoderrrrr"
     */

    /**
     * @param iniString
     * @return
     */
    public static String zipString(String iniString) {
        StringBuilder zipString = new StringBuilder();
        Integer originStringLength = iniString.length();
        if (originStringLength.equals(0)) {
            return zipString.toString();
        }
        String[] strings = iniString.split("");
        String lastString = strings[0];
        Integer count = 1;
        for (int i = 1; i < strings.length; i++) {
            if (lastString.equals(strings[i])) {
                count++;
            } else {
                zipString.append(lastString).append(count);
                lastString = strings[i];
                count = 1;
            }
            if (strings.length - 1 == i && count != 0) {
                zipString.append(lastString).append(count);
            }
        }
        if (zipString.toString().length() >= originStringLength){
            zipString = new StringBuilder(iniString);
        }

        return zipString.toString();
    }

    public static void main(String[] args) {
        String string = "aabcccccaaa";
        String zipperString = Zipper.zipString(string);
        System.out.println(zipperString);
        string = "welcometonowcoderrrrr";
        zipperString = Zipper.zipString(string);
        System.out.println(zipperString);
    }

}
