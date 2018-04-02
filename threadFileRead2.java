import java.util.*;
import java.io.*;
class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   public static String f1;
   public static String f2;
   String text = "";
   public static  int R1F = 0;
   
   RunnableDemo( String name) {
      threadName = name;
      //System.out.println("Creating " +  threadName );
   }
   
   public void run() {
	    FileInputStream fin1=null;
		FileInputStream fin2=null;
		FileInputStream fin=null;
		try {
			fin=new FileInputStream(threadName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			fin2=new FileInputStream(f2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//String text = null;
		int i;
		try {
			while((i=fin.read())!=-1){    
			    //System.out.print((char)i);  
				text=text+(char)i;
			}
		RunnableDemo.R1F=1;
		if(RunnableDemo.R1F==1){
			System.out.println(text);
		}
		//System.out.print(text);  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fin.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		try {
			fin2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		*/
   }
	   /*
	   
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
  
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
   */
   public void start () {
	      System.out.println("Starting Reading" +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
}

class TestThread {

  /* public static void main(String args[]) {
      RunnableDemo R1 = new RunnableDemo( "Thread-1");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo( "Thread-2");
      R2.start();
   } 
   */  
}
public class threadFileRead2{
	

	public static void main(String args[]) throws IOException{
	FileInputStream fin1=null;
	FileInputStream fin2=null;
	System.out.println("Enter the name of the file1");
	Scanner sc=new Scanner(System.in);
	String f=sc.nextLine();
	System.out.println("Enter the name of the file2");
	//Scanner sc=new Scanner(System.in);
	String f2=sc.nextLine();
	//System.out.println(f1);
	RunnableDemo R1 = new RunnableDemo(f);
    R1.start();
    //System.out.println(RunnableDemo.R1F);
    /*if(RunnableDemo.R1F==1)
    {
    System.out.println(R1.text);
    }
    */
    RunnableDemo R2 = new RunnableDemo( f2);
    R2.start();
    /*
    fin1.close();
    fin2.close();
*/
}
}

