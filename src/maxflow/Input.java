package maxflow;

import javax.swing.JOptionPane;

public class Input {

    private int[][] array;
    private int nodesLeft,nodesRight;

    public Input(){

        nodesLeft= Integer.parseInt(JOptionPane.showInputDialog("Ange antal vänster noder."));
        nodesRight= Integer.parseInt(JOptionPane.showInputDialog("Ange antal höger noder."));

        array=new int [nodesLeft+nodesRight+2][nodesLeft+nodesRight+2];

        //Definiera kopplingen från source till vänsternoder
        for(int i=1; i<=nodesLeft;i++){
            array[0][i]=1;
        }

        //Definera kopplingen från högernoder till sink.
        for(int i=nodesLeft+1; i<array[0].length-1;i++){
            array[i][array.length-1]=1;
        }
        
        boolean input = true;
        while(input){
            String left= (JOptionPane.showInputDialog("Skapa en connection från en av vänster noderna.\n"
            +"En siffra från 1-"+nodesLeft+"\nTryck endast OK för att avsluta."));

            String right= (JOptionPane.showInputDialog("Skapa en connection till en av höger noderna.\n"
                    +"En siffra från "+(nodesLeft+1)+"-"+(nodesLeft+nodesRight)+"\nTryck endast OK för att avsluta."));

            if(left.equals("") || right.equals("")){
                input=false;
            }
            else{
                int nodeLeft=Integer.parseInt(left);
                int nodeRight=Integer.parseInt(right);
                System.out.println("Gör connection från "+nodeLeft+" till "+nodeRight);
                input = false;
                array[nodeLeft][nodeRight]=2;
            }


        }
    }
    public void printInput(){

        for(int i=0; i<array.length;i++){
            for(int k=0;k<array[i].length;k++){
                System.out.print(array[i][k]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        Input ci=new Input();
        ci.printInput();
    }
}
