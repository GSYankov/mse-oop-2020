package com.mse.sockets.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8089);
		PrintWriter clientOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		BufferedReader clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		clientOut.println("Hello");
		String readLine = clientIn.readLine();
		System.out.println(readLine);
		socket.close();
	}

}
