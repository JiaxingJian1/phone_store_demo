package com.example.demo.service.Impl;
public class CaesarCode {
    private String plainText;

    public void ExhaustiveMethod(String plainText){
        int length = plainText.length();
        for(int i = 0;i<26;i++){
            StringBuffer stringBuffer = new StringBuffer();
            int j ;
            for(j = 0; j<length; j++){
                if( plainText.charAt(j)==' ') {
                    stringBuffer.append(' ');
                }
                else{
                    char c = (char)(plainText.charAt(j)-i);
                    if(c>'z')
                        c-=26;
                    if(c<'a')
                        c+=26;
                    stringBuffer.append(c);
                }
            }
            System.out.println(stringBuffer);
            System.out.println("   Offset:" + i);
        }
    }

    public static void main(String args[]){
        CaesarCode caesarCode = new CaesarCode();
        caesarCode.ExhaustiveMethod("ck rubk dojogt atobkxyoze");
    }
}
