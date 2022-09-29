/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concorente;

/**
 *
 * @author aluno
 */
public class TesteThread extends Thread{
    
    public static void main(String[] args) throws InterruptedException{
//        System.out.println("Marcos Cordeiro Pires");
//        Thread.sleep(300);
//        System.out.println("Marcos Cordeiro Pires");
 
          TesteThread thre = new TesteThread();

          thre.start();
    }

    public void run(){
        System.out.println("Marcos Cordeiro Pires");

    }
    
}
