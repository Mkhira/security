package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    @FXML
    JFXTextField  plane_text1,encrypt_key,Sypher_text,decrypt_key,plane_text2,decimal,decimal_back,xa,xb,mo,al,out;
    @FXML
    AnchorPane afinean,deanc,defan;


    static char [] alph={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
            ,'v','w','x','y','z'};
    static ArrayList<String> alpha=new ArrayList<String>();
    static char [] alphSpace={'_','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u'
            ,'v','w','x','y','z'};
    static ArrayList<String> alphaSpace=new ArrayList<String>();


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


        return chip.toString().replaceAll("[, [ ] ]" ,"");
    }
    public static String DecCeaserWithoutSpace(String Text,int key){
        int key1;
        String chipText;


        chipText=Text;
        key1=key;
        for(int i=0;i<26;i++){
            alpha.add(String.valueOf(alph[i]));
        }
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

        return decrsol.toString().replaceAll("[, [ ]]" ,"");

    }
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


        return chip.toString().replaceAll("[, [ ]]" ,"");
    }//decryption with Space

    public static String DecCeaserWithSpace(String Text,int key){
        int key1;
        String chipText;


        chipText=Text;
        key1=key;
        for(int i=0;i<26;i++){
            alphaSpace.add(String.valueOf(alphSpace[i]));
        }
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

        return decrsol.toString().replaceAll("[, [ ]]" ,"");

    }


    public void Encode_cesar_no_spac(ActionEvent actionEvent) {

        String sypher ;
        sypher= EncrCeaserWithoutSpace(plane_text1.getText(), Integer.parseInt(encrypt_key.getText()));

        Sypher_text.setText(sypher);

    }
    public void Decode_cesar_no_spac(ActionEvent actionEvent) {

        String text = DecCeaserWithoutSpace(Sypher_text.getText(), Integer.parseInt(decrypt_key.getText()));
        plane_text2.setText(text);

    }


    public void Encode_cesar_spac(ActionEvent actionEvent) {

        String sypher ;
        sypher= EncrCeaserWithSpace(plane_text1.getText(), Integer.parseInt(encrypt_key.getText()));

        Sypher_text.setText(sypher);
    }

    public void Decode_cesar_spac(ActionEvent actionEvent) {
        String text = DecCeaserWithSpace(Sypher_text.getText(), Integer.parseInt(decrypt_key.getText()));
        plane_text2.setText(text);
    }


    public static  String SpaceFree (String PT){
        String SFPT = "" ;
        for(int i =0 ; i < PT.length() ; i++ ){
            if(PT.charAt(i) != ' '){
                SFPT += PT.charAt(i);
            }
        }
        return SFPT;
    }

    public static   String GetSirial(String k ){
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

    public static   String Encrypt_Transpostion(String Key , String PT){

        int r,c,need;
        String CT ="";
        String SKey = GetSirial(Key);
        c = Key.length();
        PT =SpaceFree(PT);


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

    public static  String Decrypt_Transpostion(String Key , String CT){

        String SKey= GetSirial(Key);
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
        System.out.println(CT);
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
            System.out.println(PT);
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
        System.out.println("ct"+CT);
        System.out.println("pt"+PT);
        System.out.println("ptl"+plt);


        return PT;

    }


    public void EN_Transpostion(ActionEvent actionEvent) {

        String sypher ;

        sypher= Encrypt_Transpostion(encrypt_key.getText(),plane_text1.getText());

        Sypher_text.setText(sypher);
    }

    public void DE_Transpostion(ActionEvent actionEvent) {

        String text= Decrypt_Transpostion(decrypt_key.getText() ,Sypher_text.getText());
        plane_text2.setText(text);
    }




    private static int getShift(String key, int i) {

        if(key.charAt(i % key.length()) < 65 || key.charAt(i % key.length()) > 90){

            System.out.println(
                    "Key phrase must contain only capital letters");

        }

        return ((int)key.charAt(i % key.length())) - 65;

    }


    public static String EN_Viginre(String s, String key){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i ++){

            if(s.charAt(i) < 65 || s.charAt(i) > 90){ //ASCII character (capital letter)

                throw new IllegalArgumentException("" +

                        "Open text must contain only capital letters");

            }


            char encyphered = s.charAt(i) + getShift(key, i) > 90 ? (char)((s.charAt(i) + getShift(key, i)) - 26) : (char)(s.charAt(i) + getShift(key, i));

            builder.append(encyphered);

        }

        return builder.toString();

    }

    public static String DE_Viginre(String s, String key){

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i ++){

            if(s.charAt(i) < 65 || s.charAt(i) > 90){ //ASCII character (capital letter)

                throw new IllegalArgumentException("" +

                        "Ciphertext must contain only capital letters");

            }



            char decyphered = s.charAt(i) - getShift(key, i) < 65 ? (char)((s.charAt(i) - getShift(key, i)) + 26) : (char)(s.charAt(i) - getShift(key, i));

            builder.append(decyphered);

        }

        return builder.toString();

    }


    public void EN_Viginre(ActionEvent actionEvent) {
        String sypher ;

        sypher= EN_Viginre( plane_text1.getText().toUpperCase(),encrypt_key.getText().toUpperCase());

        Sypher_text.setText(sypher.toUpperCase());
    }

    public void DE_Viginre(ActionEvent actionEvent) {
        String text= DE_Viginre(Sypher_text.getText().toUpperCase(),decrypt_key.getText().toUpperCase() );
        plane_text2.setText(text.toUpperCase());

    }

    // Play fair



    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String SpaceFree2 (String plaintext){
        String SFPT = "" ;
        for(int i =0 ; i < plaintext.length() ; i++ ){
            if(plaintext.charAt(i) != ' '){
                SFPT += plaintext.charAt(i);
            }
        }
        return SFPT;
    }

    public static String initializedMatrixBased(String keybased){
        String key=SpaceFree2(keybased);
        StringBuilder key1 =new StringBuilder(key);
        key1.append(alphabet);
        return key1.toString();
    }

    public static String removeDeplicate(String alphabetBased){
        return Arrays.asList(alphabetBased.split("")).stream().distinct().collect(Collectors.joining());
    }

    public static String replaceMentchar(String finalalphabetBased){
        finalalphabetBased = finalalphabetBased.replaceAll("j", "i");
        return finalalphabetBased;
    }

    public static char[][] alphabetInitialized(String Key){
        String matrixlinereplace , matrixlineremoved;

        String matrixline = initializedMatrixBased(Key);
        matrixlinereplace = replaceMentchar(matrixline);
        matrixlineremoved = removeDeplicate(matrixlinereplace);
        int count =0 ;
        char [][] alphabetMatrix = new char[5][5];
        for(int i = 0 ; i < 5 ; i++){
            for (int j = 0; j < 5; j++) {
                alphabetMatrix[i][j] = matrixlineremoved.charAt(count);
                count++ ;
            }
        }
        return alphabetMatrix ;
    }

    public static void printalphabetMatrix(char[][] alphabetMatrix){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("\t" +alphabetMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static String keyformation(String key){
        String alphabetbased = initializedMatrixBased(key);
        String finalalphabetbased = removeDeplicate(alphabetbased);

        return removeDeplicate(replaceMentchar(finalalphabetbased));
    }

    public static String plaintextformation(String plaintext){
        StringBuilder plaintext2 = new StringBuilder(SpaceFree2(plaintext));

        String p4="";
        for(int i =0 ; i <= plaintext2.length()-1 ; i+=2){
            char temp =plaintext2.charAt(i);
            if(temp == plaintext2.charAt(i+1)){
                plaintext2.insert(i+1, 'x');

            }
            String p3= Character.toString(temp)+Character.toString(plaintext2.charAt(i+1));
            p4+=p3;

        }
        //if(plaintext2.length() % 2 != 0){
        // plaintext2.append('x');
        //}
        return p4;
    }

    public static int[] indexofchar (char letter , char[][] alphabetbased){
        int rowindex = 0 ;
        int columnindex = 0 ;
        int [] charindex = new int [2];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(alphabetbased[i][j] == letter){
                    rowindex = i ;
                    columnindex = j ;
                }
            }
        }
        charindex[0]=rowindex;
        charindex[1]=columnindex;
        return charindex ;
    }

    public static String encryptedalgorithm(String plaintext , String key){
        String plain =plaintextformation(plaintext);
        char [][] matrix;
        matrix =alphabetInitialized(key);
        printalphabetMatrix(matrix);
        System.out.println("______________________________________________");

        String encrypted = "";
        char firstchar ;
        char secondchar ;
        int [] indexoffirstchar = new int[2];
        int [] indexofsecondchar = new int[2];
        for(int i =0 ; i < plain.length()-1 ; i+=2){
            firstchar = plain.charAt(i);
            indexoffirstchar = indexofchar(firstchar, matrix);
            secondchar = plain.charAt(i+1);
            indexofsecondchar = indexofchar(secondchar, matrix);
            if(indexoffirstchar[0] == indexofsecondchar[0]){
                if(indexoffirstchar[1] < 4){
                    indexoffirstchar[1]++;
                }else{
                    indexoffirstchar[1] = 0;
                }

                if(indexofsecondchar[1] < 4){
                    indexofsecondchar[1]++;
                }else{
                    indexofsecondchar[1] = 0;
                }
            }else if(indexoffirstchar[1] == indexofsecondchar[1]){
                if(indexoffirstchar[0] < 4){
                    indexoffirstchar[0]++;
                }else{
                    indexoffirstchar[0] = 0;
                }

                if(indexofsecondchar[0] < 4){
                    indexofsecondchar[0]++;
                }else{
                    indexofsecondchar[0] = 0;
                }
            }else{
                int temp = indexoffirstchar[1];
                indexoffirstchar[1] = indexofsecondchar[1];
                indexofsecondchar[1] = temp ;
            }
            encrypted = encrypted + matrix[indexoffirstchar[0]][indexoffirstchar[1]]
                    +matrix[indexofsecondchar[0]][indexofsecondchar[1]];
        }
        return encrypted ;
    }

    public static String decryptalgorithm(String cybertext , String key){
        String plaintext = "";
        char [][] alphaMatrix;
        alphaMatrix =alphabetInitialized(key);
        char firstchar ;
        char secondchar ;
        int [] indexoffirstchar = new int [2];
        int [] indexofsecondchar = new int [2];
        for (int i = 0; i < cybertext.length()-1; i+=2) {
            firstchar = cybertext.charAt(i);
            indexoffirstchar = indexofchar(firstchar, alphaMatrix);
            secondchar = cybertext.charAt(i+1);
            indexofsecondchar = indexofchar(secondchar, alphaMatrix);
            if (indexoffirstchar[0] == indexofsecondchar[0]){
                if(indexoffirstchar[1] > 0){
                    indexoffirstchar[1]--;
                }else{
                    indexoffirstchar[1] = 4;
                }

                if(indexofsecondchar[1] > 0){
                    indexofsecondchar[1]--;
                }else{
                    indexofsecondchar[1] = 4;
                }
            }else if(indexoffirstchar[1] == indexofsecondchar[1]){
                if(indexoffirstchar[0] > 0){
                    indexoffirstchar[0]--;
                }else{
                    indexoffirstchar[0] = 4;
                }

                if(indexofsecondchar[0] > 0){
                    indexofsecondchar[0]--;
                }else{
                    indexofsecondchar[0] = 4;
                }
            }else{
                int temp = indexoffirstchar[1];
                indexoffirstchar[1] = indexofsecondchar[1];
                indexofsecondchar[1] = temp ;
            }
            plaintext = plaintext + alphaMatrix[indexoffirstchar[0]][indexoffirstchar[1]]
                    +alphaMatrix[indexofsecondchar[0]][indexofsecondchar[1]];
        }
        return plaintext;
    }


    public void PlayFair_EN(ActionEvent actionEvent) {
        String sypher ;

        sypher= encryptedalgorithm( plane_text1.getText().replaceAll(" ",""),encrypt_key.getText());

        Sypher_text.setText(sypher);

    }

    public void PlayFair_DE(ActionEvent actionEvent) {
        String text= decryptalgorithm(Sypher_text.getText().toUpperCase().replaceAll(" ",""),decrypt_key.getText().toUpperCase().replaceAll(" ","") );

        plane_text2.setText( text.toUpperCase());
    }



    public static String encryptAffine(String input,int key,int decimal) {
        String str = "";
        for (int in = 0; in < input.length(); in++) {
            char get = input.charAt(in);
            if (Character.isLetter(get)) {
                get = (char) ((decimal * (int)(get + 'A') + key) % 26 + 'A');
            }
            str +=get;
        }
        return str;
    }
    public static String decryptAffine(String input,int key,int decimal) {
        String str = "";
        int x = 0;
        int inverse = 0;
// لو شيلت ال while و خليت x = decimal كدا هاخد من اليوزر المعكوس
        while(true){
            inverse = decimal * x % 26;
            if(inverse == 1)
                break;
            x++;
        }

        for (int in = 0; in < input.length(); in++) {
            char get = input.charAt(in);
            if (Character.isLetter(get)) {
                get = (char)(x * ((get + 'A') - key) % 26 + 'A');
            }
            str +=get;
        }
        return str;
    }

    public void EN_Affine(ActionEvent actionEvent) {
        String sypher ,sypher1 ,sypher2 ,sypher3 ;

        sypher= encryptAffine( plane_text1.getText().toUpperCase(),Integer.parseInt(encrypt_key.getText()),Integer.parseInt(decimal.getText()));



        Sypher_text.setText(sypher.toUpperCase());

    }

    public void DE_Affine(ActionEvent actionEvent) {
        String text= decryptAffine(Sypher_text.getText().toUpperCase() ,Integer.parseInt(encrypt_key.getText()), Integer.parseInt(decimal_back.getText()));
        plane_text2.setText(text.toUpperCase());

    }

    public void Affine_show(ActionEvent actionEvent) {
        decimal.setVisible(true);
        decimal_back.setVisible(true);
        afinean.setVisible(true);
    }

    static char[] alphah = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
    static ArrayList<String> alphaaa = new ArrayList<String>();

    //encryption without space
//decryption without space


    //encryption without space
    public static String EncryptionPoly(String plain, String key) {
        ArrayList<String> key1 = new ArrayList<String>();
        String plainText;

        for (int i = 0; i < 26; i++) {
            alpha.add(String.valueOf(alph[i]));
        }
        for (int i = 0; i < key.length(); i++) {
            key1.add(String.valueOf(key.charAt(i)));
        }
        System.out.println(key1);

        plainText = plain;

        //removing space
        plainText = plainText.replaceAll("\\s+", "");
        char[] plainArr = plainText.toCharArray();

        ArrayList<String> plainchar = new ArrayList<String>();
        for (int i = 0; i < plainArr.length; i++) {
            plainchar.add(String.valueOf(plainArr[i]));
        }

        ArrayList<String> chip = new ArrayList<String>();
        int j = 0;
        for (int i = 0; i < plainchar.size(); i++) {
            int encForm;
            String ch;

            if (j == key1.size()) {
                j = 0;
            }
            ch = key1.get(j);
            j++;
            String p = plainchar.get(i);
            int plainindex = alpha.indexOf(p);
            int keyindex = alpha.indexOf(ch);
            encForm = (plainindex + keyindex) % 26;

            chip.add(alpha.get(encForm));

        }

        return chip.toString().replaceAll("[, [ ]]", " ");
    }
//decryption without space

    public static String Decryptionpoly(String Text, String key) {
        ArrayList<String> key1 = new ArrayList<String>();
        String chipText;

        chipText = Text;

        char[] chipArr = chipText.toCharArray();
        for (int i = 0; i < 26; i++) {
            alpha.add(String.valueOf(alph[i]));
        }

        ArrayList<String> ciphChar = new ArrayList<String>();
        for (int i = 0; i < chipArr.length; i++) {
            ciphChar.add(String.valueOf(chipArr[i]));
        }
        for (int i = 0; i < key.length(); i++) {
            key1.add(String.valueOf(key.charAt(i)));
        }
        System.out.println(ciphChar);
        ArrayList<String> decrsol = new ArrayList<String>();
        int j = 0;
        for (int i = 0; i < ciphChar.size(); i++) {
            int decForm;
            String keych;
            if (j == key1.size()) {
                j = 0;
            }
            keych = key1.get(j);
            j++;
            String ci = ciphChar.get(i);
            int ciphindex = alpha.indexOf(ci);
            int keyindex = alpha.indexOf(keych);
            decForm = (ciphindex - keyindex) % 26;
            while (decForm < 0) {
                decForm += 26;
            }

            decrsol.add(alpha.get(decForm));

        }

        return decrsol.toString().replaceAll("[, [ ]]", " ");

    }


    public void Ploly_EN(ActionEvent actionEvent) {
        String sypher ;

        sypher= EncryptionPoly( plane_text1.getText().replaceAll(" ",""),encrypt_key.getText());

        Sypher_text.setText(sypher.replaceAll(" ",""));
    }

    public void Poly_DE(ActionEvent actionEvent) {
        String text= Decryptionpoly(Sypher_text.getText().replaceAll("\\[","").replaceAll("\\]",""),decrypt_key.getText());

        plane_text2.setText( text);

    }







    String SpaceFreetime(String PT) {
        String SFPT = "";
        for (int i = 0; i < PT.length(); i++) {
            if (PT.charAt(i) != ' ') {
                SFPT += PT.charAt(i);
            }
        }
        return SFPT;
    }

    public static String chiperEncryptiontime(String PT,String Key ) {
        String encrypthexa = "";
        int keyitr = 0;
        for (int i = 0; i < PT.length(); i++) {
            int temp = PT.charAt(i) ^ Key.charAt(keyitr);


            encrypthexa += String.format("%02x", (byte) temp);

            keyitr++;
            if (keyitr >= Key.length()) {
                keyitr = 0;
            }
        }
        System.out.println(encrypthexa);
        String hexatodecimal = "";
        for (int i = 0; i < encrypthexa.length() - 1; i += 2) {
            String plain = encrypthexa.substring(i, (i + 2));
            int decimal = Integer.parseInt(plain, 16);
            hexatodecimal += (char) decimal;

        }
        return hexatodecimal;
    }

    public static String chiperDecryptiontime(String CT,String Key ) {



        String decrpt = "";
        int keyitr = 0;
        for (int i = 0; i < CT.length(); i++) {
            //xor operation
            int temp = CT.charAt(i) ^ Key.charAt(keyitr);
            System.out.println(temp);
            decrpt += (char) temp;
            keyitr++;
            if (keyitr >= Key.length()) {
                keyitr = 0;
            }
        }
        return decrpt;
    }

    public void time_EN(ActionEvent actionEvent) {

        String sypher ;

        sypher= chiperEncryptiontime( plane_text1.getText().toUpperCase(),encrypt_key.getText());

        Sypher_text.setText(sypher);

    }

    public void time_DE(ActionEvent actionEvent) {
        String text= chiperDecryptiontime(Sypher_text.getText(),decrypt_key.getText());

        plane_text2.setText( text);

    }


    //hill


    static char[] alphnew = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
    static ArrayList<String> alphax = new ArrayList<String>();

    public static String hillEncryption(String plain, String ke) {

        int[][] PT = new int[2][1];
        int[][] key = new int[2][2];

        String ciph = "";

        char[] textChar = plain.toCharArray();
        ArrayList<String> plaintext = new ArrayList<String>();
        //alphabetic array
        for (int i = 0; i < 26; i++) {
            alphax.add(String.valueOf(alphnew[i]));
        }
        //plainText array
        for (int i = 0; i < textChar.length; i++) {
            plaintext.add(String.valueOf(textChar[i]));
        }
        System.out.println(plaintext);
        //key array
        int k = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                key[i][j] = Integer.parseInt(String.valueOf(ke.charAt(k)));
                k++;

            }
        }

        //check first Determam of key
        int sol = 0;
        int gcd = 0;
        sol = Math.abs((key[0][0] * key[1][1]) - (key[0][1] * key[1][0]));

        for (int i = 1; i <= 26 && i <= sol; i++) {
            if (26 % i == 0 && sol % i == 0) {
                gcd = i;
            }
        }
        // System.out.println(gcd);

        int firstCharindex = 0;
        int secondCharindex = 0;
        int[][] res = new int[2][1];
        //encryption algorithm
        if (gcd == 1) {
            int x = 1;
            for (int t = 0; t < plaintext.size(); t += 2) {
                firstCharindex = alphax.indexOf(plaintext.get(t));
                //System.out.println(firstCharindex);
                secondCharindex = alphax.indexOf(plaintext.get(x));
                x += 2;
                //System.out.println(secondCharindex);
                PT[0][0] = firstCharindex;
                PT[1][0] = secondCharindex;
                for (int i = 0; i < key.length; i++) {
                    for (int j = 0; j < key[i].length; j += 2) {
                        res[i][0] = (key[i][j] * PT[0][0]) + (key[i][++j] * PT[1][0]);

                    }

                }

                int in = 0;
                for (int r = 0; r < res.length; r++) {
                    in = (res[r][0] % 26);
                    ciph += alphax.get(in);

                }

            }
        } else {
            ciph = "No encryption";
        }

        return ciph;
    }

    public static String hillDecryption(String cipher, String ke) {

        for (int i = 0; i < 26; i++) {
            alphax.add(String.valueOf(alphnew[i]));
        }
        int[][] CI = new int[2][1];
        int[][] key = new int[2][2];

        String plain = "";
        char[] textChar = cipher.toCharArray();
        ArrayList<String> ciphertext = new ArrayList<String>();
        //cipherText array
        for (int i = 0; i < textChar.length; i++) {
            ciphertext.add(String.valueOf(textChar[i]));
        }
        System.out.println(ciphertext);
        //key array
        int k = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                key[i][j] = Integer.parseInt(String.valueOf(ke.charAt(k)));
                k++;

            }
        }
        //Det inverse
        int sol = 0;
        sol = Math.abs((key[0][0] * key[1][1]) - (key[0][1] * key[1][0]));
        int inver;
        for (inver = 1; inver < 26; inver++) {
            if ((sol * inver) % 26 == 1) {
                break;
            }
        }

        //matrix inverse
        int temp = key[0][0];
        key[0][0] = key[1][1];
        key[1][1] = temp;
        key[0][1] *= -1;
        key[1][0] *= -1;


        int firstCharindex = 0;
        int secondCharindex = 0;
        int[][] res = new int[2][1];
        int x = 1;
        for (int t = 0; t < ciphertext.size(); t += 2) {
            firstCharindex = alphax.indexOf(ciphertext.get(t));
            //System.out.println(firstCharindex);
            secondCharindex = alphax.indexOf(ciphertext.get(x));
            x += 2;
            //System.out.println(secondCharindex);
            CI[0][0] = firstCharindex;
            CI[1][0] = secondCharindex;

            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < key[i].length; j += 2) {
                    res[i][0] = inver * ((key[i][j] * CI[0][0]) + (key[i][++j] * CI[1][0]));
                }

            }

            int in = 0;
            for (int r = 0; r < res.length; r++) {
                in = (res[r][0] % 26)+26;
                plain += alphax.get(in);

            }

        }

        return plain;
    }


    public void hill_EN(ActionEvent actionEvent) {
        String sypher ;
        sypher= hillEncryption( plane_text1.getText(),encrypt_key.getText());

        Sypher_text.setText(sypher);
    }

    public void hill_DE(ActionEvent actionEvent) {
        String text= hillDecryption(Sypher_text.getText(),decrypt_key.getText());

        plane_text2.setText( text);
    }


    //    def
    public static String fun(int Xa, int Xb, int modnum, int alpha) {
        BigInteger modnum1 = BigInteger.valueOf(modnum);
        BigInteger alpha1 = BigInteger.valueOf(alpha);

        BigInteger ya = (alpha1.pow(Xa)).mod(modnum1);
        System.out.println(ya);
        BigInteger yb = (alpha1.pow(Xb)).mod(modnum1);
        System.out.println(yb);
        BigInteger keyA = (yb.pow(Xa)).mod(modnum1);
        System.out.println(keyA);
        BigInteger keyB = (ya.pow(Xb)).mod(modnum1);
        System.out.println(keyB);
        String res = "";

        if (keyA.compareTo(keyB) == 0) {
            res = "Keys are symmatric";
            System.out.println(res);
        } else {
            res = "Keys are not symmatric";
            System.out.println(res);
        }

        return res;
    }

    public void def_show(ActionEvent actionEvent) {
        deanc.setVisible(true);
        defan.setVisible(true);
    }

    public void fefhelm(ActionEvent actionEvent) {

        int a = Integer.parseInt(xa.getText());
        int b = Integer.parseInt(xb.getText());
        int c = Integer.parseInt(mo.getText());
        int d = Integer.parseInt(al.getText());

        String x  = fun(a,b,c,d);

        out.setText(x);

    }
}
