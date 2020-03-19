/**
 * File: Patrones_Lexer
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
        //La palabra cond ejecuta un flujo de control dependiendo de la condición si es cierta o no. Es algo parecido al switch de C y Java  pero con la diferencia que en este caso lo que se pone en los case son condiciones lógicas y no constantes.
        public static final String COND = "cond";
        //Añade al principio de una lista dada un elemento
        //(cons elem lista) 
        public static final String CONS = "cons";
        //Define una función con un nombre el cual será llamado mediante el comando (nombre-funcion args) y que tiene como argumentos una lista de variables.
        //El cuerpo es una lista que define qué hace la función y es ésta la que ejecuta la acción. 
        public static final String DEFUN = "defun";
        //Cierto (T, de true) si la lista está vacía, y nil (sin valor) en caso contrario
        public static final String ENDP = "endp";
        //Se utiliza eq para saber si dos átomos son iguales, independientemente de la referencia.
        //Sintaxis (eq X Y) 
        public static final String EQ = "eq";
        //Es utilizado equal para saber si dos listas son iguales, independientemente de la referencia. 
        public static final String EQUAL = "equal";
        //Construye una lista a partir de sus elementos
        //(list elem1 elem2 elem3 .. elemN) 
        public static final String LIST = "list";
        //La función quote evita la evaluación de su argumento
        public static final String QUOTE= "quote"; 
}