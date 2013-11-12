/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.componentes;

/**
 *
 * @author Andrés Aldana
 */
public class Teclado 
{
    private final int[][] matriz = {{7, 8, 9},
                                    {4, 5, 6},
                                    {1, 2, 3}};
    
    
    public int[] getOptions(int option)
    {
        int[] postion = this.getPosition(option);
        int[] options = new int[4];
        int f = 0;
        
        for(int i=0; i<matriz.length; i++)
        {
            if(postion[0] != i)
            {
                options[f] = this.matriz[postion[1]][i];
                f++;
            }
        }  
        
       for(int i=0; i<matriz.length; i++)
       {
            if(postion[1] != i)
            {
                options[f] = this.matriz[i][postion[0]];
                f++;
            }
        } 
        
        return options;
    }
    
    private int[] getPosition(int option)
    {
         for(int i=0; i<this.matriz.length; i++)
         {
             for(int f=0; f<this.matriz[i].length; f++)
             {
                if(this.matriz[i][f] == option)
                    return new int[] {f, i};
             }
         }
         
        return null;
    }
}
