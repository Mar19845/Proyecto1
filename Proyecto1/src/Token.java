
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Juan Marroquin
 */
public class Token {
    public TokenType type;
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
    
    public enum TokenType {

        NUMBER("-?[0-9]+"), BINARYOP("[=|*|/|+|-]"), WHITESPACE("[\t\f\r\n]"),
        LETTER("[a-zA-Z]"), LPAREN("[(]"), RPAREN("[)]"), IF("[if]"), COMMA("[,]"), LBRACE("[{]"),
        RBRACE("[}]"), SEMICOLON("[;]"), PERIOD("[.]");

        public final String pattern;

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    }
     public  ArrayList<Token> lex(String input) {
//Los tokens a retornar
        ArrayList<Token> tokens = new ArrayList<Token>();
//L�gica lexer
        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values()) {
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        }
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
//Relacionar tokens con su tipo
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            if (matcher.group(TokenType.NUMBER.name()) != null) {
                tokens.add(new Token(TokenType.NUMBER, matcher.group(TokenType.NUMBER.name())));
                continue;
            } else if (matcher.group(TokenType.BINARYOP.name()) != null) {
                tokens.add(new Token(TokenType.BINARYOP, matcher.group(TokenType.BINARYOP.name())));
                continue;
            } else if (matcher.group(TokenType.WHITESPACE.name()) != null) {
                //Se ignoran los whitespace y tabs
                continue;
            } else if (matcher.group(TokenType.LETTER.name()) != null) {
                tokens.add(new Token(TokenType.LETTER, matcher.group(TokenType.LETTER.name())));
                continue;
            } else if (matcher.group(TokenType.LPAREN.name()) != null) {
                tokens.add(new Token(TokenType.LPAREN, matcher.group(TokenType.LPAREN.name())));
                continue;
            } else if (matcher.group(TokenType.RPAREN.name()) != null) {
                tokens.add(new Token(TokenType.RPAREN, matcher.group(TokenType.RPAREN.name())));
                continue;
            } else if (matcher.group(TokenType.IF.name()) != null) {
                tokens.add(new Token(TokenType.IF, matcher.group(TokenType.IF.name())));
                continue;
            } else if (matcher.group(TokenType.COMMA.name()) != null) {
                tokens.add(new Token(TokenType.COMMA, matcher.group(TokenType.COMMA.name())));
                continue;
            } else if (matcher.group(TokenType.LBRACE.name()) != null) {
                tokens.add(new Token(TokenType.LBRACE, matcher.group(TokenType.LBRACE.name())));
                continue;
            } else if (matcher.group(TokenType.RBRACE.name()) != null) {
                tokens.add(new Token(TokenType.RBRACE, matcher.group(TokenType.RBRACE.name())));
                continue;
            } else if (matcher.group(TokenType.SEMICOLON.name()) != null) {
                tokens.add(new Token(TokenType.SEMICOLON, matcher.group(TokenType.SEMICOLON.name())));
                continue;
            } else if (matcher.group(TokenType.PERIOD.name()) != null) {
                tokens.add(new Token(TokenType.PERIOD, matcher.group(TokenType.PERIOD.name())));
                continue;
            }
        }
        return tokens;
    }
     
}