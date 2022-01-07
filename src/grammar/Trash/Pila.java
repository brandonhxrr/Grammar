/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammar;

import java.util.Stack;

/**
 *
 * @author Fernando
 */
public class Pila {
    static Stack<String> pila = new Stack<>();
    
    public static void main(String[] args) {
       // pila.push("1");
        //pila.push("X");
        //pila.push("2");
        
        System.out.println("PEEK: " + pila.peek());
        //System.out.println("TOPE: " + pila.elementAt(pila.size()-1));
        //System.out.println("TOPE-1: " + pila.elementAt(pila.size() -2));
    }
    
    
    
    
}
