package com.mse.sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("Starting server");
		ServerSocket server = new ServerSocket(8089);
		Socket accept = server.accept();

		BufferedReader clientIn = new BufferedReader(new InputStreamReader(accept.getInputStream()));
		String readLine = clientIn.readLine();
		if (readLine.equals("Hello")) {
			System.out.println("The message was received");
			PrintWriter clientOut = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()), true);
			clientOut.println("Echo: " + new Date());
		}

		System.out.println("Client connected.");
		server.close();
	}

}
