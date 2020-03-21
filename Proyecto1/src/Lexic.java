
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Juan Marroquin
 */
public class Lexic {

    Scanner teclado = new Scanner(System.in);
    StringTokenizer token;
    Stack<String> pila = new Stack<>();
    ;
    ArrayList<String> salida;
    int x;
    String a, b, valor, usuario;

    /**
     *
     */
    public Lexic() {
    }

    /**
     * Separa lo leido del lisp y lo agruega a un Array list
     *
     * @param input
     * @return
     */
    public ArrayList<String> Tokens(String input) {

        salida = new ArrayList<>();
        token = new StringTokenizer(input, "[,() ]");
        while (token.hasMoreTokens()) {
            salida.add(token.nextToken());
        }
        return salida;
    }

    /**
     *
     * @param lista
     * @return
     */
    public String Ejecutar(ArrayList<String> lista) {
        String respuesta = "";
        for (int k = 0; k < lista.size(); k++) {
            switch (lista.get(k)) {
                case "TEMP":
                    System.out.println("Ingrese en grados farenheit lo que desea convertir: ");
                    usuario = teclado.nextLine();
                    teclado.nextLine();
                    lista.set(k, usuario);
                default:
                    break;
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            switch (lista.get(i)) {
                case "+":
                    a = pila.pop();
                    b = pila.pop();
                    valor = String.valueOf(Double.valueOf(b) + Double.valueOf(a));
                    pila.push(valor);
                    break;
                case "-":
                    a = pila.pop();
                    b = pila.pop();
                    valor = String.valueOf(Double.valueOf(b) - Double.valueOf(a));
                    pila.push(valor);
                    break;
                case "*":
                    a = pila.pop();
                    b = pila.pop();
                    valor = String.valueOf(Double.valueOf(b) * Double.valueOf(a));
                    pila.push(valor);
                    break;
                case "/":
                    a = pila.pop();
                    b = pila.pop();
                    valor = String.valueOf(Double.valueOf(b) / Double.valueOf(a));
                    pila.push(valor);
                    break;

                default:
                    for (int z = 3; z < lista.size(); z++) {
                        pila.push(lista.get(z));
                    }
                    break;
            }
            respuesta = "la respuesta es " + valor;
        }

        return respuesta;
    }
}
