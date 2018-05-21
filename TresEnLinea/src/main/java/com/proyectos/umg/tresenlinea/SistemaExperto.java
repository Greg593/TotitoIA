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
public class SistemaExperto {

    int valor, X = 1, O = 2;

    public int Busqueda(int espaciosDisponibles, Totito ta) {
        valor = 0;
        switch (espaciosDisponibles) {
            case 9:
                busca9posiciones(ta);
                break;
            case 8:
                busca8posiciones(ta);
                break;
            case 7:
                busca7posiciones(ta);
                break;
            case 6:
                busca6posiciones(ta);
                break;
            case 5:
                busca5posiciones(ta);
                break;
            case 4:
                busca4posiciones(ta);
                break;
            case 3:
                busca3posiciones(ta);
                break;
            case 2:
                busca2posiciones(ta);
                break;
            case 1:
                busca1posiciones(ta);
                break;
        }
        if (valor == 0){
            busca1posiciones(ta);
        }
        return valor;
    }

    //Si es segundo turno
    public void busca8posiciones(Totito ta) {
        int posX = 0, posO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {
                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                    }
                }
            }
        }
        if (posX != 5) { valor = 5; } else { valor = 1; }
    }

    public void busca6posiciones(Totito ta) {
        int posX = 0, posO = 0, posX2 = 0, posO2 = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {
                   
                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO2 == 0) {
                        posO2 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX2 == 0) {
                        posX2 = vryPosicion(i, j);
                        continue;
                    }              
                }
            }
        }
        do {
            // Defendiendo
            //1ra. Forma
            if (((posX == 1 && posX2 == 9) || (posX == 3 && posX2 == 7)) && posO == 5) { valor = 2; }
            //2da. Forma
            if ((posX == 1 && posX2 == 6) && posO == 5) { valor = 9; break;}
            if ((posX == 3 && posX2 == 4) && posO == 5) { valor = 7; break;}
            if ((posX == 6 && posX2 == 7) && posO == 5) { valor = 3; break;}
            if ((posX == 4 && posX2 == 9) && posO == 5) { valor = 1; break;}
            //3ra. Forma
            if ((posX == 2 && posX2 == 4) && posO == 5) { valor = 1; break;}
            if ((posX == 4 && posX2 == 8) && posO == 5) { valor = 7; break;}
            if ((posX == 6 && posX2 == 8) && posO == 5) { valor = 9; break;}
            if ((posX == 2 && posX2 == 6) && posO == 5) { valor = 3; break;}
            //4ta. Forma
            if ((posX == 3 && posX2 == 5) && posO == 1) { valor = 7; break;}
            if ((posX == 5 && posX2 == 7) && posO == 1) { valor = 3; break;}
            if ((posX == 5 && posX2 == 9) && posO == 1) { valor = 3; break;}
            //5ta. Forma
            if ((posX == 2 && posX2 == 5) && posO == 1) { valor = 8; break;}
            if ((posX == 4 && posX2 == 5) && posO == 1) { valor = 6; break;}
            if ((posX == 5 && posX2 == 6) && posO == 1) { valor = 4; break;}
            if ((posX == 5 && posX2 == 8) && posO == 1) { valor = 2; break;}
        
        } while (valor != 0);
    }

    public void busca4posiciones(Totito ta) {
        int posX = 0, posO = 0, posX2 = 0, posO2 = 0, posX3 = 0, posO3 = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {
                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO2 == 0) {
                        posO2 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX2 == 0) {
                        posX2 = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO3 == 0) {
                        posO3 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX3 == 0) {
                        posX3 = vryPosicion(i, j);
                        continue;
                    }                    
                }
            }
        }
        do{            
            //1ra. Forma
            if ((posX == 1 && posX2 == 8 && posX3 == 9) && (posO == 2 && posO2 == 5)) { valor = 7; break;}
            if ((posX == 3 && posX2 == 7 && posX3 == 8) && (posO == 2 && posO2 == 5)) { valor = 9; break;}
            //2da. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 6) && (posO == 5 && posO2 == 9)) { valor = 2; break;}
            if ((posX == 1 && posX2 == 3 && posX3 == 4) && (posO == 5 && posO2 == 7)) { valor = 2; break;}
            if ((posX == 6 && posX2 == 7 && posX3 == 9) && (posO == 3 && posO2 == 6)) { valor = 8; break;}
            if ((posX == 4 && posX2 == 7 && posX3 == 9) && (posO == 1 && posO2 == 5)) { valor = 8; break;}
            //3ra. Forma
            if ((posX == 1 && posX2 == 6 && posX3 == 7) && (posO == 5 && posO2 == 9)) { valor = 4; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 9) && (posO == 5 && posO2 == 7)) { valor = 6; break;}
            if ((posX == 1 && posX2 == 6 && posX3 == 7) && (posO == 3 && posO2 == 5)) { valor = 4; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 9) && (posO == 1 && posO2 == 5)) { valor = 8; break;}
            //4ta. Forma
            if ((posX == 1 && posX2 == 4 && posX3 == 6) && (posO == 5 && posO2 == 9)) { valor = 7; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 6) && (posO == 5 && posO2 == 7)) { valor = 9; break;}
            if ((posX == 6 && posX2 == 7 && posX3 == 8) && (posO == 3 && posO2 == 5)) { valor = 9; break;}
            if ((posX == 4 && posX2 == 8 && posX3 == 9) && (posO == 1 && posO2 == 5)) { valor = 7; break;}
            //5ta. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 6) && (posO == 1 && posO2 == 5)) { valor = 7; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 8) && (posO == 5 && posO2 == 7)) { valor = 9; break;}
            if ((posX == 1 && posX2 == 6 && posX3 == 8) && (posO == 5 && posO2 == 9)) { valor = 7; break;}
            if ((posX == 2 && posX2 == 6 && posX3 == 7) && (posO == 3 && posO2 == 5)) { valor = 9; break;}
            //6ta. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 7) && (posO == 1 && posO2 == 8)) { valor = 3; break;}
            if ((posX == 4 && posX2 == 5 && posX3 == 7) && (posO == 1 && posO2 == 6)) { valor = 3; break;}
            if ((posX == 5 && posX2 == 6 && posX3 == 7) && (posO == 1 && posO2 == 4)) { valor = 3; break;}
            if ((posX == 3 && posX2 == 5 && posX3 == 8) && (posO == 1 && posO2 == 2)) { valor = 7; break;}
            //7ma. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 5) && (posO == 1 && posO2 == 8)) { valor = 6; break;}
            if ((posX == 4 && posX2 == 5 && posX3 == 8) && (posO == 1 && posO2 == 6)) { valor = 2; break;}
            //8va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5) && (posO == 1 && posO2 == 8)) { valor = 7; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 5) && (posO == 1 && posO2 == 6)) { valor = 7; break;}
            //9na. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 6) && (posO == 1 && posO2 == 8)) { valor = 4; break;}
            if ((posX == 3 && posX2 == 4 && posX3 == 5) && (posO == 1 && posO2 == 6)) { valor = 7; break;}
            //10ma. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 9) && (posO == 1 && posO2 == 8)) { valor = 4; break;}
            if ((posX == 4 && posX2 == 5 && posX3 == 9) && (posO == 1 && posO2 == 6)) { valor = 2; break;}
        
        } while (valor != 0);
    }

    public void busca2posiciones(Totito ta) {
        int posX = 0, posO = 0, posX2 = 0, posO2 = 0, posX3 = 0, posO3 = 0, posX4 = 0, posO4 = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {

                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO2 == 0) {
                        posO2 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX2 == 0) {
                        posX2 = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO3 == 0) {
                        posO3 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX3 == 0) {
                        posX3 = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO4 == 0) {
                        posO4 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX4 == 0) {
                        posX4 = vryPosicion(i, j);
                        continue;
                    }                    
                }
            }
        }
        do {            
            //1ra. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 8 && posX4 == 9) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 6; break; }
            if ((posX == 1 && posX2 == 3 && posX3 == 7 && posX4 == 8) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 4; break; }
            //2da. Forma
            if ((posX == 1 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano
            if ((posX == 3 && posX2 == 4 && posX3 == 7 && posX4 == 8) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano
            //3ra. Forma
            if ((posX == 1 && posX2 == 6 && posX3 == 8 && posX4 == 9) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano
            if ((posX == 3 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano
            //4ta. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 6 && posX4 == 8) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 7; break; }
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 8) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 9; break; }
            if ((posX == 2 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 3 && posO2 == 5 && posO3 == 8)) { valor = 4; break; }
            if ((posX == 2 && posX2 == 4 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 8)) { valor = 3; break; }
            //5ta. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 6) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 8; break; } //Gano
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 6) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 8; break; } //Gano 
            if ((posX == 1 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 3 && posO2 == 5 && posO3 == 8)) { valor = 2; break; } //Gano
            if ((posX == 3 && posX2 == 4 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 8)) { valor = 2; break; } //Gano
            //6ta. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 6 && posX4 == 7) && (posO == 2 && posO2 == 5 && posO3 == 9)) { valor = 8; break; } //Gano
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 9) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 8; break; } //Gano 
            if ((posX == 4 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 3 && posO2 == 5 && posO3 == 8)) { valor = 2; break; } //Gano
            if ((posX == 4 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 8)) { valor = 2; break; } //Gano       
            //7ma. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 6 && posX4 == 7) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 2; break; }
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 9) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 2; break; }
            if ((posX == 1 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 3 && posO2 == 4 && posO3 == 5)) { valor = 8; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 8; break; }
            //8va. Forma
            if ((posX == 1 && posX2 == 2 && posX3 == 6 && posX4 == 7) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 3; break; }
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 9) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 1; break; }
            if ((posX == 1 && posX2 == 2 && posX3 == 6 && posX4 == 7) && (posO == 3 && posO2 == 4 && posO3 == 5)) { valor = 8; break; }
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 8; break; }
            //9na. Forma
            if ((posX == 1 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 2; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 2; break; }
            if ((posX == 1 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 3 && posO2 == 4 && posO3 == 5)) { valor = 9; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 7; break; }
            //10ma. Forma
            if ((posX == 1 && posX2 == 4 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 3; break; } //Gano 
            if ((posX == 3 && posX2 == 4 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 1; break; } //Gano 
            if ((posX == 1 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 4; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 6; break; }
            //11va. Forma
            if ((posX == 1 && posX2 == 2 && posX3 == 4 && posX4 == 6) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 8; break; } //Gano 
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 6) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 8; break; } //Gano 
            if ((posX == 2 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano
            if ((posX == 2 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano
            //12va. Forma
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 6) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 8; break; } //Gano 
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 6) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 8; break; } //Gano 
            if ((posX == 4 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano
            if ((posX == 4 && posX2 == 6 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano        
            //13va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano 
            if ((posX == 1 && posX2 == 3 && posX3 == 4 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 2; break; }
            if ((posX == 1 && posX2 == 2 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 3; break; } //Gano
            if ((posX == 1 && posX2 == 2 && posX3 == 6 && posX4 == 7) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 4; break; }
            //14va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 6 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 3; break; } //Gano 
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 1; break; } //Gano 
            if ((posX == 1 && posX2 == 3 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 2; break; }
            if ((posX == 2 && posX2 == 4 && posX3 == 6 && posX4 == 7) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano      
            //15va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 9) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 6; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 1; break; }
            if ((posX == 1 && posX2 == 4 && posX3 == 6 && posX4 == 8) && (posO == 5 && posO2 == 7 && posO3 == 9)) { valor = 3; break; } //Gano 
            if ((posX == 2 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 3 && posO2 == 5 && posO3 == 9)) { valor = 1; break; } //Gano        
            //16va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 3 && posO3 == 8)) { valor = 4; break; }
            if ((posX == 4 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 3 && posO3 == 6)) { valor = 2; break; } //Gano
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 7) && (posO == 1 && posO2 == 3 && posO3 == 4)) { valor = 8; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 8) && (posO == 1 && posO2 == 2 && posO3 == 7)) { valor = 6; break; }
            //16va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 3 && posO3 == 8)) { valor = 4; break; }
            if ((posX == 4 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 3 && posO3 == 6)) { valor = 2; break; } //Gano
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 7) && (posO == 1 && posO2 == 3 && posO3 == 4)) { valor = 8; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 8) && (posO == 1 && posO2 == 2 && posO3 == 7)) { valor = 6; break; }
            //17va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 7) && (posO == 1 && posO2 == 3 && posO3 == 8)) { valor = 6; break; }
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 7) && (posO == 1 && posO2 == 3 && posO3 == 6)) { valor = 9; break; } //Gano
            if ((posX == 5 && posX2 == 6 && posX3 == 7 && posX4 == 8) && (posO == 1 && posO2 == 3 && posO3 == 4)) { valor = 2; break; } //Gano 
            if ((posX == 3 && posX2 == 5 && posX3 == 6 && posX4 == 8) && (posO == 1 && posO2 == 2 && posO3 == 7)) { valor = 4; break; } //Gano     
            //18va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 7) && (posO == 1 && posO2 == 3 && posO3 == 8)) { valor = 4; break; }
            if ((posX == 4 && posX2 == 5 && posX3 == 7 && posX4 == 8) && (posO == 1 && posO2 == 3 && posO3 == 6)) { valor = 2; break; } //Gano
            if ((posX == 5 && posX2 == 6 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 3 && posO3 == 4)) { valor = 2; break; } //Gano 
            if ((posX == 3 && posX2 == 5 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 7)) { valor = 4; break; } //Gano       
            //19va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 5) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 7; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 8) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 7; break; }
            //20va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 7) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 3; break; }
            if ((posX == 4 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 3; break; } //Gano
            //21va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 7; break; }
            if ((posX == 4 && posX2 == 5 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 3; break; } //Gano        
            //22va. Forma
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 6) && (posO == 1 && posO2 == 7 && posO3 == 8)) { valor = 9; break; } //Gano
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 5) && (posO == 1 && posO2 == 6 && posO3 == 7)) { valor = 8; break; }
            //23va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5 && posX4 == 6) && (posO == 1 && posO2 == 7 && posO3 == 8)) { valor = 9; break; } //Gano
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 8) && (posO == 1 && posO2 == 6 && posO3 == 7)) { valor = 2; break; }
            //24va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 7 && posO3 == 8)) { valor = 4; break; } //Gano
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 6 && posO3 == 7)) { valor = 8; break; }
            //24va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 7 && posO3 == 8)) { valor = 4; break; } //Gano
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 6 && posO3 == 7)) { valor = 8; break; }
            //25va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 7) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 3; break; }
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 7) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 3; break; }
            //26va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5 && posX4 == 6) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 7; break; } //Gano
            if ((posX == 2 && posX2 == 3 && posX3 == 4 && posX4 == 5) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 7; break; }
            //27va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 9) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 7; break; } //Gano
            if ((posX == 2 && posX2 == 4 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 6 && posO3 == 8)) { valor = 7; break; }
            //28va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 3; break; }
            if ((posX == 3 && posX2 == 4 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 7; break; }
            //29va. Forma
            if ((posX == 2 && posX2 == 3 && posX3 == 5 && posX4 == 9) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 7; break; } //Gano 
            if ((posX == 4 && posX2 == 5 && posX3 == 7 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 3; break; } //Gano    
            //30va. Forma
            if ((posX == 2 && posX2 == 5 && posX3 == 6 && posX4 == 9) && (posO == 1 && posO2 == 4 && posO3 == 8)) { valor = 7; break; } //Gano 
            if ((posX == 4 && posX2 == 5 && posX3 == 8 && posX4 == 9) && (posO == 1 && posO2 == 2 && posO3 == 6)) { valor = 3; break; } //Gano   
        
        } while (valor != 0);
    }

    //Si es primer turno
    public void busca9posiciones(Totito ta) {
        if (1 == 1) { //Para dejarse de llevarselas de don vergas
            valor = 5;
        } else {
            int opc = (int) (Math.random() * 3 + 1);
            //log("Opcion aleatorio: " + opc);
            switch (opc) {
                case 1: //Abre por las esquinas
                    opc = (int) (Math.random() * 4 + 1);
                    switch (opc) {
                        case 1:
                            valor = 1;
                            break;
                        case 2:
                            valor = 3;
                            break;
                        case 3:
                            valor = 7;
                            break;
                        case 4:
                            valor = 9;
                            break;
                    }
                case 2: //Abre por el centro
                    valor = 5;
                    break;
                case 3: //Abre por los laterales
                    opc = (int) (Math.random() * 4 + 1);
                    switch (opc) {
                        case 1:
                            valor = 2;
                            break;
                        case 2:
                            valor = 4;
                            break;
                        case 3:
                            valor = 6;
                            break;
                        case 4:
                            valor = 8;
                            break;
                    }
            }
        }
    }

    public void busca7posiciones(Totito ta) {
        int posX = 0, posO = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {
                    if (ta.totito[i][j] == 2) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1) {
                        posX = vryPosicion(i, j);
                        continue;
                    }
                }
            }
        }
        do {
            //1ra. Forma
            if ((posX == 1 || posX == 2 || posX == 4 || posX == 6 || posX == 8 || posX == 9) && posO == 5) { valor = 7; break; }
            //2da. Forma
            if (posX == 3 && posO == 5) { valor = 1; break; }
            //3ra. Forma
            if (posX == 7 && posO == 5) { valor = 9; break; }

        } while (valor != 0);
    }

    public void busca5posiciones(Totito ta) {
        int posX = 0, posO = 0, posX2 = 0, posO2 = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {                   
                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO2 == 0) {
                        posO2 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX2 == 0) {
                        posX2 = vryPosicion(i, j);
                        continue;
                    }                    
                }
            }
        }
        do {
            //1ra. Forma
            if ((posX == 1 && posX2 == 2 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 1 && posX2 == 3 ) && (posO == 5 && posO2 == 7)) { valor = 2; break;}
            if ((posX == 1 && posX2 == 4 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 1 && posX2 == 6 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 1 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 1 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            //2da. Forma
            if ((posX == 2 && posX2 == 3 ) && (posO == 5 && posO2 == 7)) { valor = 1; break;}
            if ((posX == 2 && posX2 == 4 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 2 && posX2 == 6 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 2 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 2 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano  
            //3ra. Forma
            if ((posX == 2 && posX2 == 3 ) && (posO == 1 && posO2 == 5)) { valor = 9; break;} //Gano
            if ((posX == 3 && posX2 == 4 ) && (posO == 1 && posO2 == 5)) { valor = 9; break;} //Gano
            if ((posX == 3 && posX2 == 6 ) && (posO == 1 && posO2 == 5)) { valor = 9; break;} //Gano
            if ((posX == 3 && posX2 == 7 ) && (posO == 1 && posO2 == 5)) { valor = 9; break;} //Gano
            if ((posX == 3 && posX2 == 8 ) && (posO == 1 && posO2 == 5)) { valor = 9; break;} //Gano
            if ((posX == 3 && posX2 == 9 ) && (posO == 1 && posO2 == 5)) { valor = 6; break;}
            //4ta. Forma
            if ((posX == 3 && posX2 == 4 ) && (posO == 5 && posO2 == 7)) { valor = 9; break;} 
            if ((posX == 4 && posX2 == 6 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano        
            if ((posX == 4 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 4 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano   
            //5ta. Forma
            if ((posX == 1 && posX2 == 7 ) && (posO == 5 && posO2 == 9)) { valor = 4; break;} 
            if ((posX == 2 && posX2 == 7 ) && (posO == 5 && posO2 == 9)) { valor = 1; break;} //Gano        
            if ((posX == 3 && posX2 == 7 ) && (posO == 5 && posO2 == 9)) { valor = 1; break;} //Gano
            if ((posX == 4 && posX2 == 7 ) && (posO == 5 && posO2 == 9)) { valor = 1; break;} //Gano           
            if ((posX == 6 && posX2 == 7 ) && (posO == 5 && posO2 == 9)) { valor = 1; break;} //Gano           
            if ((posX == 7 && posX2 == 8 ) && (posO == 5 && posO2 == 9)) { valor = 1; break;} //Gano   
            //6ta. Forma
            if ((posX == 1 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 3 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 1; break;} //Gano        
            if ((posX == 4 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 6 && posX2 == 8 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            if ((posX == 8 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
            //7ma. Forma
            if ((posX == 3 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 6; break;} //Gano
            if ((posX == 6 && posX2 == 9 ) && (posO == 5 && posO2 == 7)) { valor = 3; break;} //Gano
        
        } while (valor != 0);
    }

    public void busca3posiciones(Totito ta) {
        int posX = 0, posO = 0, posX2 = 0, posO2 = 0, posX3 = 0, posO3 = 0;
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] != 0) {

                    if (ta.totito[i][j] == 2 && posO == 0) {
                        posO = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX == 0) {
                        posX = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO2 == 0) {
                        posO2 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX2 == 0) {
                        posX2 = vryPosicion(i, j);
                        continue;
                    }

                    if (ta.totito[i][j] == 2 && posO3 == 0) {
                        posO3 = vryPosicion(i, j);
                        continue;
                    }
                    if (ta.totito[i][j] == 1 && posX3 == 0) {
                        posX3 = vryPosicion(i, j);
                        continue;
                    }
                }
            }
        }
        do {
        //1ra. Forma
        if ((posX == 1 && posX2 == 3 && posX3 == 4 ) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 8; break;} //Gano
        if ((posX == 1 && posX2 == 3 && posX3 == 6 ) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 8; break;} //Gano
        if ((posX == 1 && posX2 == 3 && posX3 == 8 ) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 6; break;} 
        if ((posX == 1 && posX2 == 3 && posX3 == 9 ) && (posO == 2 && posO2 == 5 && posO3 == 7)) { valor = 8; break;} //Gano
        //2da. Forma
        if ((posX == 2 && posX2 == 3 && posX3 == 4 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 9; break;} 
        if ((posX == 2 && posX2 == 3 && posX3 == 6 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 2 && posX2 == 3 && posX3 == 8 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 2 && posX2 == 3 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        //3ra. Forma
        if ((posX == 2 && posX2 == 3 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 4; break;} //Gano 
        if ((posX == 3 && posX2 == 4 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 8; break;}
        if ((posX == 3 && posX2 == 7 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 4; break;} //Gano 
        if ((posX == 3 && posX2 == 8 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 6)) { valor = 4; break;} //Gano 
        //4ta. Forma
        if ((posX == 1 && posX2 == 3 && posX3 == 4 ) && (posO == 5 && posO2 == 6 && posO3 == 9)) { valor = 8; break;} //Gano
        if ((posX == 2 && posX2 == 3 && posX3 == 4 ) && (posO == 5 && posO2 == 6 && posO3 == 9)) { valor = 8; break;} //Gano
        if ((posX == 3 && posX2 == 4 && posX3 == 6 ) && (posO == 5 && posO2 == 6 && posO3 == 9)) { valor = 8; break;} //Gano
        if ((posX == 3 && posX2 == 4 && posX3 == 8 ) && (posO == 5 && posO2 == 6 && posO3 == 9)) { valor = 1; break;} //Gano
        //5ta. Forma
        if ((posX == 1 && posX2 == 2 && posX3 == 7 ) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 6; break;} //Gano
        if ((posX == 1 && posX2 == 3 && posX3 == 7 ) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 6; break;} //Gano
        if ((posX == 1 && posX2 == 6 && posX3 == 7 ) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 2; break;} 
        if ((posX == 1 && posX2 == 7 && posX3 == 8 ) && (posO == 4 && posO2 == 5 && posO3 == 9)) { valor = 6; break;} //Gano
        //6ta. Forma
        if ((posX == 2 && posX2 == 3 && posX3 == 8 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 3 && posX2 == 4 && posX3 == 8 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 9; break;} //Gano
        if ((posX == 3 && posX2 == 6 && posX3 == 8 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 3 && posX2 == 8 && posX3 == 9 ) && (posO == 1 && posO2 == 5 && posO3 == 7)) { valor = 4; break;} //Gano
        //7ma. Forma
        if ((posX == 1 && posX2 == 3 && posX3 == 9 ) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 2 && posX2 == 3 && posX3 == 9 ) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 4; break;} //Gano
        if ((posX == 3 && posX2 == 4 && posX3 == 9 ) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 2; break;} //Gano
        if ((posX == 3 && posX2 == 8 && posX3 == 9 ) && (posO == 5 && posO2 == 6 && posO3 == 7)) { valor = 4; break;} //Gano
        
        } while (valor != 0);
    }

    public void busca1posiciones(Totito ta) {
        int posO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ta.totito[i][j] == 0) {
                    posO = vryPosicion(i, j);
                    break;
                }
            }
        }
        valor = posO;
    }

    public int vryPosicion(int i, int j) {
        int valor = 0;
        do {
        if (i == 0 && j == 0) { valor = 1; break;}
        if (i == 0 && j == 1) { valor = 2; break;}
        if (i == 0 && j == 2) { valor = 3; break;}
        if (i == 1 && j == 0) { valor = 4; break;}
        if (i == 1 && j == 1) { valor = 5; break;}
        if (i == 1 && j == 2) { valor = 6; break;}
        if (i == 2 && j == 0) { valor = 7; break;}
        if (i == 2 && j == 1) { valor = 8; break;}
        if (i == 2 && j == 2) { valor = 9; break;}
        
        } while (valor != 0);
        return valor;
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
