package Util;

import javax.servlet.http.HttpServletRequest;
import Util.Constantes;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SecurityFilter {

    public static boolean CheckUserType(int desiredUserType, HttpServletRequest request){
        boolean accesoAdmitido;

        int sessionUserType  = Integer.parseInt((String)request.getSession().getAttribute("usertype"));
        if (sessionUserType == desiredUserType ){
            accesoAdmitido = true;
        }else{
            accesoAdmitido = false;
        }

        return accesoAdmitido;

    }
}
