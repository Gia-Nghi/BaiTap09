package vn.iotstar.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.model.Category;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.util.Constant;

import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = { "/admin/category/add" })

public class CategoryAddController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = DiskFileItemFactory.builder().get();

		JakartaServletFileUpload<DiskFileItem, DiskFileItemFactory> servletFileUpload = new JakartaServletFileUpload<>(
				diskFileItemFactory);

		servletFileUpload.setHeaderCharset(StandardCharsets.UTF_8);
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");

			List<DiskFileItem> items = servletFileUpload.parseRequest(req);

			for (DiskFileItem item : items) {

				if (item.getFieldName().equals("name")) {

					category.setName(item.getString(StandardCharsets.UTF_8));

				} else if (item.getFieldName().equals("icon")) {

					if (item.getSize() > 0) {

						String originalFileName = item.getName();

						int index = originalFileName.lastIndexOf(".");

						String ext = originalFileName.substring(index + 1);

						String fileName = System.currentTimeMillis() + "." + ext;

						File file = new File(Constant.DIR + "/category/" + fileName);

						item.write(file.toPath());

						category.setIcon("category/" + fileName);
					}
				}
			}

			cateService.insert(category);

			resp.sendRedirect(req.getContextPath() + "/admin/category/list");

		} catch (FileUploadException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
