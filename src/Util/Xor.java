package Util;

public class Xor {
    public static boolean logicalXOR(boolean x, boolean y) {
        return ( ( x || y ) && ! ( x && y ) );
    }
}

