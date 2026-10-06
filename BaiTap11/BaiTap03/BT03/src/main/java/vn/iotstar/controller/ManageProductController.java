package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.Product;

@WebServlet("/manage-product")
public class ManageProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> productList = productDao.getAll();

        request.setAttribute("productList", productList);

        request.getRequestDispatcher("/views/admin/products/list.jsp")
               .forward(request, response);
    }
}