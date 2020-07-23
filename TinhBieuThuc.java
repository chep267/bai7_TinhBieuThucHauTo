package dongcode.bai7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;



public class TinhBieuThuc {


    //Do uu tien:
    public static int isOperator(Object x) {
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
            if (isOperator(token) == 0){
                ht[j++] = token;
            }
            else{
                if(s.empty()){
                    s.push(token);
                }
                else{
                    x = (char) s.peek();
                    if(isOperator(x) < isOperator(token)){
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
        //Stack<Character> stdau = new Stack<Character>(); //luu dau
        Stack<Double> stso = new Stack<Double>(); //luu so
        int i =0; double x = 0, y =1; char o;
        double kq =0;

        for (i = 0; i < a.length; i++) {
            if(isOperator(a[i])==0){
                stso.push((double) (a[i]-48) );
            }else{
                y = stso.pop(); x= stso.pop();
                switch (a[i]) {
                    case '+' : stso.push(x+y); break;
                    case '-' : stso.push(x-y); break;
                    case '*' : stso.push(x*y); break;
                    case '/' : stso.push(x/y); break;
                    default:
                        break;
                }
            }
        }
        kq = stso.peek();
        return kq;
    }


}