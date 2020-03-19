/**
 * 
 * @author Juan Marroquin
 * @author Carlos Raxtum
 * @author Mario de Leon
 */
public class Calculadora {
	/**
	 * @param operando1		Segundo numero a sumar/restar/dividir/multiplicar
	 * @param operando2     Primer numero a sumar/restar/dividir/multiplicar
	*/
	
	public int sumar(int operando2, int operando1){
		return operando2+operando1;
	}

	public int restar(int operando2, int operando1){
		return operando2-operando1;
	}

	public int dividir(int operando2, int operando1){
		if (operando1==0) {
			return -1; //Error
		} else {
			return operando2/operando1;
		}
	}

	public int multiplicar(int operando2, int operando1){
		return operando2*operando1;
	}
}