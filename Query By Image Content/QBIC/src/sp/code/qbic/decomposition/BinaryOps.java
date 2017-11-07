package sp.code.qbic.decomposition;


public class BinaryOps {

   
    public static int power2(byte n) {
        int rslt = 0x1 << (n & 0x1f);
        return rslt;
    } 
    public static byte log2(int val) {
        byte log;

        for (log = 0; val > 0; log++, val = val >> 1){}
            log--;
        

        return log;
    }
    public static int nearestPower2(int val) {
        byte l = log2(val);
        int power = power2(l);

        return power;
    } 
} 
