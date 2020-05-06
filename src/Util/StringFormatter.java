package Util;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class StringFormatter {

    public static String formatString(String palabraFormatear){
        byte[] asignaturabytes = palabraFormatear.getBytes(ISO_8859_1);
        String palabraFormateada = new String(asignaturabytes,UTF_8);
        return palabraFormateada;
    }
}
