package bth_7;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;



public class TinhBT {

    //Do uu tien:
    public static int isO(Object x){
        char c = (char) x;
        if(c=='+' || c=='-'){ return 1;}
        if(c=='*' || c=='/'){ return 2;}
        return 0;
    }

    public static char[] toHauto(String a){
        Stack s = new Stack();
        char x, token;
        char[] tt = a.toCharArray();
        char[] ht = new char[a.length()];
        int i=0, j=0;    //i-gia tri cua tien to,j-gia tri cua hau to

        for (i = 0; i< a.length(); i++)
        {
            token = tt[i];
            if (isO(token) == 0){
                ht[j++] = token;
            }
            else{
                if(s.empty()){
                    s.push(token);
                }
                else{
                    x = (char) s.peek();
                    if(isO(x) < isO(token)){
                        s.push(token);
                    }else{
                        ht[j++] = x;
                        s.pop();
                        s.push(token);
                    }
                }
            }
        }
        for (j=j; j<i; j++) {
            ht[j]= (char) s.pop();
        }

        return ht;
    }


    //Tinh toan:
    public static long Tinhhauto(char[] a){
        long kq = 0;
        Stack st = new Stack();
        int i =0; int tong = 0, tich =1;
        for (i = 0; i < a.length; i++) {
            if(isO(a[i])==0){
                st.push(a[i]);
            }else{
                if(a[i]=='*'){
                    tich = (int)st.pop()* (int)st.pop();
                    st.push(tich);
                }
                if(a[i]=='/'){
                    tich = (int)st.pop()/ (int)st.pop();
                    st.push(tich);
                }
                if(a[i]=='+'){
                    tong = (int)st.pop()+ (int)st.pop();
                    st.push(tong);
                }
                if(a[i]=='-'){
                    tong = (int)st.pop()- (int)st.pop();
                    st.push(tong);
                }
            }

        }
        kq = tong+tich;
        return kq;
    }



    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap bieu thuc: ");
        String tt = new String();
        tt = sc.nextLine();
        int n = tt.length();
        char[] ht = new char[n];
        ht = toHauto(tt);
        System.out.print("\nBT hau to la: "+ Arrays.toString(ht));
        long kq = Tinhhauto(ht);
        System.out.print("\nGia tri bieu thuc la: "+kq);
    }
}
