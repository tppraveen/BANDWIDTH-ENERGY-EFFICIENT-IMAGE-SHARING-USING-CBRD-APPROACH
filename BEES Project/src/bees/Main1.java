/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bees;

/**
 *
 * @author admin
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserFrame cf=new UserFrame();
        cf.setVisible(true);
        cf.setResizable(false);
        cf.setTitle("BEES Client");
        
              
        ServerFrame sf=new ServerFrame();
        sf.setVisible(true);
        sf.setResizable(false);
        sf.setTitle("BEES Server");
       
    }
    
}
