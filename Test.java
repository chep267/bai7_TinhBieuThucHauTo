package dongcode.bai7;

import java.util.Arrays;
import java.util.Scanner;

public class Test extends TinhBieuThuc {

    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap bieu thuc: ");

        String tt = new String();
        tt = sc.nextLine();

        int n = tt.length();
        char[] ht = new char[n];

        ht = toHauto(tt);
        System.out.println("BT hau to la: " + Arrays.toString(ht));
        double kq = tinhHauto(ht);
        System.out.println("Gia tri bieu thuc la: " + kq);
    }
}
