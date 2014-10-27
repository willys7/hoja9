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
public class AlgoDeFloyd {
    Documento a= new Documento();
    IntefazGrafo inter;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;

    public AlgoDeFloyd(){
        
        try {
            a.obtenerDoc("/Users/manuelgomez/Downloads/Hoja9/datos.txt");
            a.Nombres(); // Nombre de los nodos
            inter = a.Pesos(); // Peso de los arcos entre nodos
            P = new int[25][25]; // Matriz de nodos intermedios
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<a.grafoNe.size();n++){
            for(int m=0;m<a.grafoNe.size();m++){
                P[n][m]=10000;
            }
        }
    }
    
    public void masCorto(){
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

    public void centroDeGraf(){
        masCorto();
        int n=0;       

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

        for(int i=0;i<inter.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("  El centro del mapa es la ciudad de: "+inter.get(centro)+"\n");
        
    }

    public void CiudadesMedias(int num1, int num2){
        if(P[num1][num2]!=10000){
            CiudadesMedias(num1,P[num1][num2]);
            System.out.print(", "+inter.get(P[num1][num2]));
            CiudadesMedias(P[num1][num2],num2);
            return;
        }
        else return;
      
}
}
