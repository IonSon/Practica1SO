package simularprocesos;

/**
 *
 * @author Ion Son
 */
public class Proceso //implements Comparable
{
    String idProceso, tareaProceso;
    int timeProceso;
    double resultado;
    
    public Proceso(int id)
    {
        idProceso=String.valueOf(id+1);
        timeProceso=Aleatorio(5, 20);
        generarOperacionAleatoria(Aleatorio(0, 10), Aleatorio(0, 10), Aleatorio(1, 4));
    }
    
    
    
    /*@Override
    public int compareTo(Object obj)
    {
        Proceso temp=(Proceso) obj;
        if(Integer.parseInt(this.idProceso)<Integer.parseInt(temp.idProceso))
            return 1;
        else
            if(Integer.parseInt(this.idProceso)>Integer.parseInt(temp.idProceso))
                return -1;
        return 0;
    }*/
    
    /**
     * Obtiene el resultado y la cadena de la operacion 
     * 
     * @param a Primer número de la operacion
     * @param b Segundo número de la operacion.
     * @param c El tipo de operando: 1-Suma 2-Resta 3-Multiplicación 4-Division.
     */
    private void generarOperacionAleatoria(int a, int b, int c)
    {
        //En caso de que sea una division y el divisor sea 0, se le asigna un nuevo valor al divisor sin considerar el cero.
        if (b == 0 && c == 4) { 
            b = Aleatorio(1, 10); 
        } 
        switch (c) 
        {
            case 1: 
                tareaProceso = a + " + " + b; 
                resultado = a + b; 
                break; 
            case 2: 
                tareaProceso = a + " - " + b; 
                resultado = a - b; 
                break; 
            case 3: 
                tareaProceso = a + " x " + b; 
                resultado = a * b; 
                break; 
            case 4: 
                tareaProceso = a + " / " + b; 
                resultado = ((double) (a) / (double) b); 
                break; 
        } 
    } 
    
    private int Aleatorio(int ini, int fin) { //devuelve un numero entero aleatorio entre ini y fin (incluyendolos) 
        fin++; 
        return (int) Math.floor(Math.random() * (ini - fin) + fin); 
    }
    
    public String getIDProceso()
    {
        return idProceso;
    }
    
    public String getTareaProceso()
    {
        return tareaProceso;
    }
    
    public int getTimeProceso()
    {
        return timeProceso;
    }
    
    public double getResultado()
    {
        return resultado;
    }
}
