package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.Product;

@WebServlet(urlPatterns = {"/product-detail"})
public class ProductDetailController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productDao.get(id);

        request.setAttribute("product", product);

        request.getRequestDispatcher("/views/product-detail.jsp")
               .forward(request, response);
    }
}