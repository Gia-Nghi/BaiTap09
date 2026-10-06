package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.util.Constant;

@WebServlet("/image")
public class DownloadImageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fileName = req.getParameter("fname");

		if (fileName == null || fileName.isEmpty()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		File file = new File(Constant.DIR, fileName);

		if (!file.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String contentType = Files.probeContentType(file.toPath());

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		resp.setContentType(contentType);
		resp.setContentLengthLong(file.length());

		Files.copy(file.toPath(), resp.getOutputStream());
	}
}