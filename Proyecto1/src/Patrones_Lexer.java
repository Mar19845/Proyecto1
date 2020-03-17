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
}