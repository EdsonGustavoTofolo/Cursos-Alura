package br.com.alura.http;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Object data) {
        System.out.println("Realizando post atraves da biblioteca Java....");
    }
}
