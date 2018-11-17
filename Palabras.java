
package csv.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Palabras {
    private NodoPalabra raiz;
    
     public Palabras(){
        raiz = null;
    }
    
    public void insertarNodo( String valorInsertar ){
        if ( raiz == null ){
            raiz = new NodoPalabra( valorInsertar );
        }else{
            raiz.insertar( valorInsertar );
        }
    }
    
    public void recorridoPreorden(){
        ayudantePreorden( raiz );
    }
    
    private void ayudantePreorden( NodoPalabra nodo ){
        if ( nodo == null ){
            return;
        }
        System.out.printf( "%d ", nodo.datos );
        ayudantePreorden( nodo.nodoIzq );
        ayudantePreorden( nodo.nodoDer );
    }
 

    
    public void recorridoInorden(){
        ayudanteInorden( raiz );
    }
    
    private void ayudanteInorden( NodoPalabra nodo ){
        if ( nodo == null ){
            return;
            
        }
        ayudanteInorden( nodo.nodoIzq );
        System.out.println(nodo.datos );
        
        ayudanteInorden( nodo.nodoDer );
  
    }
    public void recorridoPostorden(){
        ayudantePostorden( raiz );
    }
    private void ayudantePostorden( NodoPalabra nodo ){
        if ( nodo == null ){
           return; 
        }
        ayudantePostorden( nodo.nodoIzq );
        ayudantePostorden( nodo.nodoDer );
        System.out.printf( "%d ", nodo.datos );
    }
    
    //Codigo que lee las palabras de un archivo csv o txt y devuelve un arreglo de String con las letras en mayuscula
    public  String[] muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        int cantWords = 0;
        int index =0;
        String palabras[];    //declaring array
        
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            
            cantWords++;
        }
        
        b.close();
        
        f = new FileReader(archivo);
        b = new BufferedReader(f);
        palabras = new String[cantWords];
        while((cadena = b.readLine())!=null) {
            
            palabras[index]=cadena.toUpperCase();
            index++;
        }
        b.close();
        
        return palabras;
    }
    //Codigo que recibe un Arreglo de palabras y as imprime
   public  void showWords(String palabras[]){
       for(int index=0;index<palabras.length;index++){
            System.out.println(palabras[index]);
       }
   }
   
   //Código que va a leer un csv o txt y va a ingresarlo en el arbol binario de busqueda
   public  void registarPalabras(String archivo) throws IOException{
       String [] palabras = muestraContenido(archivo);
        for (String palabra : palabras) {
            insertarNodo(palabra);
        }
       
   }
}
