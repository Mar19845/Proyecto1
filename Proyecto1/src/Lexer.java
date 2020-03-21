/**
 * 
 * @author Juan Marroquin
 * @author Carlos Raxtum
 * @author Mario de Leon
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;

/**
 * @author Usuario Dell Funcion Lexer trabajar con un String Se deben definir
 * los tipos de tokens a esperar Number `-?[0-9]+` De menos infinino a mas
 * infinito. Binary Operator `[*|/|+|-]` Todas las operaciones aritmÃ¯Â¿Â½ticas
 * bÃ¯Â¿Â½sicas. Whitespace `[ \t\f\r\n]+` Espcios en blanco, tabs. SerÃ¯Â¿Â½n
 * ignorados.
 */
public class Lexer {

    /**
     *
     */
    public static enum TokenType {

        /**
         *
         */
        NUMBER("-?[0-9]+"),

        /**
         *
         */
        OPERACIONES("[=|*|/|+|-]"),

        /**
         *
         */
        WHITESPACE("[       ]"),

        /**
         *
         */
        LITERAL("[a-zA-Z0-9]+"),

        /**
         *
         */
        LETTER("[a-zA-Z]"),

        /**
         *
         */
        PARENTESISIZQ("[(]"),

        /**
         *
         */
        IF("[if]"),

        /**
         *
         */
        PARENTESISDER("[)]"),

        /**
         *
         */
        COMMA("[,]"),

        /**
         *
         */
        BRACE("[{}]"),

        /**
         *
         */
        COMENTARIO("[;]"),

        /**
         *
         */
        PERIOD("[.]"),

        /**
         *
         */
        DEFUN("[defunDEFUN]"),

        /**
         *
         */
        CAR("[car]"),

        /**
         *
         */
        CDR("[cdr]"),

        /**
         *
         */
        COND("[condCOND]"),

        /**
         *
         */
        CONS("cons"),

        /**
         *
         */
        ENDP("[endp]"),

        /**
         *
         */
        EQ("eq"),

        /**
         *
         */
        EQUAL("[equal]"),

        /**
         *
         */
        LIST("[list]"),

        /**
         *
         */
        QUOTE("[quote]");

        /**
         *
         */
        public final String pattern;

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    }

    /**
     *
     */
    public static class Token {

        /**
         *
         */
        public TokenType type;

        /**
         *
         */
        public String data;

        /**
         *
         * @param type
         * @param data
         */
        public Token(TokenType type, String data) {
            this.type = type;
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("(%s %s)", type.name(), data);
        }
    }


    /**
     *
     * @param input
     * @return
    /**
     * Determina que caracter es para momstrarlo
     *

     */
    public static ArrayList<Token> lex(String input) {
        //Los tokens a retornar
        ArrayList<Token> tokens = new ArrayList<>();
        Map<String,Token> toki;


        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

        //Relacionar tokens con su tipo
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            //if (matcher.group(TokenType.NUMBER.name()) != null) {
              // tokens.add(new Token(TokenType.NUMBER, matcher.group(TokenType.NUMBER.name())));
            }  if (matcher.group(TokenType.OPERACIONES.name()) != null) {
                tokens.add(new Token(TokenType.OPERACIONES, matcher.group(TokenType.OPERACIONES.name())));
            } else if (matcher.group(TokenType.WHITESPACE.name()) != null) {
                //Se ignoran los whitespace y tabs
            } else if (matcher.group(TokenType.LITERAL.name()) != null) {
                tokens.add(new Token(TokenType.LITERAL, matcher.group(TokenType.LITERAL.name())));
            }else if (matcher.group(TokenType.PARENTESISIZQ.name()) != null) {
                tokens.add(new Token(TokenType.PARENTESISIZQ, matcher.group(TokenType.PARENTESISIZQ.name())));
            }else if (matcher.group(TokenType.PARENTESISDER.name()) != null) {
                tokens.add(new Token(TokenType.PARENTESISDER, matcher.group(TokenType.PARENTESISDER.name())));
            }
            else if (matcher.group(TokenType.IF.name()) != null) {
                tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name())));
            } else if (matcher.group(TokenType.COMMA.name()) != null) {
                tokens.add(new Token(TokenType.COMMA, matcher.group(TokenType.COMMA.name())));
            } else if (matcher.group(TokenType.BRACE.name()) != null) {
                tokens.add(new Token(TokenType.BRACE, matcher.group(TokenType.BRACE.name())));
            } else if (matcher.group(TokenType.COMENTARIO.name()) != null) {
                tokens.add(new Token(TokenType.COMENTARIO, matcher.group(TokenType.COMENTARIO.name())));
            } else if (matcher.group(TokenType.PERIOD.name()) != null) {
                tokens.add(new Token(TokenType.PERIOD, matcher.group(TokenType.PERIOD.name())));
            } else if (matcher.group(TokenType.DEFUN.name()) != null) {
                tokens.add(new Token(TokenType.DEFUN, matcher.group(TokenType.DEFUN.name())));
            } else if (matcher.group(TokenType.CAR.name()) != null) {
                tokens.add(new Token(TokenType.CAR, matcher.group(TokenType.CAR.name())));
            } else if (matcher.group(TokenType.CDR.name()) != null) {
                tokens.add(new Token(TokenType.CDR, matcher.group(TokenType.CDR.name())));
            } else if (matcher.group(TokenType.COND.name()) != null) {
                tokens.add(new Token(TokenType.COND, matcher.group(TokenType.COND.name())));
            } else if (matcher.group(TokenType.CONS.name()) != null) {
                tokens.add(new Token(TokenType.CONS, matcher.group(TokenType.CONS.name())));
            } else if (matcher.group(TokenType.ENDP.name()) != null) {
                tokens.add(new Token(TokenType.ENDP, matcher.group(TokenType.ENDP.name())));
            } else if (matcher.group(TokenType.EQ.name()) != null) {
                tokens.add(new Token(TokenType.EQ, matcher.group(TokenType.EQ.name())));
            } else if (matcher.group(TokenType.EQUAL.name()) != null) {
                tokens.add(new Token(TokenType.EQUAL, matcher.group(TokenType.EQUAL.name())));
            } else if (matcher.group(TokenType.LIST.name()) != null) {
                tokens.add(new Token(TokenType.LIST, matcher.group(TokenType.LIST.name())));
            } else if (matcher.group(TokenType.QUOTE.name()) != null) {
                tokens.add(new Token(TokenType.QUOTE, matcher.group(TokenType.QUOTE.name())));
            }

        return tokens;
    }


    /**
     *
     * @param Tokio
=======
    /**
     * Ejecuta los tokens para realzar operacion
     *
>>>>>>> e05d5d9b1e0d48f8a8cfab1824c7e9eb5e03ff66
     */
    public static void Ejecutar(ArrayList<Token> Tokio)  {
        Stack<String> lista = new Stack<String>();
        String funcion= "";
        Map<String,String> carta = new LinkedHashMap<String,String>();
        String CadTex;
        for(int i=0; i < Tokio.size(); i++){
            lista.push(Tokio.get(i).data);
            carta.put(Tokio.get(i).type.name(), Tokio.get(i).data);  
        }
        carta.get("COMENTARIO");
        // definir funcion
        if(carta.containsKey("PARENTESISIZQ")&& carta.containsKey("PARENTESISDER")){
            for(int a=0;a<carta.size();a++){
                System.out.println(funcion + carta.values().toString());
            }
        }
    }
}
