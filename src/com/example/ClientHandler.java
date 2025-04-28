package com.example;
import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            setupStreams();
            requestUsername();
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(username + ": " + message);
                Server.broadcast(username + ": " + message, this);
            }
        } catch (IOException e) {
            System.err.println("Client communication error: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void setupStreams() throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void requestUsername() throws IOException {
        out.println("Enter your username:");
        username = in.readLine();
        System.out.println("User joined: " + username);
        Server.broadcast("[" + username + "] has joined the chat!", this);
    }

    public void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    private void closeConnection() {
        try {
            Server.broadcast("[" + username + "] has left the chat.", this);
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
            System.err.println("Error closing client resources: " + e.getMessage());
        }
        Server.removeClient(this);
    }
}
