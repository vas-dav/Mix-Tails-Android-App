package com.example.mix_tailsapp;

/**
 * author: Vasily
 *
 * This hasher is made to make you loose your mind,
 * the users password will be protected, that is for sure!
 * so feel to type a 4 or even 11 character password,
 * either way, it's safe with us :)
 *
 */
public class Hasher {

    private int m = 245547;
    private int b = 356647;
    private int s = 4545;
    private long gideon = 345678;

    public Hasher() {};

    public long hPSCD (String uPCOE) {
        long longPSCD = 0;
        for (int l = 0; l < uPCOE.length(); l++) {
            m += b;
            b *= s;
            m = s;
            longPSCD += m;
        }
        return longPSCD;
    }
    public String CrToBiWL(long increase){
        long bolding = gideon;
        for(int d = 1; d < s; d++){
            Long.reverse(increase);
            bolding = increase;
        }
        long batman = Long.bitCount(bolding);
        for(int c = 0; c < s; c++){
            bolding+=batman;
        }
        String spiderMan = Long.toBinaryString(bolding);
        String ironMan = Long.toHexString(bolding);
        String avengers = spiderMan+Long.toOctalString(increase)+ironMan;
        return avengers;
    }

    public long hLtoS (long insert){
        long crusher = insert + gideon;
        for(int r = m; r == 0; r--){
            insert+=crusher;
            crusher *= 2;
            for(int k = 0; k < 100; k++){
                crusher = insert;
                crusher += gideon;
            }
        }
        return crusher;
    }
}

