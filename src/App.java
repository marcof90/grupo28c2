public class App {

    private static int numero1;
    private static int numero2;
    

    public static void main(String[] args) throws Exception {
        numero1 = 20;
        numero2 = 25;
        System.out.println(sumar(numero1, numero2));    
    }

    public static int sumar(int num1, int num2){
        return num1 + num2;
    }
}
