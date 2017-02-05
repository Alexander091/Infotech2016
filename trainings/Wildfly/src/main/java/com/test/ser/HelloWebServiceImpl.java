package com.test.ser;

// таже аннотация, что и при описании интерфейса,
import javax.jws.WebService;

// но здесь используется с параметром endpointInterface,
// указывающим полное имя класса интерфейса нашего веб-сервиса
@WebService(endpointInterface = "com.test.ser.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    public String getHelloString(String name) {
        // просто возвращаем приветствие
        return "Hello, " + name + "!";
    }
}
