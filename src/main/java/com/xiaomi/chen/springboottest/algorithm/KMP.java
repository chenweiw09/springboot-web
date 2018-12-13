package com.xiaomi.chen.springboottest.algorithm;

/**
 * @author chenwei
 * @version 1.0
 * @date 2018/10/9
 * @description
 */
public class KMP {


    public static void main(String[] args) {
        String source = "erbyhbrfgkhuefirfbhsdhrfhbqaioqigbeyhdfkdfbhcdyedgbdcybfvgfvbbaaaa";
        String pattern = "aa";

        System.out.println(indexOf(source, pattern));
        System.out.println(indx(source, pattern));
    }


    // 朴素搜索算法
    public static int indexOf(String source, String pattern){

        int i =0, j= 0;
        int sLen = source.length(), pLen = pattern.length();

        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();

        while(i<sLen && j<pLen){
            if(src[i] == ptn[j]){
                i++;
                j++;
            }else{
                i = i-j+1;
                j = 0;
            }
        }

        if(j == pLen){
            return i-j;
        }else {
            return -1;
        }
    }


    private static int[] getNext(char[] p){
        int pLen = p.length;
        int[] next = new int[pLen];

        int k = -1;
        int j = 0;

        next[0] = -1;

        while(j <pLen-1){
            if(k == -1 || p[j] == p[k]){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    private static int[] getN(char[] p){
        int pLen = p.length;
        int[] next = new int[pLen];

        int i=0,j=-1;

        while(i<pLen-1){
            if(j ==-1 || p[i]==p[j]){
                next[++i] = ++j;
            }else{
                j = next[j];
            }
        }
        return next;
    }


    public static int index1(String source, String pattern){

        int i=0, j=0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length, pLen = ptn.length;

        int[] next = getN(pattern.toCharArray());
        while(i<sLen && j < pLen){
            if(j == -1 || src[i] == ptn[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == pLen){
            return i-j;
        }else{
            return -1;
        }

    }

    public static int indx(String source, String pattern){

        int i =0, j=0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();

        int sLen = src.length;
        int pLen = ptn.length;

        int[] next = getNext(ptn);
        while(i<sLen && j<pLen){
            if(j == -1 || src[i] == ptn[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }

        if(j == pLen){
            return i-j;
        }

        return -1;

    }

}
