/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectos.umg.tresenlinea;

/**
 *
 * @author VictorM
 */
public class SistemaBusqueda {
  public static int tiradas = 0;
  int valor, X = 1, O = 2;
  
    class NodoSB{
        int mejorMovimiento;
        NodoSB nodos[];
        public int tablero[];
        boolean miTurno = false;
        int indice;
        int ganador = 0;

        NodoSB(){tablero = new int[9];}
    }
    //Raíz del árbol
    NodoSB arbol = new NodoSB();
    
    int[] tablero;
       
    public int movDisponibles( int[] tablero ){
        int mov = 0;
        
        for ( int i = 0; i < 9; i ++ )
            if ( tablero[i] == 0 )
                mov++;
        
        return mov;
    }
    
    public int[] posVacias( int[] tablero ){
        int[] indices = new int[movDisponibles(tablero)];
        int indice = 0;
        
        for ( int i = 0; i < 9; i ++ ){
            if ( tablero[i] == 0 ){
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }
    
    public int movimiento(int[] tablero) {
        this.tablero = tablero;
        tiradas++;
        /*Copiamos el tablero a nuestro nodo raíz.*/
        System.arraycopy(this.tablero, 0, this.arbol.tablero, 0, 9);
        mojorMovimientoArbol(arbol);
        
        arbol.mejorMovimiento = vryPosicion(arbol.mejorMovimiento);
        return arbol.mejorMovimiento;
    }
    
    public int vryPosicion(int i) {
        int valor = 0;
        do {
            if (i == 0) { valor = 1; break;}
            if (i == 1) { valor = 2; break;}
            if (i == 2) { valor = 3; break;}
            if (i == 3) { valor = 4; break;}
            if (i == 4) { valor = 5; break;}
            if (i == 5) { valor = 6; break;}
            if (i == 6) { valor = 7; break;}
            if (i == 7) { valor = 8; break;}
            if (i == 8) { valor = 9; break;}
        
        } while (valor != 0);
        return valor;
    }

    public void mojorMovimientoArbol(NodoSB raiz) {

        int movimientosDispo = movDisponibles(raiz.tablero);
        int indices[] = posVacias(raiz.tablero);
        int Max, Min;

        raiz.nodos = new NodoSB[movimientosDispo];

        int ganador = validajuego(raiz.tablero);//validaJuego--valida si el juego ha terminado
        if (ganador == 1) {
            ganador = -1;
        } else if (ganador == 2) {
            ganador = 1;
        }

        if (ganador != 0 || movimientosDispo == 0) {
            raiz.ganador = ganador;
        } else {

            for (int i = 0; i < movimientosDispo; i++) {

                raiz.nodos[i] = new NodoSB();

                System.arraycopy(raiz.tablero, 0, raiz.nodos[i].tablero, 0, 9);

                //Creamos los diferentes movimientos posibles.
                if (raiz.miTurno) {
                    raiz.nodos[i].tablero[indices[i]] = 1;
                } else {
                    raiz.nodos[i].tablero[indices[i]] = 2;
                }

                //Cambiamos el turno de los hijos
                raiz.nodos[i].miTurno = !raiz.miTurno;

                //Guardamos el indice de su movimiento.
                raiz.nodos[i].indice = indices[i];

                mojorMovimientoArbol(raiz.nodos[i]);

            }

            if (!raiz.miTurno) {
                raiz.ganador = nodoMaximo(raiz);
            } else {
                raiz.ganador = nodoMinimo(raiz);
            }

        } 

    }
   
    public int nodoMaximo( NodoSB raiz ){
        int max = -111;
        for (int i = 0; i < raiz.nodos.length; i++){
            if (raiz.nodos[i].ganador > max){
                max = raiz.nodos[i].ganador;
                raiz.mejorMovimiento = raiz.nodos[i].indice;
                if (max == 1) break;
            }
         }
        
        raiz.nodos = null;        
        return max;
    }
    
    public int nodoMinimo( NodoSB raiz ){
        int Min = 111;
        for (int i = 0; i < raiz.nodos.length; i++)
          if (raiz.nodos[i].ganador < Min ){
            Min = raiz.nodos[i].ganador;
            raiz.mejorMovimiento = raiz.nodos[i].indice;
            if (Min == -1) break;
          }
        
        raiz.nodos = null;
        
        return Min;
    }
                
     public int validajuego(int[] tablero) {
        /*Filas*/
        if (tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[3] == tablero[4] && tablero[3] == tablero[5] && tablero[3] != 0) {
            return tablero[3];
        } else if (tablero[6] == tablero[7] && tablero[6] == tablero[8] && tablero[6] != 0) {
            return tablero[6];
        } /*Columnas*/ else if (tablero[0] == tablero[3] && tablero[0] == tablero[6] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[1] == tablero[4] && tablero[1] == tablero[7] && tablero[1] != 0) {
            return tablero[1];
        } else if (tablero[2] == tablero[5] && tablero[2] == tablero[8] && tablero[2] != 0) {
            return tablero[2];
        } /*Diagonales*/ else if (tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] != 0) {
            return tablero[0];
        } else if (tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0) {
            return tablero[2];
        }

        return 0;
        
    }
    
    public boolean maquinaGana(int[] tablero){
        return validajuego(tablero) == 2;
    }
    
    /*Método que nos dice si pierde la computadora.*/
    public boolean maquinaPierde(int[] tablero){
        return validajuego(tablero) == 1;
    }
    
    public void imprime(int[] temp){
        for ( int i = 0; i < 9; i ++ ){
            System.out.print(temp[i]+"");
            if ( i == 2 || i == 5 )
                System.out.println();
        }
    }
        
    public int quienGana(Totito ta) {
        int i, j;
        int ganador = 0;
        for (i = 0; i < 3; i++) {
            if ((ta.totito[i][0] != 0) && (ta.totito[i][0] == ta.totito[i][1]) && (ta.totito[i][1] == ta.totito[i][2])) {
                ganador = ta.totito[i][1];
            }
        }
        for (j = 0; j < 3; j++) {
            if ((ta.totito[0][j] != 0) && (ta.totito[0][j] == ta.totito[1][j]) && (ta.totito[1][j] == ta.totito[2][j])) {
                ganador = ta.totito[1][j];
            }
        }
        if ((ta.totito[0][0] != 0) && (ta.totito[0][0] == ta.totito[1][1]) && (ta.totito[1][1] == ta.totito[2][2])) {
            ganador = ta.totito[0][0];
        }
        if ((ta.totito[0][2] != 0) && (ta.totito[0][2] == ta.totito[1][1]) && (ta.totito[1][1] == ta.totito[2][0])) {
            ganador = ta.totito[0][2];
        }
        if (X == ganador) {
            return -1;
        }
        if (O == ganador) {
            return 1;
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (ta.totito[i][j] == 0) {
                    return 2;
                }
            }
        }
        return 0;
    }    
      
}