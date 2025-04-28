package com.example;
import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            System.out.println("Connected to chat server");

            new Thread(new ReadTask(socket)).start();
            new Thread(new WriteTask(socket)).start();

        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
