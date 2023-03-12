
package techbank;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Format {
    
    static NumberFormat formatandoValores = new DecimalFormat("R$ #.##0,00");
    
    public static String DoubleToString(Double valor){
        return formatandoValores.format(valor);    
    }
    
}
