import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @author Usuario Dell
 * Funcion Lexer trabajar con un String
 * Se deben definir los tipos de tokens a esperar
 * Number
	`-?[0-9]+` De menos infinino a mas infinito.
	Binary Operator
	`[*|/|+|-]` Todas las operaciones aritm�ticas b�sicas.
	Whitespace
	`[ \t\f\r\n]+` Espcios en blanco, tabs. Ser�n ignorados.
 */
public class Lexer {
	public static enum TokenType{
		NUMBER("-?[0-9]+"), OPERACIONES("[=|*|/|+|-]"), WHITESPACE("[\t\f\r\n]"),
		LETTER("[a-zA-Z]"), PARENTESIS("[()]"), IF("[if]"), COMMA("[,]"), BRACE("[{}]"),
		COMENTARIO("[;]"), PERIOD("[.]"), DEFUN("[defunDEFUN]"), CAR("[car]"), CDR("[cdr]"),
                COND("[condCOND]"), CONS("cons"), ENDP("[endp]"), EQ("eq"), EQUAL("[equal]"), LIST("[list]"), QUOTE("[quote]");
                
		
				
		public final String pattern;
		
		private TokenType(String pattern) {
			this.pattern = pattern;
		}
	}
	public static String Variables(String input){
            StringTokenizer tokenizador = new StringTokenizer (input, "  ");
             ArrayList<String> Prueba = new ArrayList<>();
            String variable = "";
            while(tokenizador.hasMoreTokens()){
                variable = variable + tokenizador.nextToken();
            }
            
            return variable;
        }
	public static class Token{
		public TokenType type;
		public String data;
		
		public Token(TokenType type, String data) {
			this.type = type;
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.format("(%s %s)", type.name(), data);
		}
	}
	
	public static ArrayList<Token> lex(String input){
		//Los tokens a retornar
		ArrayList<Token> tokens = new ArrayList<>();
		
		//L�gica lexer
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for(TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
                
		//Relacionar tokens con su tipo
		Matcher matcher = tokenPatterns.matcher(input);
		while(matcher.find()) {
			if(matcher.group(TokenType.NUMBER.name()) != null) {
				tokens.add(new Token(TokenType.NUMBER, matcher.group(TokenType.NUMBER.name())));
			}else if(matcher.group(TokenType.OPERACIONES.name())!=null) {
				tokens.add(new Token(TokenType.OPERACIONES, matcher.group(TokenType.OPERACIONES.name())));
			}else if(matcher.group(TokenType.WHITESPACE.name())!=null) {
                            //Se ignoran los whitespace y tabs

			}
                        else if(matcher.group(TokenType.LETTER.name())!=null) {
				tokens.add(new Token(TokenType.LETTER, matcher.group(TokenType.LETTER.name())));
			}
			else if(matcher.group(TokenType.PARENTESIS.name())!=null) {
				tokens.add(new Token(TokenType.PARENTESIS, matcher.group(TokenType.PARENTESIS.name())));
			}else if(matcher.group(TokenType.IF.name())!=null) {
				tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name())));
			}else if(matcher.group(TokenType.COMMA.name())!=null) {
				tokens.add(new Token(TokenType.COMMA, matcher.group(TokenType.COMMA.name())));
			}else if(matcher.group(TokenType.BRACE.name())!=null) {
				tokens.add(new Token(TokenType.BRACE, matcher.group(TokenType.BRACE.name())));
			}else if(matcher.group(TokenType.COMENTARIO.name())!=null) {
				tokens.add(new Token(TokenType.COMENTARIO, matcher.group(TokenType.COMENTARIO.name())));
			}else if(matcher.group(TokenType.PERIOD.name())!=null) {
				tokens.add(new Token(TokenType.PERIOD, matcher.group(TokenType.PERIOD.name())));
			}
			else if(matcher.group(TokenType.DEFUN.name())!=null) {
				tokens.add(new Token(TokenType.DEFUN, matcher.group(TokenType.DEFUN.name())));
			}
                        else if(matcher.group(TokenType.CAR.name())!=null) {
				tokens.add(new Token(TokenType.CAR, matcher.group(TokenType.CAR.name())));
			}
                        else if(matcher.group(TokenType.CDR.name())!=null) {
				tokens.add(new Token(TokenType.CDR, matcher.group(TokenType.CDR.name())));
			}
                        else if(matcher.group(TokenType.COND.name())!=null) {
				tokens.add(new Token(TokenType.COND, matcher.group(TokenType.COND.name())));
			}
                        else if(matcher.group(TokenType.CONS.name())!=null) {
				tokens.add(new Token(TokenType.CONS, matcher.group(TokenType.CONS.name())));
			}
                        else if(matcher.group(TokenType.ENDP.name())!=null) {
				tokens.add(new Token(TokenType.ENDP, matcher.group(TokenType.ENDP.name())));
			}
                        else if(matcher.group(TokenType.EQ.name())!=null) {
				tokens.add(new Token(TokenType.EQ, matcher.group(TokenType.EQ.name())));
			}
                        else if(matcher.group(TokenType.EQUAL.name())!=null) {
				tokens.add(new Token(TokenType.EQUAL, matcher.group(TokenType.EQUAL.name())));
			}
                        else if(matcher.group(TokenType.LIST.name())!=null) {
				tokens.add(new Token(TokenType.LIST, matcher.group(TokenType.LIST.name())));
			}
                        else if(matcher.group(TokenType.QUOTE.name())!=null) {
				tokens.add(new Token(TokenType.QUOTE, matcher.group(TokenType.QUOTE.name())));
			}
			
		}
		
		
		return tokens;
	}
	
	/**
	public static void main(String[] args) {
		String input = "11 + 22 - 33 * AAA = () . {} defun";
		
		//Crear e imprimir tokens
		ArrayList<Token> tokens = lex(input);
		for(Token token:tokens) {
			System.out.println(token);
		}
	}
        */
}