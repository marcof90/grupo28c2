public class App {
   
    private String nombre;
    private int edad;
    private double estatura;
    private float peso;
    private char inicial;
    
    private String direccionVivienda;
    
    public static void main(String[] args) throws Exception {
        //Operadores aritmeticos
        int resultado = 5 + 4;
        double resultado2 = 5 / 4;
        double resultado3 = 12 % 4;
        resultado++;
        resultado = resultado + 1;
        resultado--;
        resultado = -resultado;
        resultado = +resultado;
        //Operadores logicos
        boolean respuesta = 5 > 4;
        respuesta = 25 != 12;
        respuesta = true;
        respuesta = 15 > 12 && 5 < 2;
        respuesta = 15 > 12 || 5 < 2;
        //Operadores Bit a bit
        //&
        //^
        //|
        //---------------------------------
        //estructuras de control
        //condicionales
        if (respuesta) {
            //resultado si se cumple la condición
        }
        if (respuesta) {
            //resultado si se cumple la condición            
        } else {
            //resultado si no se cumple la condición                        
        }
        int valor = 3;
        switch (valor) {
            case 1:
                //bloque de codigo
                break;
            case 2:
                //bloque de codigo
                break;
            case 3:
                //bloque de codigo
                break;        
            default:
                break;
        }
        //ciclos o bucles
        while (valor != 3) {
            //bloque de codigo
        }
        do {
            //bloque de codigo
        } while (valor != 3);
        for (String string : args) {
            //bloque de codigo            
        }
        for (int i = 0; i < args.length; i++) {
            //bloque de codigo
        }
        for(;;){} // for infinito
    }

}
