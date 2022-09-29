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
