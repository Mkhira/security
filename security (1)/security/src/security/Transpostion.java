package security;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Maruoma M7md
 */
public class Transpostion {
    
    String SpaceFree (String PT){
        String SFPT = "" ;
        for(int i =0 ; i < PT.length() ; i++ ){
            if(PT.charAt(i) != ' '){
                SFPT += PT.charAt(i);
            }
        }
        return SFPT;
    }
    
    String GetSirial(String k ){
        String SKey ="";
        char [] Key =new char[k.length()];
        for(int i=0 ; i < k.length() ; i++){
            Key[i]=k.charAt(i);
        }
        Arrays.sort(Key);
        for(int i=0 ; i < k.length() ; i++){
            SKey += Key[i];
        }
        return SKey;
    }
    //encryption
    String Encrypt(String Key , String PT){
        Transpostion ob =new Transpostion();
        int r,c,need;
        String CT ="";
        String SKey = ob.GetSirial(Key);
        c = Key.length();
        PT =ob.SpaceFree(PT);

       
        System.out.println();
        need = c - (PT.length() % c);
        char [] lastchar =new char[need];
        if(PT.length() % c == 0){
            r = PT.length() / c ;
        }else{
            r = 1 + PT.length() / c ;
        }
        char d ='Z' ;
        for(int i = need ; i > 0 ; i--){
            if (i == need){
                lastchar[i-1] = d;
            } else{
                lastchar[i-1] = --d;
            }
        }
   
        int l = 0  , ll = 0 ;
        char[][] Array =new char [r][c];
        for(int i =0 ; i < c ; i++){
            System.out.print(Key.charAt(i)+" ");
        }
        System.out.println();
        System.out.println("--------------------");
        for(int i =0 ;i < r ; i++){
            for(int j = 0 ; j < c ; j++ ){
                if(l < PT.length()){
                    Array[i][j]=PT.charAt(l++);
                }else{
                    Array[i][j]=lastchar[ll++];
                }
                System.out.print(Array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i =0 ;i < Key.length() ; i++){
            for(int j = 0 ; j < Key.length() ; j++ ){
                if(SKey.charAt(i) == Key.charAt(j)){
                    for(int k = 0 ; k < r ; k++){
                        CT += Array[k][j];
                    }
                }
            }
        }
        return CT;
    }
    //decryption
    String Decrypt(String Key , String CT){
        Transpostion ob = new Transpostion();
        String SKey= ob.GetSirial(Key);
        int c = Key.length();
        int r = CT.length() / c ;
        int l = 0;
 
        String PT="";
        char[][] Array = new char[r][c];
        
        for(int i =0 ;i < Key.length() ; i++){
            for(int j = 0 ; j < Key.length() ; j++ ){
                if(SKey.charAt(i) == Key.charAt(j)){
                    for(int k = 0 ; k < r ; k++){
                       Array[k][j] += CT.charAt(l++);
                    }
                }
            }
        }
        System.out.println();
        for (int i = 0; i < c; i++) {
            System.out.print(Key.charAt(i)+" ");
        }
        System.out.println();
        System.out.println("--------------------");
        
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c ; j++) {
                System.out.print(Array[i][j] + " ");
                PT += Array[i][j];
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("plain Text: "+PT);
        char d ='Z' ;
        String plt="";
        for(int h=0;h<PT.length();h++){
             if(PT.charAt(h) > d){
                    plt +=PT.charAt(h) ;
                }else{
                    plt.replace(d, ' ');
                }
        }
        return plt;
    }
    
    public static void main(String[] args) {
  
        Transpostion ob = new Transpostion();
        //encryption
        String CT="";
        CT = ob.Encrypt("Securit","we need more snow now");
        System.out.println("Chiper Text : " + CT);
        //decryption
        String PLT ="";
        PLT= ob.Decrypt("Securit","wonnewerodoYenXmwZesW");
        System.out.println();
        System.out.println("Plain Text :" + PLT);
    }
}
