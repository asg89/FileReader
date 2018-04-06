import java.io.*;
import java.util.Scanner;




class RunnableDemo extends Thread {
	   private Thread t;
	   private String fileName;
	   public static String f;
	   public static String f2;
	   String text = "";
	   public static int k=1;
	   public static int j=1;
	   
	   //public static String stringLine="";
	   
	   
	   RunnableDemo( String name) {
	      fileName = name;
	      //System.out.println("Creating " +  threadName );
	   }
	   
	   public synchronized void run() {
		    FileReader fr = null;
		    BufferedReader br =null;
		    FileOutputStream fout=null;
		    String filename ="";
		    String s="";
		    String stringLine="";

		    //Count(){}


		    try{
		     
		        fr = new FileReader(fileName);
		        br = new BufferedReader(fr);
		        fout=new FileOutputStream(new File("res.txt"),true);
		        while((s = br.readLine()) != null){
		            stringLine = stringLine + s;
		            fout.write(" ".getBytes());
		            fout.write(s.getBytes());
		            fout.write(" ".getBytes());
		            //System.out.println(s);
		            stringLine = stringLine + " ";
		           // countLine ++;
		           // System.out.println(countLine);
		        }
		        //fout.write(stringLine.getBytes());
		        //fout.write(-1);
		        fout.close();
		        //System.out.println("Thread Completed "+fileName);
		        



		       // System.out.println("Contents of file: " + stringLine);
		 
		       

		        fr.close();
		        br.close();
		    }

		    
		    catch (Exception e) {
		        e.printStackTrace();
		    }

		   
				   }
	   public void start ()  {
		      System.out.println(" Reading" +  fileName +"\n");
		      if (t == null) {
		         t = new Thread (this, fileName);
		         t.start ();
		         try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         //t.join();
		      }
		   }
	}


public class Count4 {
    public static void main(String[] args) throws IOException, InterruptedException {
    	FileOutputStream fout2=new FileOutputStream(new File("res.txt"),false);
    	fout2.close();
    	String [] stringArray;
	    //int countLine = 0;
	    int [] count=new int[100];
	    int arrayLength ;
	    String stringLine2="";
	    String s="";
	    String wordname ="";
    	System.out.println("Enter the name of the file1");
    	Scanner sc=new Scanner(System.in);
    	String f1=sc.nextLine();
    	System.out.println("Enter the name of the file2");
    	String f2=sc.nextLine();
    	RunnableDemo R1 = new RunnableDemo(f1);
        R1.start();
        //R1.join();
        RunnableDemo R2 = new RunnableDemo(f2);
        R2.start();
        //R2.join();
        
        //System.out.println("The total number of words in the text file is "+arrayLength);
        /*Duplicate String count code */
        
        
        while( (R1.isAlive()||R2.isAlive()))
        {
        	//System.out.println("Thread Completed");
        }
        //System.out.println("Thread Completed");
       
       System.out.println("Words in increasing order is");
       

            FileReader fr = null;
	    BufferedReader br =null;
	         
	   fr = new FileReader("res.txt");
       br = new BufferedReader(fr);
       while((s = br.readLine()) != null){
           stringLine2 = stringLine2 + s;
          //System.out.println(s);
          stringLine2 = stringLine2 + " ";
          // countLine ++;
          // System.out.println(countLine);
       }
       //System.out.println("S is " +stringLine2);
       stringArray = stringLine2.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
       arrayLength = stringArray.length;

	   for (int i = 0; i < arrayLength; i++) {
            count[i]=0;
            //int c = 1 ;
            for (int j = i+1; j < arrayLength; j++) {
                if(stringArray[i].equalsIgnoreCase(stringArray[j])){
                    count[i]++;
                    for (int j2 = j; j2 < arrayLength-1; j2++) 
                        stringArray[j2] = stringArray[j2+1];
			j=j-1;
                        arrayLength = arrayLength - 1;
                    }
                    //System.out.println(wordname);
                      // if (stringArray[i].equalsIgnoreCase(wordname)){
          // System.out.println("The word "+wordname+" is present "+c+" times in the specified file.");
           }
        }
      //  for (int k = 0; k < arrayLength; k++)
        //   System.out.println(stringArray[k]);
     /*insertion sort*/  
       for (int k = 0; k < arrayLength; k++) {
         
      int temp = count[ k ]; 
      String temp1= stringArray[k];    
      int m = k;

          while(  m > 0  && temp < count[ m -1]) {

                count[ m ] = count[ m-1];
                stringArray[m] = stringArray[m-1];   
                m= m - 1;

           }
         
           count[ m ] = temp;  
           stringArray[m] = temp1;      
      
       }
       //  for (int k = 0; k < arrayLength; k++)
        //System.out.println(count[k]);
       for (int k = 0; k < arrayLength; k++){
       	 if(!stringArray[k].equals("")){
       	 System.out.print(stringArray[k]+"   ");
       	 }
       	}

       }
}
