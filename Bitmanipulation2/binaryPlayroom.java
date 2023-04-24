package Bitmanipulation2;
import java.util.*;

class binaryPlayroom {

  public static void displayBinary(long n) {
    System.out.print(n + ": ");
    String s = "";

    for (int i = 0; i < 32; i++) {
      long isIthBitSet = (n & 1);
      n >>= 1;
      s = isIthBitSet + s;
    }
    System.out.println(s);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // int n = Integer.MIN_VALUE;
    // n *= -1;

    // displayBinary();
    
    // displayBinary(-12314);
    // displayBinary(Integer.MAX_VALUE);
    // System.out.println(Integer.MAX_VALUE + 5 );
    // System.out.println(Integer.MIN_VALUE);

    // int n = -77;
    displayBinary(-2 & (1L*1<<31));
    // for(int i = 0;i<32;i++){
    //     displayBinary(-2);
    //     // n<<=1;
    //     n>>=1;
    // }

  }
}
