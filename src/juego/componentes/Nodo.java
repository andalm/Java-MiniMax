/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.componentes;

/**
 *
 * @author Andrés Aldana
 */
public class Nodo 
{
    private int dato = 0;
    private int acumulado = 0;
    private Nodo opt1 = null;
    private Nodo opt2 = null;
    private Nodo opt3 = null;
    private Nodo opt4 = null;
    
    public Nodo(){};
    
    public Nodo(int dato)
    {
        this.dato = dato;
    }
    
    public Nodo(int dato, int acumulado)
    {
        this.dato = dato;
        this.acumulado = acumulado;
    }
    
    public int getDato()
    {
        return this.dato;
    }
    
    public void setDato(int dato)
    {
        this.dato = dato;
    }
    
    public int getAcumulado()
    {
        return this.acumulado;
    }
    
    public void setAcumulado(int acumulado)
    {
        this.acumulado = acumulado;
    }
    
    public Nodo getOpt1()
    {
        return this.opt1;
    }
    
    public Nodo getOpt2()
    {
        return this.opt2;
    }
    
    public Nodo getOpt3()
    {
        return this.opt3;
    }
    
    public Nodo getOpt4()
    {
        return this.opt4;
    }
	
    public void setOpt1(Nodo nodo)
    {
        this.opt1 = nodo;
    }
    
    public void setOpt2(Nodo nodo)
    {
        this.opt2 = nodo;
    }
    
    public void setOpt3(Nodo nodo)
    {
        this.opt3 = nodo;
    }
    
    public void setOpt4(Nodo nodo)
    {
        this.opt4 = nodo;
    }	
}
