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

    private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    

    public MatrizGrafo(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }

    @Override
    public void agregar(V label) {
        
        if(!vertices.contains(label)){
            vertices.add(label);
        }
        
        
    }
    
    @Override
    public void agregarVertice(V vtx1, V vtx2, E label) {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;
    }

    @Override
    public void mostrar(){
        for(int a=0;a<vertices.size();a++){
            for(int b=0;b<vertices.size();b++){
                System.out.print(""+arcos[a][b]+" ");
            }
            System.out.println("");
        }
    }

    @Override
    public int size(){
        return vertices.size();
    }

    @Override
    public int getVertice(V label1, V label2){
        return arcos[vertices.indexOf(label1)][vertices.indexOf(label2)];
    }

    @Override
    public V get(int label){
        
        return (V)vertices.get(label);
        
    }
    
    @Override
    public int getIndex(V label){
        return vertices.indexOf(label);
    }

    public boolean contains(V label){
        return vertices.contains(label);
    }
}
