/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simularprocesos;

/**
 *
 * @author Jhon
 */
public class ConsumidorProcesos extends Thread
{
    Cola q;
    Proceso procesoConsumido;
    static boolean sigueCcnsumiendo;
    public ConsumidorProcesos(Cola q) 
    {
        this.q = q;
        sigueCcnsumiendo=true;
        //this.setPriority(MIN_PRIORITY);
        
    }
    	public void run() 
        {
            Proceso temp;
            while(sigueCcnsumiendo)
            {
                temp=q.quitarProceso();
                if(temp!=null)
                {
                    procesoConsumido=temp;
                }
                
            }
        }
}
