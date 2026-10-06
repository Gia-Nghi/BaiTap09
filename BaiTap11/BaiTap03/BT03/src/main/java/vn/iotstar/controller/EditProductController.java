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

@WebServlet("/edit-product")
public class EditProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Product product = productDao.get(id);

        request.setAttribute("product", product);

        request.getRequestDispatcher(
                "/views/admin/products/edit.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        String productname = request.getParameter("productname");

        String description = request.getParameter("description");

        double price = Double.parseDouble(
                request.getParameter("price")
        );

        String images = request.getParameter("images");

        int cateID = Integer.parseInt(
                request.getParameter("cateID")
        );

        Product product = new Product();

        product.setId(id);

        product.setProductname(productname);

        product.setDescription(description);

        product.setPrice(price);

        product.setImages(images);

        product.setCateID(cateID);

        productDao.update(product);

        response.sendRedirect(
                request.getContextPath() + "/manage-product"
        );
    }
}