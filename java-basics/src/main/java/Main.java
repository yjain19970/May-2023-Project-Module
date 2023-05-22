import httpClient.Client;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Client c = new Client();
        System.out.println("Hello world!");

        System.out.println("Calling Example.com " + c.run("https://example.com/"));
    }
}
