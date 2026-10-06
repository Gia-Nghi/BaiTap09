package vn.iotstar.controller;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.Product;

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/views/admin/products/add.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String productname = request.getParameter("productname");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String images = request.getParameter("images");
        int cateID = Integer.parseInt(request.getParameter("cateID"));

        Product product = new Product();

        product.setProductname(productname);
        product.setDescription(description);
        product.setPrice(price);
        product.setImages(images);
        product.setCateID(cateID);

        product.setCreatedDate(
            new Date(System.currentTimeMillis())
        );

        productDao.insert(product);

        response.sendRedirect(
            request.getContextPath() + "/manage-product"
        );
    }
}