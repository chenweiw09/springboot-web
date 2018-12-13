package com.xiaomi.chen.springboottest.algorithm;

import org.springframework.util.StringUtils;

import java.util.HashSet;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/9
 * @description
 */
public class Palindrome {


    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写
     * @param str
     * @return
     */
    public int longestPalindrome(String str){

        if(StringUtils.isEmpty(str)){
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int len = str.length();
        int count = 0;
        for(int i =0; i<len;i++){
            if(set.contains(str.charAt(i))){
                set.remove(str.charAt(i));
                count++;
            }else{
                set.add(str.charAt(i));
            }
        }

        return set.isEmpty()?count*2:count*2+1;
    }


    /**
     *  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        if(s == null || s.length()==0){
            return true;
        }

        int i=0, j= s.length()-1;

        while(i<j){
            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j){
                i++;
            }

            while(!Character.isLetterOrDigit(s.charAt(j)) && j>i){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串；
     * 思路：以某个字符为中心，分别计算偶数长度和奇数长度的最大回文串
     * @param s
     * @return
     */
    public String findLongestPalindrome(String s){
        return null;
    }
}
