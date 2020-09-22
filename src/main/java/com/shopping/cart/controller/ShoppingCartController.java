package com.shopping.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.cart.model.Product;

@RestController
@Configuration
@PropertySource(value = "classpath:application.properties")
public class ShoppingCartController {

	private static final Logger LOGGER = LogManager.getLogger(ShoppingCartController.class);

	@Value("#{'${products.details.name}'.split(',')}")
	private List<String> productNames;

	@Value("#{'${products.details.unit.price}'.split(',')}")
	private List<String> productPrices;

	@CrossOrigin
	@RequestMapping(value = "/listOfProducts", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> getProducts() {
		LOGGER.info("ShoppingCartController.getProducts() : Start");
		List<Product> products = new ArrayList<>();
		Product product = null;
		int index = 0;
		for (String name : productNames) {
			product = new Product();
			product.setProductName(name);
			product.setProductPrice(Integer.parseInt(productPrices.get(index)));
			index++;
			LOGGER.info("ShoppingCartController.getProducts() : Added Product ()", product.getProductName());
			products.add(product);
		}
		LOGGER.info("ShoppingCartController.getProducts() : End");
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@CrossOrigin
	@RequestMapping(value = "/submitCart", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> addProjects(@RequestBody List<Product> products) {
		System.out.println("Products are " + products);

		return ResponseEntity.status(HttpStatus.OK).body(products.get(0));
	}

	@CrossOrigin
	@RequestMapping(value = "/submitCartItem", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
					MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		System.out.println("Products are " + product);

		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
}
