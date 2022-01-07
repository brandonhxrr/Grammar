package grammar;

import grammar.NAryTree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Grammar11 {
    
    static Stack<String> pila = new Stack<>();
    
    static TreeNode root = new TreeNode("E");
    
    static int analyzeExpression(String str){

        int state = 0, index = 0;
        char symbol;
        
        while(index != (str.length() )){

            symbol = str.charAt(index);

            switch (state){
                case 0:
                    if(Character.isLetter(symbol)){
                        state = 1;
                    }else if(Character.isDigit(symbol)  && !pila.empty() && pila.peek().equals("1")){ // Verificar que haya 1 en el tope de la pila y meter un 1 o no hacer nada
                        state = 2;
                    }else if(symbol == '('  && !pila.empty() && pila.peek().equals("1")){ // Verificar que haya 1 en el tope de la pila, sacarlo y meter 1X
                        state = 0;
                        pila.pop();
                        pila.push("X");
                        pila.push("1");
                    }else{
                        state = 17; // Dead state
                    }
                break;
                case 1:
                    if(Character.isLetter(symbol) || symbol == '_'){
                        state = 1;
                    }else if(Character.isDigit(symbol)){
                        state = 2;
                    }else if(symbol == '='){
                        state = 0;
                        pila.push("1");
                    }else if(symbol == ';'  && !pila.empty()  && pila.peek().equals("1")){
                        state = 0;
                        pila.pop();
                    }else if(isOperator(symbol)  && !pila.empty()  && pila.peek().equals("1")){
                        state = 0;
                    }else if(symbol == ')'  && !pila.empty() && pila.peek().equals("1") && pila.elementAt(pila.size() -2).equals("X")){ // Verificar que haya 1 en el tope de la pila, sacarlo y meter 1X
                        state = 1;
                        pila.pop();
                        pila.pop();
                        pila.push("1");
                    }else{
                        state = 17;
                    }
                break;
                case 2:
                    if(Character.isDigit(symbol)){
                        state = 2;
                    }else if(symbol == ')'  && pila.size() > 1 && pila.peek().equals("1") && pila.elementAt(pila.size() -2).equals("X")){ // Verificar que haya 1 en el tope de la pila, sacarlo y meter 1X
                        state = 2;
                        pila.pop();
                        pila.pop();
                        pila.push("1");
                    }else if(isOperator(symbol)  && !pila.empty()  && pila.peek().equals("1")){
                        state = 0;
                    }else if(symbol == '='){
                        state = 0;
                        pila.push("1");
                    }else if(symbol == ';'  && !pila.empty() && pila.peek().equals("1")){
                        state = 0;
                        pila.pop();
                    }else{
                        state = 17;
                    }
                break;
            }
            if(!pila.empty()){
                System.out.println("SYMBOL: " + symbol + " TOPE: " + pila.peek() + " ESTADO: " + state);
            }else{
                System.out.println("SYMBOL: " + symbol + " ESTADO: " + state);
            }
            

            index++;
        }
        return state;
    }
    
    static boolean isOperator(Character op){
        List<Character> operators = Arrays.asList('+', '-', '/', '*', '%');
        return operators.stream().anyMatch(operator -> (op.equals(operator)));
    }
    
    static void createDerivationTree(String str){
        String branch = "";
        
        ArrayList<String> operators = new ArrayList();
        ArrayList<String> ops = new ArrayList();
        
        TreeNode I = new TreeNode("I");
        TreeNode O = new TreeNode("O");
        
        TreeNode P = new TreeNode("P");
        
        TreeNode LI = new TreeNode("L");
        TreeNode DI = new TreeNode("D");
        
        root.children.add(I);
        root.children.add(new TreeNode("="));
        root.children.add(O);
        root.children.add(new TreeNode(";"));
        
        I.children.add(LI);
        I.children.add(DI);
        
        O.children.add(P);
        
        
        int index = 0, control = 0, index2 = 0, index3 = 0, contSymbols = 0;
        char symbol;
        
        while(index != (str.length() )){

            symbol = str.charAt(index);
            
            if(symbol == '='){
                control = 1;
            }
            
            if(control == 0){
                if(Character.isLetter(symbol)){
                    addChild(LI, "L", String.valueOf(symbol), index2);
                    index2++;
                }else if(Character.isDigit(symbol)){    
                    addChild(DI, "D", String.valueOf(symbol), index3);
                    index3++;
                }
            }else{
                if(!isOperator(symbol) && symbol != '=' && symbol != ';'){
                    branch += String.valueOf(symbol);
                }
                if(isOperator(symbol) || symbol == ';'){
                    System.out.println("BRANCH: " + branch);
                    operators.add(branch);
                    if(symbol!= ';'){
                        ops.add(String.valueOf(symbol));
                    }else{
                        ops.add(" ");
                    }
                    branch = "";
                    contSymbols++;
                }
            }
            
            index++;
        }
                
        addRecursiveChild(operators, ops, P);
            
        NAryTree.printNAryTree(root);
        
    }
    
    static void addChild(TreeNode parent, String par, String child, int index){
                
        parent.children.add(new TreeNode(par));
        parent.children.get(index).children.add(new TreeNode(String.valueOf(child)));
    }
    
    static void addRecursiveChild(ArrayList<String> operators, ArrayList<String> ops, TreeNode parent){
        TreeNode P1, S1, P2, L1, D1;
        ArrayList<String> ops1, ops2;
        
        int indexS = 0, tope;
        
        if(operators.size() > 1){
            parent.children.add(new TreeNode("P"));
            parent.children.add(new TreeNode("S"));
            parent.children.add(new TreeNode("P"));
            
            P1 = parent.children.get(0);
            S1 = parent.children.get(1);
            P2 = parent.children.get(2);
            
           tope = (int) ((operators.size()%2 == 0) ? (operators.size()/2) -1 : Math.ceil(operators.size()/2));
                        
            printArray(ops);
            if(!ops.isEmpty()){
                S1.children.add(new TreeNode(ops.get(0)) );
                ops.remove(0);
            }
            ops1 = new ArrayList();
            ops2 = new ArrayList();
            
            for(int i = 0; i < operators.size(); i++){
                if(i <= tope){
                    ops1.add(operators.get(i));
                }else{
                    ops2.add(operators.get(i));
                }
            }
            
            addRecursiveChild(ops1,ops, P1);
            addRecursiveChild(ops2,ops, P2);
            
        }else if(operators.size() == 1){
            
            indexS=0;
            String opU = operators.get(0);
            System.out.println("OPU: " + opU);
            
            while(indexS != opU.length()){
                if(Character.isLetter(opU.charAt(indexS))){
                    
                    L1 = new TreeNode("L");
                    parent.children.add(L1);
                    L1.children.add(new TreeNode(String.valueOf(opU.charAt(indexS))));
                }else if(Character.isDigit(opU.charAt(indexS))){
                    D1 = new TreeNode("D");
                    parent.children.add(D1);
                    D1.children.add(new TreeNode(String.valueOf(opU.charAt(indexS))));
                }
                indexS++;
            }
        }
    }
    
    static void printArray(ArrayList<String> arr){
        arr.forEach(sym -> {
            System.out.println(sym);
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int state;

        System.out.print("Expresion: ");
        String expresion = sc.next();
        
        state = analyzeExpression(expresion);
        
        if(!pila.empty() || state == 17){
            System.out.println("La expresión no es válida");
        }else{
            System.out.println("La expresión es válida");
            createDerivationTree(expresion);
        }
    }
    
}
