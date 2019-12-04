package com.example.ecsitedeveloplearning.ec.shop.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	// Databaseの Productsテーブルと連携するため Entity設定必要
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categoryId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "imagePath")
	private String imagePath;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = true)
	private Date updated;

}
