package util;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by asus on 2017/8/4.
 */
public class IdGenertor {
    public static String genGUID(){
        return  new BigInteger(165, new Random()).toString(36).toUpperCase();//GUID

    }
}
