
import java.util.ArrayList;

/**
 *
 * @author Juan Marroquin
 * @param <E>
 */
public class Stack<E>{

    /**
     *
     */
    protected ArrayList<E> expresion = new ArrayList<E>();
	
    /**
     *
     * @param dato
     */
    public void push(E dato){
		
		expresion.add(dato);
	}

    /**
     *
     * @return
     */
    public E pop(){

		if (size() > 0) {
			return expresion.remove(size()-1);
		} else {
			return null;
		}
	}

    /**
     *
     * @return
     */
    public E peek(){

		if (size() > 0) {
			return expresion.get(size()-1);
		} else {
			return null;
		}
	}

    /**
     *
     * @return
     */
    public int size(){

		return expresion.size();
	}

    /**
     *
     * @return
     */
    public boolean empty(){

		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}