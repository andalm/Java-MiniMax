/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.componentes;

/**
 *
 * @author Andrés Aldana
 */
public class Arbol {
    
    protected Nodo raiz = null;
    protected static int limit = 32; 
    
    public Arbol()
    {
        raiz = new Nodo();          
    }
    
    public Arbol(int dato, int acumulado)
    {
        this.raiz = new Nodo(dato);
        this.raiz.setAcumulado(acumulado);
    }
    
    public Nodo getRaiz()
    {
        return this.raiz;
    }
    
    public void setRaiz(int dato)
    {
        this.raiz = new Nodo(dato);
    }
    
    public Nodo buscar(int dato)
    {
        return Arbol.buscarPrivate(this.raiz, dato);
    }
    
    protected static Nodo buscarPrivate(Nodo raiz, int dato)
    {
        if(raiz == null)
            return null;
        else if(raiz.getDato() == dato)
           return raiz;
        else if(raiz.getOpt1() != null)
            return Arbol.buscarPrivate(raiz.getOpt1(), dato);            
        else if(raiz.getOpt2() != null)
            return Arbol.buscarPrivate(raiz.getOpt2(), dato);
        else if(raiz.getOpt3() != null)
            return Arbol.buscarPrivate(raiz.getOpt3(), dato);
        else if(raiz.getOpt4() != null)
            return Arbol.buscarPrivate(raiz.getOpt4(), dato);
       
        return null;
    }
    
    public void insertar(int dato)
    {
        Arbol.insertarPrivate(this.raiz, dato);
    }
    
    protected static void insertarPrivate(Nodo raiz, int dato)
    {
        if((raiz.getAcumulado()+dato) < Arbol.limit) 
        { 
            if(raiz.getOpt1() == null)
            {
               raiz.setOpt1(new Nodo(dato));
               raiz.getOpt1().setAcumulado(dato + raiz.getAcumulado());
            }
            else if(raiz.getOpt2() == null)
            {
                raiz.setOpt2(new Nodo(dato));
                raiz.getOpt2().setAcumulado(dato + raiz.getAcumulado());
            }
            else if(raiz.getOpt3() == null)
            {
                raiz.setOpt3(new Nodo(dato));
                raiz.getOpt3().setAcumulado(dato + raiz.getAcumulado());
            }
            else if(raiz.getOpt4() == null)
            {
                raiz.setOpt4(new Nodo(dato));
                raiz.getOpt4().setAcumulado(dato + raiz.getAcumulado());
            }
            else if(raiz.getOpt1() != null)
                Arbol.insertarPrivate(raiz.getOpt1(), dato);
            else if(raiz.getOpt2() != null)
                Arbol.insertarPrivate(raiz.getOpt2(), dato);
            else if(raiz.getOpt3() != null)
                Arbol.insertarPrivate(raiz.getOpt3(), dato);
            else if(raiz.getOpt4() != null)
                Arbol.insertarPrivate(raiz.getOpt4(), dato);
        }
    }
    
    public String preorden()
    {
        return Arbol.preordenPrivate(this.raiz);
    }
    
    protected static String preordenPrivate(Nodo raiz)
    {
       if(raiz != null)
           return raiz.getDato() + " " +
                  Arbol.preordenPrivate(raiz.getOpt1()) + " " + 
                  Arbol.preordenPrivate(raiz.getOpt2()) + " " + 
                  Arbol.preordenPrivate(raiz.getOpt3()) + " " + 
                  Arbol.preordenPrivate(raiz.getOpt4());
      
       return "\b";
    }
    
    public String getHojas()
    {
        return Arbol.hojasPrivate(this.raiz);
    }
    
    protected static String hojasPrivate(Nodo raiz)
    {
        if(raiz != null)
        {
            if(raiz.getOpt1() == null && raiz.getOpt2() == null && 
               raiz.getOpt3() == null && raiz.getOpt4() == null)
                return raiz.getDato() + " ";
            else 
                return Arbol.hojasPrivate(raiz.getOpt1()) + " " + 
                       Arbol.hojasPrivate(raiz.getOpt2()) + " " +
                       Arbol.hojasPrivate(raiz.getOpt3()) + " " +
                       Arbol.hojasPrivate(raiz.getOpt4());            
        }
        
        return "\b";
    }
    
    public int contar()
    {
        return Arbol.contarPrivate(this.raiz);
    }
    
    protected static int contarPrivate(Nodo raiz)
    {
       if(raiz != null)
           return 1 + Arbol.contarPrivate(raiz.getOpt1()) + 
                  Arbol.contarPrivate(raiz.getOpt2()) +
                  Arbol.contarPrivate(raiz.getOpt3()) +
                  Arbol.contarPrivate(raiz.getOpt4());
       
       return 0;
    }
    
    public void podar(int dato)
    {
        Arbol.podarPrivate(this.raiz, dato);
    }
    
    protected static void podarPrivate(Nodo raiz, int dato)
    {
        if(raiz.getOpt1() != null)
        {
           if(raiz.getOpt1().getDato() == dato)
               raiz.setOpt1(null);
        }
        else if(raiz.getOpt2() != null)
        {
           if(raiz.getOpt2().getDato() == dato)
               raiz.setOpt2(null);           
        }
        else if(raiz.getOpt3() != null)
        {
           if(raiz.getOpt3().getDato() == dato)
               raiz.setOpt3(null);           
        }
        else if(raiz.getOpt4() != null)
        {
           if(raiz.getOpt4().getDato() == dato)
               raiz.setOpt4(null);           
        }
    }
    
    public static int getLimit()
    {
        return Arbol.limit;         
    }
    
    public static void setLimit(int limit)
    {
        Arbol.limit = limit;
    }    
}
