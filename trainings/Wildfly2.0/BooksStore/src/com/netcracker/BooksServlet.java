package com.netcracker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BooksServlet extends HttpServlet {

    public List<Book> bookList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * Здесь подразумевается, что книги мы получили
         * из БД, а потом добавили в список
         */


        bookList.add(new Book(1, "Philosophy of Java"));
        bookList.add(new Book(2, "Bible"));                         /*подготовили данные*/
        bookList.add(new Book(3, "Math for student"));
        bookList.add(new Book(4, "C# for beginners"));

        req.setAttribute("booksList", bookList);                    /*добавили их в запрос*/

        /**
         * теперь чтобы связать наш сервлет с JSP
         * нужно создать контекст и указать путь до
         * JSP
         */

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);      /*передали в JSP*/

        /**
         * таким образом, иы указываем 1) кому мы передаем данные
         * (другому сервлету JSP)
         * 2) мы указываем параметры теже что и получаем
         * в этом сервлете, resp - ответ, возвращаемый в браузер
         * req - запрос
         */





    }
}
