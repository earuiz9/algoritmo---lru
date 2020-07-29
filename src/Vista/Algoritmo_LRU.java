/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Metodos.LRU;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Algoritmo_LRU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		int cantidadPaginas,cantidadMarco;
		String []paginas;
		
		cantidadPaginas=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Numero  de Páginas"));
		cantidadMarco=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Numero de Marco"));
		
		paginas= new String [cantidadPaginas];
		
		for(int c=0;c<cantidadPaginas;c++){
			paginas[c]=(JOptionPane.showInputDialog(null,"Ingrese valor de paginas ["+(c+1)+"]"));
		}
		
		LRU lru=new LRU();
		lru.setCantidadPaginas(cantidadPaginas);
		lru.setCantidadMarco(cantidadMarco);
		lru.setPaginas(paginas);
		lru.lru();
	}
    }
    

