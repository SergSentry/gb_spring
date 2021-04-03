package ru.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i + 1, String.format("Product - %d", i), 1.5f * (i + 1));

            resp.getWriter().printf("<div>");
            resp.getWriter().printf("<p>");
            resp.getWriter().printf(product.toString());
            resp.getWriter().printf("</p>");
            resp.getWriter().printf("</div>");
        }
        resp.getWriter().printf("</html></body>");
    }

    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Log: POST");
        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
    }*/
}
