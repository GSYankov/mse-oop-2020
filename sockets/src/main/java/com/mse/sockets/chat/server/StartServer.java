package com.mse.sockets.chat.server;

public class StartServer {
	public static void main(String[] args) {
	Server server = new Server(8089);
	server.execute();
}}
