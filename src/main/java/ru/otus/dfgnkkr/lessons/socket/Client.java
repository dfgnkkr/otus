package ru.otus.dfgnkkr.lessons.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * клиент подключается к серверу, получает строку с доступными мат. операциями. Отображает ее пользователю.
 * пользователь вводит два числа и команду в консоль
 * отправляется запрос на сервер, сервер выполняет вычисления, возвращает результат клиенту.
 * клиент отображает результат в консоль
 */
public class Client{
    private DataInputStream in;
    private DataOutputStream out;

    public Client(InputStream in, OutputStream out) {
        this.in = new DataInputStream(new BufferedInputStream(in));
        this.out = new DataOutputStream(new BufferedOutputStream(out));
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Сервер выполняет математические вычисления: +,-,*,/. Далее потребуется 2 числа и символ для операции.");
        System.out.println("Символ для операции: ");
        String operation = scanner.nextLine();
        System.out.println("a = ");
        int a = scanner.nextInt();
        System.out.println("b = ");
        int b = scanner.nextInt();
        String message = a + operation + b;
        System.out.println("Полученное выражение: " + message);
        byte[] bytes = message.getBytes();

        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 8088)) {
                Client client = new Client(socket.getInputStream(), socket.getOutputStream());
                client.send(bytes);
                new Thread(() -> {
                    while (true) {
                        String answer = null;
                        try {
                            answer = client.in.readLine();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
//                     reader.readLine();
                        System.out.println("Получен ответ: " + answer);
                    }
                }).start();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


//        new Thread(() -> {
//            try (Socket socket = new Socket("localhost", 8088)) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                while (true) {
//                    String answer = reader.readLine();
//                    System.out.println("Получен ответ: " + answer);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    public void send(byte[] bytes) throws IOException {
        out.write(bytes);
        out.flush();
    }
}
