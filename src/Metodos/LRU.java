/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author Dell
 */
public class LRU {

    private int quantityPages;
    private int quantityMarco;
    String[] pages;
    String[][] matriz;
    int[] fails;
    int[] distance;

    public LRU() {
        System.out.println("LRU");
    }

    public void setPaginas(String[] paginas) {
        this.pages = paginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.quantityPages = quantityPages;
    }

    public void setCantidadMarco(int cantidadMarco) {
        this.quantityMarco = cantidadMarco;
    }

    public void iniciarxfallos() {
        for (int i = 0; i < quantityPages; i++) {
            fails[i] = 0;
        }
    }

    private void iniciarMatriz() {
        for (int i = 0; i < quantityMarco; i++) {
            for (int j = 0; j < quantityPages; j++) {
                matriz[i][j] = "-";
            }
        }
    }

    private boolean buscar(int paginaActual) {
        boolean encontrado = false;
        for (int i = 0; i < quantityMarco; i++) {
            if (pages[paginaActual].equals(matriz[i][paginaActual])) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    private void llenarFila(int paginaActual, int frame) {
        for (int j = paginaActual; j < quantityPages; j++) {
            matriz[frame][j] = pages[paginaActual];
        }
    }

    //este método me devolverá el frame que fue el mas antiguo en ser liberado

    private int MayorDistancia(int paginaActual) {
        int mayorDist = 0;
        for (int i = 0; i < quantityMarco; i++) {
            for (int j = paginaActual; j >= 0; j--) {
                if (matriz[i][paginaActual].equals(pages[j])) {
                    distance[i] = paginaActual - j;
                    break;
                }
            }
        }

        for (int i = 0; i < quantityMarco; i++) {
            if (distance[i] > distance[mayorDist]) {
                mayorDist = i;
            }
        }
        return mayorDist;
    }

    private void modificar(int paginaActual) {
        boolean encontradoFrameLibre = false;
        int i;
        for (i = 0; i < quantityMarco; i++) {
            if (matriz[i][paginaActual].equals("-")) {
                encontradoFrameLibre = true;
                break;
            }
        }

        if (!encontradoFrameLibre) {
            llenarFila(paginaActual, MayorDistancia(paginaActual));
        } else {
            llenarFila(paginaActual, (i));
        }

        fails[paginaActual] = 1;

    }

    public int contFallos() {
        int cont = 0;
        for (int i = 0; i < fails.length; i++) {
            if (fails[i] == 1) {
                cont++;
            }
        }
        return cont;
    }

    public String[][] RetornarMatriz() {
        return this.matriz;
    }

    public int[] RetornarVector() {
        return this.fails;
    }

    public void lru() {
        matriz = new String[quantityMarco][quantityPages];
        fails = new int[quantityPages];
        distance = new int[quantityMarco];
        iniciarxfallos();
        iniciarMatriz();
        //Recorremos todas las paginas
        for (int j = 0; j < quantityPages; j++) {
            if (!buscar(j)) {
                modificar(j);
            }
        }
        mostrarMatriz();
    }

    public void mostrarMatriz() {
        int quantityFallos = 0;
        for (int i = 0; i < quantityMarco; i++) {
            for (int j = 0; j < quantityPages; j++) {
                if (matriz[i][j].equals("-")) {
                    System.out.print(" ");//para que no se muestre el -1 en la matriz
                } else {
                    System.out.print("" + matriz[i][j]);
                }
            }
            System.out.println();
        }

        for (int i = 0; i < quantityPages; i++) {
            if (fails[i] == 1) {
                quantityFallos++;
            }
            System.out.print("" + fails[i]);
        }
        System.out.println("\n\nFallos encontrados: " + quantityFallos);
    }
}
