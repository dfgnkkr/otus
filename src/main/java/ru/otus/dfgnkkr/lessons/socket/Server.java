package ru.otus.dfgnkkr.lessons.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private DataInputStream in;
    private DataOutputStream out;

    public Server(InputStream in, OutputStream out) {
        this.in = new DataInputStream(new BufferedInputStream(in));
        this.out = new DataOutputStream(new BufferedOutputStream(out));
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);

        new Thread(() -> {
            while (true) {
                Socket client = null;
                try {
                    client = serverSocket.accept();
                    new Server(client.getInputStream(), client.getOutputStream());
                    System.out.println("Client connected");
                    readRequest(client);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private static Integer readRequest(Socket client) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while(true) {
            String msg = reader.readLine();
            if(msg == null || msg.trim().isEmpty()) {
                continue;
            }

            System.out.println("Получена формула: " + msg);
            String a = "";
            String b = "";
            Integer result = 0;

            if (msg.contains("+")){
                a = msg.substring(0, msg.indexOf("+"));
                b = msg.substring(msg.indexOf("+") + 1, msg.length());
                result = Integer.parseInt(a) + Integer.parseInt(b);
            } else if (msg.contains("-")) {
                a = msg.substring(0, msg.indexOf("-"));
                b = msg.substring(msg.indexOf("-") + 1, msg.length());
                result = Integer.parseInt(a) - Integer.parseInt(b);
            } else if (msg.contains("*")) {
                a = msg.substring(0, msg.indexOf("*"));
                b = msg.substring(msg.indexOf("*") + 1, msg.length());
                result = Integer.parseInt(a) * Integer.parseInt(b);
            } else if (msg.contains("/")) {
                a = msg.substring(0, msg.indexOf("/"));
                b = msg.substring(msg.indexOf("/") + 1, msg.length());
                result = Integer.parseInt(a) / Integer.parseInt(b);
            }
            System.out.println("Результат выполнения: " + result);

            // сработает ваще?
            client.getOutputStream().write(String.valueOf(result).getBytes());
            client.getOutputStream().flush();

            return result;
        }
    }
}
