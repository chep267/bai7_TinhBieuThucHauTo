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

    public static double Tinhhauto(char[] a){
        Stack<Double> st = new Stack<Double>();
        int i =0; double x = 0, y =1;
        double kq =0;

        for (i = 0; i < a.length; i++) {
            if(isO(a[i])==0){
                st.push((double) (a[i]-48));
            }else{
                x=  st.pop(); y= st.pop();
                switch (a[i]) {
                    case '+' : st.push(x+y); break;
                    case '-' : st.push(x-y); break;
                    case '*' : st.push(x*y); break;
                    case '/' : st.push(x/y); break;
                    default:
                        break;
                }
//                if(isO(a[i])==2){
//                    if(a[i]=='*'){
//                        tich = (int)st.pop()* (int)st.pop();
//                        st.push(tich);
//                        System.out.print("\n"+tich);
//                    }
//                    if(a[i]=='/'){
//                        tich = (int)st.pop()/ (int)st.pop();
//                        st.push(tich);
//                        System.out.print("\n"+tich);
//                    }
//                }
//                if(isO(a[i])==1){
//                    if(a[i]=='+'){
//                        tong = (int)st.pop()+ (int)st.pop();
//                        st.push(tong);
//                        System.out.print("\n"+tich);
//                    }
//                    if(a[i]=='-'){
//                        tong = (int)st.pop()- (int)st.pop();
//                        st.push(tong);
//                        System.out.print("\n"+tich);
//                    }
//                }
            }
        }
        kq = st.peek();
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
        double kq = Tinhhauto(ht);
        System.out.print("\nGia tri bieu thuc la: "+kq);
    }
}
