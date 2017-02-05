package com.test.endpoint;

// класс, для запуска веб-сервера с веб-сервисами
import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса
import com.test.ser.HelloWebServiceImpl;

public class HelloWebServicePublisher {

    public static void main(String... args) {
        // запускаем веб-сервер на порту 8080
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:8080/wss/hello", new HelloWebServiceImpl());
    }
}
