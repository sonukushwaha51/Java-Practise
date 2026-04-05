package inheritance;

public class MethodOverloadingDemo {

    public String returnInteger(String s) {
        return s;
    }

    // This overloading works because we have changed both return type and method parameters
    public int returnInteger(int n) {
        return n;
    }

    // This works because number of parameters are different
    public String returnInteger(String a, String b) {
        return a + b;
    }

    // This won't work because returnInteger with int parameter is already defined
//    public String returnInteger(int a) {
//        return  "a";
//    }

    public static void main(String[] args) {

    }
}
