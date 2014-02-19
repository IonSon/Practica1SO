/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simularprocesos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon
 */
public class ProductorProcesos extends Thread //implements Runnable
{
    Cola q;
    Proceso procesoProducido;
    static boolean sigueProduciendo;
    ProductorProcesos (Cola q) 
    {
        this.q =  q;
        sigueProduciendo=true;
        new Thread(this, "Productor").start();
        //this.setPriority(MAX_PRIORITY);
        
    }
    
    public void run() 
    {
        int i=0;
        while(i<Cola.TAM_MAX)
        {
            procesoProducido=new Proceso(i);
            q.agregarProceso(procesoProducido);
            i++;
        }
    }
}
