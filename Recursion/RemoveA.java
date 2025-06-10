package Recursion;

public class RemoveA {
    // without return type
    public static void removeA(String str, String s){
        if(s.isEmpty()){
            System.out.println(str);
            return;
        }

        char c= s.charAt(0);
        if(c=='a'){
            removeA(str, s.substring(1));
        }else{
            removeA(str+c, s.substring(1));
        }
    }

    //with return type
    public static String skip(String s){
        if(s.isEmpty()){
            return "";
        }

        char c= s.charAt(0);
        if(c=='a'){
            return skip(s.substring(1));
        }
        else{
            return c+skip(s.substring(1));
        }
    }

    public static String skipStr(String s, String str){
        if(s.isEmpty()){
            return "";
        }

        char c= s.charAt(0);
        if(s.startsWith(str)){
            return skipStr(s.substring(str.length()), str);
        }
        else{
            return c+skipStr(s.substring(1), str);
        }
    }

    public static void main(String args[]){
        String s= "baccdah";
        removeA("", s);

        System.out.println(skip(s));

        System.out.println(skipStr("bacapplecdah","apple"));
    }
}
