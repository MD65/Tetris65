package fr.esiea.cours.Tetris;

import java.io.*;
import java.net.*;


public class Serveur implements Runnable {

	private ServeurFrame serveurFrame;

	private static final int PORT = 6666;

	private Thread thread;


public Serveur(ServeurFrame serveurFrame) {
	this.serveurFrame = serveurFrame;
	/* On thread le noyau du serveur de maniere a ce qu'il puisse */
	/* etre interrompu par le bouton annuler de la frame du serveur sans pour */
	/* autant empecher l'affichage de la frame du serveur. */
	thread = new Thread(this);
	serveurFrame.setThread(thread);
	thread.start();
}


public void run() {
	ServerSocket socketServeur;
	/* Initialisation du port: */
	try {
		socketServeur = new ServerSocket(PORT, 5);
	} catch (IOException e) {
		serveurFrame.setSocket(null);
		thread.stop();
		return;
	}
	Socket socket = null;
	/* Attente jusqu'à la connection d'un client. */
	try {
		socket = socketServeur.accept();
	} catch (IOException e) {
		socket = null;
	}
	/* On affecte le socket a la frame du serveur. */
	serveurFrame.setSocket(socket);
}
}