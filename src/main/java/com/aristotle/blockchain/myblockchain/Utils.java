package com.aristotle.blockchain.myblockchain;

public class Utils {
    static String zeros(int difficulty) {
        return repeatZeros(new StringBuffer(), difficulty).toString();
    }

    private static StringBuffer repeatZeros(StringBuffer sb, int times) {
        if(times == 0) {
            return sb;
        }
        return repeatZeros(sb.append("0"), times-1);
    }
}
