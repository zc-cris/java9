package com.cris.java;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @ClassName TestHttp
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class TestHttp {

    // jdk 9 使用全新的HttpClient 来代替原来的HttpURLConnection
    public static void main(String[] args) {

        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.atguigu.com")).GET().build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandler.asString());

            System.out.println(response.statusCode());
            System.out.println(response.version().name());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
