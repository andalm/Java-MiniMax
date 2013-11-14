/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego.componentes;

import java.util.Random;

/**
 *
 * @author Andrés Aldana
 */
public class MiniMax extends Arbol{
    
    protected int acumuladoMaximo = 15;
    protected int estado = 0;
    
    public MiniMax()
    {
        super();
        Random rnd = new Random();
        int op = rnd.nextInt(9-7+1) + 7;
        super.raiz.setDato(op);
        super.raiz.setAcumulado(op);        
    }  
    
    public MiniMax(int inicio)
    {
        super(inicio, inicio);
    }
    
    public void juagadaMin(int dato)
    {
        Nodo busqueda = this.reducirArbol(dato);
        
        if(busqueda != null)
        {
            if(busqueda.getAcumulado() <= MiniMax.getLimit() - 1)
            {
                if(busqueda.getAcumulado() < this.acumuladoMaximo)
                {
                    do
                    {
                        Random rnd = new Random();
                        int op = rnd.nextInt(4-1+1) + 1;

                        switch(op)
                        {
                            case 1: super.raiz = busqueda.getOpt1();
                                break;
                            case 2: super.raiz = busqueda.getOpt2();
                                break;
                            case 3: super.raiz = busqueda.getOpt3();
                                break;
                            case 4: super.raiz = busqueda.getOpt4();
                                break;
                        }
                    }
                    while(super.raiz == null);
                }
                else
                {
                    super.raiz = this.mejorOpcion(busqueda);

                    if(super.raiz == null)
                        this.estado = 2;            
                }
            }
            else
                this.estado = 1;
        }
        else
            this.estado = 1;
    }
    
    public void runMapaEstados()
    {
        MiniMax.protectedRunArbolEstados(super.raiz, new Teclado());
    }
    
    protected static void protectedRunArbolEstados(Nodo raiz, Teclado teclado)
    {
        if(raiz != null)
        {
            int[] options = teclado.getOptions(raiz.getDato());
            
            for(int i=0; i<options.length; i++)
                     MiniMax.insertarPrivate(raiz, options[i]);
            
            MiniMax.protectedRunArbolEstados(raiz.getOpt1(), teclado);
            MiniMax.protectedRunArbolEstados(raiz.getOpt2(), teclado);
            MiniMax.protectedRunArbolEstados(raiz.getOpt3(), teclado);
            MiniMax.protectedRunArbolEstados(raiz.getOpt4(), teclado);
        }
    }
    
    protected Nodo reducirArbol(int dato)
    {
        if(super.raiz.getOpt1() != null)
        {
            if(super.raiz.getOpt1().getDato() == dato)
                return super.raiz.getOpt1();
        }
        
        if(super.raiz.getOpt2() != null)
        {
            if(super.raiz.getOpt2().getDato() == dato)
                return super.raiz.getOpt2();
        }
        
        if(super.raiz.getOpt3() != null)
        {
           if(super.raiz.getOpt3().getDato() == dato)
                return super.raiz.getOpt3();
        }
        
        if(super.raiz.getOpt4() != null)
        {
            if(super.raiz.getOpt4().getDato() == dato)
                return super.raiz.getOpt4();
        }
        
        return null;
    }
    
    public int getEstado()
    {
        return this.estado;
    }
    
    protected Nodo mejorOpcion(Nodo opcion)
    {
        Nodo mejorOpcion = null;
        
        if(opcion.getOpt1() != null)
        {
            if(opcion.getOpt1().getAcumulado() <= MiniMax.getLimit() - 1 )
            {
                mejorOpcion = opcion.getOpt1();
            }
        }
        
        if(opcion.getOpt2() != null)
        {
            if(opcion.getOpt2().getDato() < mejorOpcion.getDato() && opcion.getOpt2().getAcumulado() <= MiniMax.getLimit() - 1 )
            {
                mejorOpcion = opcion.getOpt2();
            }
        }
        
        if(opcion.getOpt3() != null)
        {
            if(opcion.getOpt3().getDato() < mejorOpcion.getDato() && opcion.getOpt3().getAcumulado() <= MiniMax.getLimit() - 1 )
            {
                mejorOpcion = opcion.getOpt3();
            }
        }
        
        if(opcion.getOpt4() != null)
        {
            if(opcion.getOpt4().getDato() < mejorOpcion.getDato() && opcion.getOpt3().getAcumulado() <= MiniMax.getLimit() - 1 )
            {
                mejorOpcion = opcion.getOpt4();
            }
        }
        
        return mejorOpcion;
    }
}
