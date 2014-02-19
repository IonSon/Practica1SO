package simularprocesos;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Ion Son
 */
class Cola 
{
    private Vector<Proceso> cola;
    static final int TAM_MAX=100;
    private boolean disponible=false;
    
    public Cola()
    {
        cola=new Vector<>();
    }
    
    public synchronized void agregarProceso(Proceso p)
    {
        while(disponible==true)
        {
            try
            {
                wait();
            }catch(InterruptedException ex)
            {
                JOptionPane.showMessageDialog(null, "Error de ejecución, respuesta del sistema: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(this.tamanio()<Cola.TAM_MAX)
        {
            cola.addElement(p);
        }
        else
            JOptionPane.showMessageDialog(null, "El máximo de memoria principal se ha alcanzado, esperando a que se libere espacio.","Error",JOptionPane.ERROR_MESSAGE);
        disponible=true;
        notify();
    }
    
    /**
     * 
     * @return Devuelve el elemento en la punta de esta cola y lo elimina de ella.
     */
    public synchronized Proceso quitarProceso()
    {
        while(disponible==false)
        {
            try
            {
                wait();
            }catch(InterruptedException ex)
            {
                
            }
        }
        disponible=false;
        notify();        
        if(!cola.isEmpty())
            return cola.remove(0);
        return null;
    }
    
    public int tamanio()
    {
        return cola.size();
    }
    
    
    /**
     * 
     * @return Devuelve el elemento de la punta de la cola sin eliminarlo.
     */
    public Proceso getProceso(int index)
    {
        return cola.get(index);
    }
}
