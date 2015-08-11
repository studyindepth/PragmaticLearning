package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Piles {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        new Thread(() -> {
            try {
                output.write("output from writer".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                int data;
                while ((data = input.read()) != -1) {
                    System.out.println((char) data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
