
package security;

import java.util.ArrayList;

public class ceaser {
 static char [] alph={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
   ,'v','w','x','y','z'};
static ArrayList<String> alpha=new ArrayList<String>();
static char [] alphSpace={'_','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
   ,'v','w','x','y','z'};
static ArrayList<String> alphaSpace=new ArrayList<String>();

    //encryption without space
public static String EncrCeaserWithoutSpace(String plain,int key){
    int key1;
    String plainText;
    
    
        
        for(int i=0;i<26;i++){
            alpha.add(String.valueOf(alph[i]));
        }
       
         plainText=plain;      
         key1=key;
      
        //removing space
        plainText=plainText.replaceAll("\\s+", "");
        char [] plainArr=plainText.toCharArray();
        
         ArrayList<String> plainchar=new ArrayList<String>();
        for(int i=0;i<plainArr.length;i++){
           plainchar.add(String.valueOf(plainArr[i]));
        }
        
       
        
         ArrayList<String> chip=new ArrayList<String>();
        for(int i=0;i<plainchar.size();i++){
            int encForm;
            if(alpha.contains(plainchar.get(i))){
                int index =alpha.indexOf(plainchar.get(i));
                
                 encForm=(index+key)%26;
                if(encForm>alpha.size()){
                       chip.add(alpha.get(encForm-alpha.size()));
                }else{
                     chip.add(alpha.get(encForm));
                }
            }
        }
        
        
        return chip.toString();
    }
//decryption without space
public static String DecCeaserWithoutSpace(String Text,int key){
    int key1;
    String chipText;
   
    
    chipText=Text;
    key1=key;
     chipText=chipText.replaceAll("\\s+", "");
        char [] chipArr=chipText.toCharArray();
        
         ArrayList<String> chipChar=new ArrayList<String>();
        for(int i=0;i<chipArr.length;i++){
           chipChar.add(String.valueOf(chipArr[i]));
        }
    
        ArrayList<String> decrsol=new ArrayList<String>();
         for(int i=0;i<chipChar.size();i++){
              int decForm;
            if(alpha.contains(chipChar.get(i))){
                int index =alpha.indexOf(chipChar.get(i));
                if(index<key){
             
                 decForm=26+((index-key)%26);
                }else{
                    decForm=(index-key)%26;
                }
                    decrsol.add(alpha.get(decForm));
            }
        }
        
    return decrsol.toString();

}
 //encryption with space
public static String EncrCeaserWithSpace(String plain,int key){
    int key1;
    String plainText;
    
    
        
        for(int i=0;i<26;i++){
            alphaSpace.add(String.valueOf(alphSpace[i]));
        }
       
         plainText=plain;      
         key1=key;
      
       

        char [] plainArr=plainText.toCharArray();
        
         ArrayList<String> plainchar=new ArrayList<String>();
        for(int i=0;i<plainArr.length;i++){
           plainchar.add(String.valueOf(plainArr[i]));
        }
        
       
        
         ArrayList<String> chip=new ArrayList<String>();
        for(int i=0;i<plainchar.size();i++){
            int encForm;
            if(alphaSpace.contains(plainchar.get(i))){
                int index =alphaSpace.indexOf(plainchar.get(i));
                
                 encForm=(index+key)%26;
                if(encForm>alphaSpace.size()){
                       chip.add(alphaSpace.get(encForm-alpha.size()));
                }else{
                     chip.add(alphaSpace.get(encForm));
                }
            }
        }
        
        
        return chip.toString();
    }//decryption with Space
public static String DecCeaserWithSpace(String Text,int key){
    int key1;
    String chipText;
   
    
    chipText=Text;
    key1=key;
        char [] chipArr=chipText.toCharArray();
        
         ArrayList<String> chipChar=new ArrayList<String>();
        for(int i=0;i<chipArr.length;i++){
           chipChar.add(String.valueOf(chipArr[i]));
        }
    
        ArrayList<String> decrsol=new ArrayList<String>();
         for(int i=0;i<chipChar.size();i++){
              int decForm;
            if(alphaSpace.contains(chipChar.get(i))){
                int index =alphaSpace.indexOf(chipChar.get(i));
                if(index<key){
             
                 decForm=26+((index-key)%26);
                }else{
                    decForm=(index-key)%26;
                }
                    decrsol.add(alphaSpace.get(decForm));
            }
        }
        
    return decrsol.toString() ;

}

  
    public static void main(String[] args) {
        String sol;
        sol= EncrCeaserWithoutSpace("meetme",3);
        System.out.println("After Encryption"+sol);
        sol= DecCeaserWithoutSpace("phhw",3);
        System.out.println("After Deccryption"+sol);
        sol= EncrCeaserWithSpace("meet_me",3);
        System.out.println("After Encryption"+sol);
        sol= DecCeaserWithSpace("phhwcph",3);
        System.out.println("After Decryption"+sol);
    }
    
}
