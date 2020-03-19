 
import java.util.ArrayList;
import java.util.List;


// Clase para evaluaciones
 
public class Evaluacion {


    public List<Object> list(List<Object> vl){
        return vl;
    }
    public boolean mayorque(Object ob1, Object ob2){
        return (Double.parseDouble(ob1.toString()) > Double.parseDouble(ob2.toString()));
    }

    public boolean menorque(Object ob1, Object ob2){
        return (Double.parseDouble(ob1.toString()) < Double.parseDouble(ob2.toString()));
    }

    public boolean igual(Object ob1, Object ob2){
        return ob1.equals(ob2);
    }

   
    public Object cond(List instructions){
        List listTemp = instructions.subList(1, instructions.size());
        List listTemp2 = (List) listTemp.get(0);
        int i = 0;
        for (Object inst: listTemp2) {
            List instr = (List)inst;
            if (instr.contains("equal")){
                if (igual(instr.get(1), instr.get(2))){
                    return instr.get(3);
                }
            } 
            if (instr.contains("<")){
                if (menorque(instr.get(1), instr.get(2))){
                    return instr.get(3);
                }
            } 
            if (instr.contains(">")){
                if (mayorque(instr.get(1), instr.get(2))){
                    return instr.get(3);
                }
            }  
            if (i == listTemp2.size()){
                return listTemp2.get(i);
            }
            i++;
        }
        return null;
    }
    public void PrimeroLista(List instructions) {
    	String m="";
    	m=instructions.get(1).toString();
    	System.out.println(m);
    }
    
    public void quoteShow(List instructions) {
    	String texto="";
    	for(int i=1;i<instructions.size();i++) {
    		
    		texto+=instructions.get(i)+" ";
    		System.out.println(texto);
    	}
    }
    
    public void setqEst(List instructions) {
    	String texto="";
    }
    
    
    
}
