/*************************************************************************
 *  Compilation:  javac Out.java
 *  Execution:    java Out
 *
 *  Writes data of various types to: stdout, file, or socket.
 *
 *************************************************************************/


import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Out{

   
    private PrintWriter out;
    private static final String charsetName = "UTF-8";


  
    public Out(OutputStream os) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

  
    public Out() { this(System.out); }

  
    public Out(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName); 
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

   
    public Out(String s) {
        try {
            OutputStream os = new FileOutputStream(s);
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName); 
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

  
    public void close() { out.close(); }



  
    public void println() {
        out.println();
    }

 
    public void println(boolean x) {
        out.println(x);
    }

    public void println(Object x) {
        out.println(x);
    }
  
    public void println(char x) {
        out.println(x);
    }

    public void println(double x) {
        out.println(x);
    }

  
    public void println(int x) {
        out.println(x);
    }

  
    public void println(long x) {
        out.println(x);
    }



    public void print() {
        out.flush();
    }

  
    public void print(Object x) {
        out.print(x);
        out.flush();
    }

    public void print(boolean x) {
        out.print(x);
        out.flush();
    }

  
    public void print(char x) {
        out.print(x);
        out.flush();
    }

    public void print(double x) {
        out.print(x);
        out.flush();
    }

    public void print(float x) {
        out.print(x);
        out.flush();
    }
    
    public void printf(String format, Object... args) {
        out.printf(format, args);
        out.flush();
    }


    public void print(int x) {
        out.print(x);
        out.flush();
    }

 
    public void print(long x) {
        out.print(x);
        out.flush();
    }
    
    public void println(float x) {
        out.println(x);
    }

  
    public static void main(String[] args) {
        Out out;
        String s; 

      
        out = new Out();
        out.println("Test 1");
        out.close();

        
        out = new Out("test.txt");
        out.println("Test 2");
        out.close();
    }

}


