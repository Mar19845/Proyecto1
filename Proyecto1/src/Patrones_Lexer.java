/**
 * File: Patrones_Lexer
 * 
 * @author Juan Marroquin
 * @author Carlos Raxtum
 * @author Mario de Leon
 *
 * Separa expresiones que representan strings en un programa Lisp
 */

class Patrones_Lexer{
	public static final String LETTER = "[a-zA-Z]";
	public static final String LITERAL = "[a-zA-Z0-9]+";
	public static final String WHIESPACE = "[\\s]+";
	public static final String NUMERIC_ATOM = "[\\d\\+\\-]?[\\d]*";
	public static final String SYMBOL = "[().]";
       //Devuelve el primer elemento de una lista (car lista) 
        public static final String CAR = "car";
        //Devuelve la lista sin su primer elemento 
        public static final String CDR = "cdr";
        //La palabra cond ejecuta un flujo de control dependiendo de la condiciÃ³n si es cierta o no. Es algo parecido al switch de C y Java  pero con la diferencia que en este caso lo que se pone en los case son condiciones lÃ³gicas y no constantes.
        public static final String COND = "cond";
        //AÃ±ade al principio de una lista dada un elemento
        //(cons elem lista) 
        public static final String CONS = "cons";
        //Define una funciÃ³n con un nombre el cual serÃ¡ llamado mediante el comando (nombre-funcion args) y que tiene como argumentos una lista de variables.
        //El cuerpo es una lista que define quÃ© hace la funciÃ³n y es Ã©sta la que ejecuta la acciÃ³n. 
        public static final String DEFUN = "defun";
        //Cierto (T, de true) si la lista estÃ¡ vacÃ­a, y nil (sin valor) en caso contrario
        public static final String ENDP = "endp";
        //Se utiliza eq para saber si dos Ã¡tomos son iguales, independientemente de la referencia.
        //Sintaxis (eq X Y) 
        public static final String EQ = "eq";
        //Es utilizado equal para saber si dos listas son iguales, independientemente de la referencia. 
        public static final String EQUAL = "equal";
        //Construye una lista a partir de sus elementos
        //(list elem1 elem2 elem3 .. elemN) 
        public static final String LIST = "list";
        //La funciÃ³n quote evita la evaluaciÃ³n de su argumento
        public static final String QUOTE= "quote"; 
}
