package dongcode.bai7;

import java.util.Arrays;
import java.util.Scanner;

public class Test extends TinhBieuThuc{

    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap bieu thuc: ");

        String tt = new String();
        tt = sc.nextLine();

        int n = tt.length();
        char[] ht = new char[n];

        ht = toHauto(tt);
        System.out.print("\nBT hau to la: "+ Arrays.toString(ht));
        double kq = Tinhhauto(ht);
        System.out.print("\nGia tri bieu thuc la: "+kq);
    }
}
