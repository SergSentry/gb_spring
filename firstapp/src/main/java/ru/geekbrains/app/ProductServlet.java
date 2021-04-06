package ru.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.printf("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<head><title>Products</title></head>\n"
                + "<body>\n");
        out.printf("<h1>Products</h1>\n");
        out.printf("<p>Automatically generated products</p>\n");
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i + 1, String.format("Product - %d", i), 1.5f * (i + 1));

            out.printf("<div>");
            out.printf("<p>");
            out.printf(product.toString());
            out.printf("</p>");
            out.printf("</div>");
        }
        out.printf("</body>\n</html>");
    }
}
