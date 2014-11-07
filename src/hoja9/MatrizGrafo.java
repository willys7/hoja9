/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja9;
import java.util.Vector;
/**
 *
 * @author William
 */
public class MatrizGrafo<V,E> implements IntefazGrafo<V,E>{

    private Vector ciudadesVe = new Vector();
    private int[][] vuelta= new int [25][25];
    

    public MatrizGrafo(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    vuelta[i][j]=0;
                }
                else{
                    vuelta[i][j]=10000;
                }
            }
        }
    }

    @Override
    public void agregar(V label) {
        
        if(!ciudadesVe.contains(label)){
            ciudadesVe.add(label);
        }
        
        
    }
    
    @Override
    public void agregarVertice(V vtx1, V vtx2, E label) {
        int i = ciudadesVe.indexOf(vtx1);
        int j = ciudadesVe.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        vuelta[i][j]=peso;
    }

    @Override
    public void desplegar(){
        for(int a=0;a<ciudadesVe.size();a++){
            for(int b=0;b<ciudadesVe.size();b++){
                System.out.print(""+vuelta[a][b]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public int size(){
        return ciudadesVe.size();
    }

    @Override
    public int getVertice(V label1, V label2){
        return vuelta[ciudadesVe.indexOf(label1)][ciudadesVe.indexOf(label2)];
    }

    @Override
    public V get(int label){
        
        return (V)ciudadesVe.get(label);
        
    }
    
    @Override
    public int getIndex(V label){
        return ciudadesVe.indexOf(label);
    }

    public boolean contains(V label){
        return ciudadesVe.contains(label);
    }
}

