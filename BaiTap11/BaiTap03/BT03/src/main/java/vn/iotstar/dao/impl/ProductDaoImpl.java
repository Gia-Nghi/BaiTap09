package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.Product;

public class ProductDaoImpl implements ProductDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(Product product) {

		String sql = "INSERT INTO Products " + "(product_name, description, price, images, cate_id, created_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getProductname());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getImages());
			ps.setInt(5, product.getCateID());
			ps.setDate(6, product.getCreatedDate());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Product product) {

		String sql = "UPDATE Products " + "SET product_name = ?, " + "description = ?, " + "price = ?, "
				+ "images = ?, " + "cate_id = ? " + "WHERE product_id = ?";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setString(1, product.getProductname());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getImages());
			ps.setInt(5, product.getCateID());
			ps.setInt(6, product.getId());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM Products WHERE product_id = ?";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product get(int id) {

		String sql = "SELECT * FROM Products WHERE product_id = ?";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				Product product = new Product();

				product.setId(rs.getInt("product_id"));
				product.setProductname(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setCateID(rs.getInt("cate_id"));
				product.setCreatedDate(rs.getDate("created_date"));

				return product;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Product> getAll() {

		List<Product> list = new ArrayList<>();

		String sql = "SELECT * FROM Products ORDER BY product_id DESC";

		try {
			conn = new DBConnection().getConnection();

			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Product product = new Product();

				product.setId(rs.getInt("product_id"));
				product.setProductname(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setCateID(rs.getInt("cate_id"));
				product.setCreatedDate(rs.getDate("created_date"));

				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Product> getTop10Products() {
		List<Product> products = new ArrayList<>();

		String sql = "SELECT TOP 10 * FROM Products ORDER BY created_date DESC";

		try {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getInt("product_id"));
				product.setProductname(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setImages(rs.getString("images"));
				product.setCateID(rs.getInt("cate_id"));
				product.setCreatedDate(rs.getDate("created_date"));

				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}
	
	@Override
	public List<Product> getProductsByPage(int page, int pageSize) {

	    List<Product> products = new ArrayList<>();

	    String sql = "SELECT * FROM Products "
	            + "ORDER BY product_id "
	            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	    try {
	        conn = new DBConnection().getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        int offset = (page - 1) * pageSize;

	        ps.setInt(1, offset);
	        ps.setInt(2, pageSize);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            Product product = new Product();

	            product.setId(rs.getInt("product_id"));
	            product.setProductname(rs.getString("product_name"));
	            product.setDescription(rs.getString("description"));
	            product.setPrice(rs.getDouble("price"));
	            product.setImages(rs.getString("images"));
	            product.setCateID(rs.getInt("cate_id"));
	            product.setCreatedDate(rs.getDate("created_date"));

	            products.add(product);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return products;
	}
	
	@Override
	public int countProducts() {

	    String sql = "SELECT COUNT(*) FROM Products";

	    try {

	        conn = new DBConnection().getConnection();

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
}