package fr.esiea.cours.Tetris;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket; 

public class Client {
	
	private static final int PORT = 6666;
	
	public static Socket getSocket(String hostname) {
   		
	
		Socket socket = null ;
		try{
			socket = new Socket(InetAddress.getByName(hostname), PORT);
		    } 
		    catch (IOException error) {
			socket = null;
			}
		    return socket;
                                                    }
}

