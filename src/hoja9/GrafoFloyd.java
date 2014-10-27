/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja9;

import java.io.IOException;

/**
 *
 * @author William
 */
public class GrafoFloyd {
    Archivo a= new Archivo();
    IntefazGrafo inter;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;

    public GrafoFloyd(){
        
        try {
            a.obtenerArchivo("/Users/manuelgomez/Downloads/Hoja9/datos.txt");
            a.arregloNombres(); // Nombre de los nodos
            inter = a.matrizCostos(); // Peso de los arcos entre nodos
            P = new int[25][25]; // Matriz de nodos intermedios
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<a.grafo.size();n++){
            for(int m=0;m<a.grafo.size();m++){
                P[n][m]=10000;
            }
        }
    }
    
    public void caminoCorto(){
        for(int k=0;k<inter.size();k++){
            for(int i=0;i<inter.size();i++){
                for(int j=0;j<inter.size();j++){
                    if(inter.getVertice(inter.get(i),inter.get(j))>(inter.getVertice(inter.get(i), inter.get(k))+inter.getVertice(inter.get(k), inter.get(j)))){
                        inter.agregarVertice(inter.get(i), inter.get(j), (inter.getVertice(inter.get(i), inter.get(k))+inter.getVertice(inter.get(k), inter.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        
    }

    public void centroGrafo(){
        caminoCorto();
        int n=0;       
        // Encontrar los maximos de cada columna de la matriz
        for(int i=0;i<inter.size();i++){
            for(int j=0;j<inter.size()-1;j++){
                int num1=inter.getVertice(inter.get(j), inter.get(i));
                n=j;
                n++;
                int num2=inter.getVertice(inter.get(n), inter.get(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        // Encontrar el minimo de los maximos de cada columna
        for(int i=0;i<inter.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("\nEl centro del grafo es: "+inter.get(centro)+"\n");
        
    }

    public void mostrarIntermedias(int num1, int num2){
        if(P[num1][num2]!=10000){
            mostrarIntermedias(num1,P[num1][num2]);
            System.out.print(", "+inter.get(P[num1][num2]));
            mostrarIntermedias(P[num1][num2],num2);
            return;
        }
        else return;
      
}
}