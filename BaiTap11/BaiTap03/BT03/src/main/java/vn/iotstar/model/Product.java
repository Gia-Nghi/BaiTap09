package vn.iotstar.model;

import java.sql.Date;

public class Product {

	private int id;
	private String productname;
	private String description;
	private double price;
	private String images;
	private int cateID;
	private Date createdDate;

	public Product() {
		super();
	}

	public Product(int id, String productname, String description, double price, String images, int cateID,
			Date createdDate) {

		this.id = id;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.images = images;
		this.cateID = cateID;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}