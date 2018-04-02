import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




class RunnableDemo implements Runnable {
	   private Thread t;
	   private String fileName;
	   public static String f;
	   public static String f2;
	   String text = "";
	   int flag=0;
	   public static String comp="";
	   public static FileOutputStream fout=null;
	   
	   
	   RunnableDemo( String name) {
	      fileName = name;
	      //System.out.println("Creating " +  threadName );
	   }
	   
	   public synchronized void run() {
		    FileReader fr = null;
		    BufferedReader br =null;

		     String [] stringArray;
		     //int countLine = 0;
		     int [] count=new int[100];
		     int arrayLength ;
		     String s="";
		     String stringLine="";
		     String filename ="";
		     //String wordname ="";
		     

		    //Count(){}


		    try{
		    	FileOutputStream fout=new FileOutputStream("res.txt");
		        fr = new FileReader(fileName);
		        br = new BufferedReader(fr);
		        while((s = br.readLine()) != null){
		            stringLine = stringLine + s;
		            fout.write(s.getBytes());
		            //System.out.println(s);
		            stringLine = stringLine + " ";
		            //fout.write(" ".getBytes());
		           // countLine ++;
		           // System.out.println(countLine);
		        }
		        fout.close();



		       // System.out.println("Contents of file: " + stringLine);
		        comp=comp+stringLine.toLowerCase().replaceAll("[^a-zA-Z ]", "");
		        System.out.println(comp);
		        
		        fr.close();
		        br.close();
		    }

		    
		    catch (Exception e) {
		        e.printStackTrace();
		    }

		   
				   }
	   public void start () {
		      System.out.println("Starting Reading" +  fileName +"\n");
		      if (t == null) {
		         t = new Thread (this, fileName);
		         t.start ();
		      }
		   }
	}


public class Count {
    public static void main(String[] args) throws IOException {
    	String [] stringArray;
	     //int countLine = 0;
	     int [] count=new int[100];
	     int arrayLength ;
	     String s="";
	     String stringLine="";
	     String filename ="";
	     String wordname ="";
    	System.out.println("Enter the name of the file1");
    	Scanner sc=new Scanner(System.in);
    	String f1=sc.nextLine();
    	System.out.println("Enter the name of the file2");
    	String f2=sc.nextLine();
    	RunnableDemo R1 = new RunnableDemo(f1);
        R1.start();
        RunnableDemo R2 = new RunnableDemo(f2);
        R2.start();
        
        stringArray = RunnableDemo.comp.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
        arrayLength = stringArray.length;
        //System.out.println("The total number of words in the text file is "+arrayLength);
        /*Duplicate String count code */
        
        for (int i = 0; i < arrayLength; i++) {
             count[i]=0;
            //int c = 1 ;
            for (int j = i+1; j < arrayLength; j++) {
                if(stringArray[i].equalsIgnoreCase(stringArray[j])){
                    count[i]++;
                    for (int j2 = j; j2 < arrayLength-1; j2++) 
                        stringArray[j2] = stringArray[j2+1];
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
       for (int k = 0; k < arrayLength; k++)
           System.out.print(stringArray[k]+" ");
       System.out.println("\n\n\n\n\n\n\n");

 
}
}
