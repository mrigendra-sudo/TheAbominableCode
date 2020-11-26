public class Main { 
  
    int counter = 1; 
  
    static int N; 
  
    public void Methodd2() 
    { 
        synchronized (this) 
        { 
         
            while (counter < N) { 
  
                while (counter % 2 == 0) { 
  
                    // Exception handle 
                    try { 
                        wait();
                    } 
                    catch ( 
                        InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                } 
  
                // Print the number 
                System.out.print(counter + " "); 
  
                // Increment counter 
                counter++; 
  
                notify(); 
            } 
        } 
    } 
  
   
    public void Method1() 
    { 
        synchronized (this) 
        { 
            
            while (counter < N) { 
  
               
                while (counter % 2 == 1) { 
  
                   
                    try { 
                        wait(); 
                    } 
                    catch ( 
                        InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                } 
  
                
                System.out.print( 
                    counter + " "); 
  
                
                counter++; 
  
                
                notify(); 
            } 
        } 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
        
        N = 100; 
  
        
        Main mat = new Main(); 
  
        
        Thread t1 = new Thread(new Runnable() { 
            public void run() 
            { 
                mat.Method1(); 
            } 
        }); 
  
       
        Thread t2 = new Thread(new Runnable() { 
            public void run() 
            { 
                mat.Methodd2(); 
            } 
        }); 
  
        
        t1.start(); 
        t2.start(); 
    } 
} 
