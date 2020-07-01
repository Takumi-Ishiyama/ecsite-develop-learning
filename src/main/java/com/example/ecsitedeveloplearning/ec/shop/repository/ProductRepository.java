package com.example.ecsitedeveloplearning.ec.shop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecsitedeveloplearning.ec.shop.model.Category;
import com.example.ecsitedeveloplearning.ec.shop.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByCategoryId(Category category);
	
	@Modifying
	@Transactional
	@Query(value = "update products p set p.name = ?2 , p.category_id = ?3 , p.price = ?4 , p.description = ?5 , p.image_path = ?6 , updated = CURRENT_TIMESTAMP() where id = ?1", nativeQuery = true)
	void update(long id, String name, Integer categoryId , int price, String description, String imagePath);
}
