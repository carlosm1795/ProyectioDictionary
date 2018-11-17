
package csv.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



/**
 *
 * @author barbozca2
 */
public class CSVREADER {
    

  
    public static void main(String[] args) throws IOException {
        Palabras word = new Palabras();
        String palabras[];
        String rutaFile ="C:\\Users\\barbozca2\\Desktop\\Book1.csv";
        //String rutaFile ="C:\\Users\\barbozca2\\Desktop\\Words.txt";
        //palabras = muestraContenido(rutaFile);
        //showWords(palabras);
        word.registarPalabras(rutaFile);
        word.recorridoInorden();
    }

    //Codigo que lee las palabras de un archivo csv o txt y devuelve un arreglo de String con las letras en mayuscula
   public static String[] muestraContenido(String archivo) throws FileNotFoundException, IOException {
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
   public static void showWords(String palabras[]){
       for(int index=0;index<palabras.length;index++){
            System.out.println(palabras[index]);
       }
   }
}
