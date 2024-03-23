package proyecto_1_prograiii;

import java.util.*;

public class Proyecto_1_PrograIII {
 //mapa para el almacenamiento de las variables
         private static Map<Character, Float> variables = new HashMap<>(); //hacinedolo privado y estatico no pierdo 
         //los valores ya asignados 
         
    public static void main(String[] args) {
        Scanner texto = new Scanner(System.in);
        //pido la expresion matematica a operar
        System.out.println("Ingrese la expresion matematica a operar");
        String expresion = texto.nextLine();
       
        
        
        //Extraigo las variables de la expresion 
        for (int i = 0; i < expresion.length(); i++) {
            char variable = expresion.charAt(i);
            if (Character.isLetter(variable)) {
                //Validacion para evitar reasignar un valor a una variable existente 
                if (!variables.containsKey(variable)) {
                    System.out.println("Ingrese el valor de la variable  " + variable);
                    float valorVariable = texto.nextFloat();
                    variables.put(variable, valorVariable);
                }

            }

        }
        //mando a llamar mi metodo 
         String polaco = ConviertePolaco(expresion);
          //Imprimo la notacion polaca para comprobar 
        System.out.println("Notacion polaca  = "+polaco);
        //creo mi arbol binario en el metodo main y le agrego el valor en polaco
        ArbolExpresiones ArbExpresion = new ArbolExpresiones();
        ArbExpresion.insertarN(polaco);
        //imprimo el recorrido Inorden
        System.out.println("Recorrido Inorden IRD");
        ArbExpresion.inorden(ArbExpresion.raiz);
      
    }

    //Se convertira a Polaco utilizando el algoritmo de Shunting Yard
    public static String ConviertePolaco(String expresion) {
        StringBuilder polaco = new StringBuilder();
        Stack<Character> operadores = new Stack<>();
        //ordeno la cadena en un arreglo de caracteres
        for (char caracter : expresion.toCharArray()) {
            if (Character.isDigit(caracter)) { //Si es un digito se va a la pila 
                polaco.append(caracter);
            } else {
                if (Character.isLetter(caracter)) {//si tengo una letra obtengo el valor del mapa, se agrega en la salida
                    float valorVariable = obtenerV(caracter);
                    polaco.append(valorVariable);

                } else {
                    if (EOperador(caracter))  { //si es operador lo agrego en orden jerarquico
                        while(!operadores.isEmpty() && Jerarquia(operadores.peek())>= Jerarquia(caracter)){
                            polaco.append(operadores.pop());
                        }
                    operadores.push(caracter); //se agrega el caracter a la pila
                    }
                }
                 
            }
           
            }
        //agrego los valores restatnes a la salida
            while(!operadores.isEmpty()){
                polaco.append(operadores.pop());
        }
        return polaco.toString();
    }

    public static float obtenerV(char variable) {
        if (variables.containsKey(variable)) {
            return (float) variables.get(variable);
        } else {
            throw new IllegalArgumentException("La variable" + variable + "no tiene un valor");
        }

    }

    //Metodo parea verificar operadores
    public static boolean EOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^';
    }

    //Metodo para establecer la jerarquia de operacion
    public static int Jerarquia(char operador) {
        
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
            return 0;
        }

    }
}

