/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.reader;

/**
 *
 * @author barbozca2
 */
public class NodoPalabra {
    public String datos;
    public NodoPalabra nodoDer;
    public NodoPalabra nodoIzq;
    
    public NodoPalabra(String palabra){
        datos = palabra;
        nodoDer = nodoIzq = null;
    }
    
    public void insertar( String valorInsertar )
    {
        // inserta en el subárbol izquierdo
        char[] wordToInsert,actualWord;
        
        int charPositionToEvaluate = 0;
        wordToInsert = valorInsertar.toCharArray();
        actualWord = datos.toCharArray();
        
        int assciiValuewordToInsert= (int) wordToInsert[charPositionToEvaluate];
        int assciiValueactualWord= (int) actualWord[charPositionToEvaluate];
        
        if ( assciiValuewordToInsert < assciiValueactualWord ){
            if ( nodoIzq == null ){
                nodoIzq = new NodoPalabra( valorInsertar );
            }else{
                nodoIzq.insertar( valorInsertar );
            }
        }else if (assciiValuewordToInsert > assciiValueactualWord){
            if ( nodoDer == null ){
                nodoDer = new NodoPalabra( valorInsertar );
            }else{
                nodoDer.insertar( valorInsertar );
            }
        }else if(assciiValuewordToInsert==assciiValueactualWord){
            for(int index=1;index<actualWord.length;index++){
                charPositionToEvaluate++;
                assciiValuewordToInsert= (int) wordToInsert[charPositionToEvaluate];
                assciiValueactualWord= (int) actualWord[charPositionToEvaluate];
                if ( assciiValuewordToInsert < assciiValueactualWord ){
                    if ( nodoIzq == null ){
                        nodoIzq = new NodoPalabra( valorInsertar );
                        break;
                    }else{
                        nodoIzq.insertar( valorInsertar );
                        break;
                    }
                }else if (assciiValuewordToInsert > assciiValueactualWord){
                    if ( nodoDer == null ){
                        nodoDer = new NodoPalabra( valorInsertar );
                        break;
                    }else{
                        nodoDer.insertar( valorInsertar );
                        break;
                    }
                }
            }
        }
    } 
}
