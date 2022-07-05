package br.com.alura.http;

public class ApacheHttpClient implements HttpAdapter {
    @Override
    public void post(String url, Object data) {
        System.out.println("Realizando post atraves da biblioteca do Apache...");
    }
}
