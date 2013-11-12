/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import juego.componentes.MiniMax;
import juego.componentes.Tablero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Andrés Aldana
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
        Tablero t = new Tablero ();
        t.setVisible(true);
        Scanner sc = new Scanner(System.in);
        MiniMax logica = new MiniMax(); 
        logica.runMapaEstados();
                       
        do
        {
            int op = sc.nextInt();                   
            logica.juagadaMin(op);
        }
        while(logica.getEstado() == 0);
                
        System.out.println("Fin: " + logica.getEstado());
    }  
}
