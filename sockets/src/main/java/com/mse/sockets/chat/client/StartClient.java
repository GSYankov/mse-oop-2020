package com.mse.sockets.chat.client;

public class StartClient{
	public static void main(String[] args) {
	Client client = new Client("localhost",8089);
	client.execute();

}
}