package com.mse.sockets.chat.client;

public class StartClient2{
	public static void main(String[] args) {
	System.out.println("Starting client 2");
	Client client1 = new Client("localhost",8089);
	client1.execute();
	
	Client client2 = new Client("localhost",8089);
	client2.execute();

}
}