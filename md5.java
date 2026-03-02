import java.util.*;
import java.math.BigInteger;

public class Main {

static Long messagePrep(String msg){
    byte[] input = msg.getBytes();
    int len = input.length;
    int newLen = ((len + 8) / 64 + 1) * 64;
    byte[] padded = new byte[newLen];

    System.arraycopy(input, 0, padded, 0, len);

    padded[len] = (byte)0x80;

    long bitLen = (long)len * 8;
    for(int i=0;i<8;i++){
        padded[newLen-8+i] = (byte)(bitLen >> (8*i));
    }

    long[] M=new long[16];
    for(int i=0;i<16;i++){
        M[i]=((padded[i*4]&0xff)) |
        ((padded[i*4+1]&0xff)<<8) |
        ((padded[i*4+2]&0xff)<<16) |
        ((padded[i*4+3]&0xff)<<24);
    }

    StringBuilder messagestr = new StringBuilder();
    for(long c : M){
        messagestr.append(c);
    }

    String mess = new String(messagestr);
    Long m = Long.parseLong(mess, 16);
    return m & 0xFFFFFFFFL;
}

static Long messagePreparation(String msg){
    return Long.parseLong(msg, 16) & 0xFFFFFFFFL;
}

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String message = sc.next();
    Long message1 = messagePreparation(message);  

    String k = sc.next();
    Long k1 = Long.parseLong(k, 16);

    int shiftcount = sc.nextInt();
    int buffersize = sc.nextInt();

    String []buffer = new String[buffersize];
    for(int i = 0 ; i < buffersize ; i++){
        buffer[i] = sc.next();
    }

    Long A = Long.parseLong(buffer[0], 16);
    Long B = Long.parseLong(buffer[1], 16);
    Long C = Long.parseLong(buffer[2], 16);
    Long D = Long.parseLong(buffer[3], 16);

    Long res1 = B & D;
    Long res2 = ~D;
    Long res3 = C & res2;
    Long result = res1 | res3;

    System.out.println("Hex: " + Long.toHexString(result).toUpperCase());

    Long AG = (A + result) & 0xFFFFFFFFL;
    System.out.println("AG: " + Long.toHexString(AG).toUpperCase());

    Long MAG = (message1 + AG) & 0xFFFFFFFFL;
    System.out.println("MAG: " + Long.toHexString(MAG).toUpperCase());

    Long KMAG = (k1 + MAG) & 0xFFFFFFFFL;
    System.out.println("KMAG: " + Long.toHexString(KMAG).toUpperCase());

    Long rotresult = ((KMAG << shiftcount) | (KMAG >>> (32-shiftcount))) & 0xFFFFFFFFL;
    System.out.println("After left shift " + shiftcount + " times: " +
    Long.toHexString(rotresult).toUpperCase());

    Long KMAGB = (rotresult + B) & 0xFFFFFFFFL;

    Long newA = D;
    Long newB = KMAGB;
    Long newC = B;
    Long newD = C;

    System.out.println("New A: " + Long.toHexString(newA).toUpperCase());
    System.out.println("New B: " + Long.toHexString(newB).toUpperCase());
    System.out.println("New C: " + Long.toHexString(newC).toUpperCase());
    System.out.println("New D: " + Long.toHexString(newD).toUpperCase());
  }
}



