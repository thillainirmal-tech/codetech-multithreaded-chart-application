package com.example;
import java.io.*;
import java.net.*;

public class WriteTask implements Runnable {
    private final PrintWriter writer;
    private final BufferedReader consoleReader;

    public WriteTask(Socket socket) throws IOException {
        writer = new PrintWriter(socket.getOutputStream(), true);
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            String text;
            while ((text = consoleReader.readLine()) != null) {
                writer.println(text);
            }
        } catch (IOException e) {
            System.out.println("Error sending message to server.");
        }
    }
}
