package com.example;
import java.io.*;
import java.net.*;

public class ReadTask implements Runnable {
    private final BufferedReader reader;

    public ReadTask(Socket socket) throws IOException {
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String response;
        try {
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println("Disconnected from server.");
        }
    }
}
