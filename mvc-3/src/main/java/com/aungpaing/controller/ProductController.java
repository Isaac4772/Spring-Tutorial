package com.aungpaing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aungpaing.FileUploadUtil;
import com.aungpaing.entities.Product;
import com.aungpaing.service.CategoryService;
import com.aungpaing.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private CategoryService cateService;

	@GetMapping("/products")
	public String home(Model model) {
		List<Product> productList = service.findAll();
		model.addAttribute("productList", productList);
		return "product-list";
	}

	@GetMapping("/products/add")
	public String goAddPage(Model model) {
		model.addAttribute("categoryList", cateService.findAll());
		return "product-add";
	}

	@PostMapping("/products/save")
	public String saveProduct(@ModelAttribute("product") Product product,
			@RequestParam("photo_file") MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());// admin.png

		if ((product.getId() == 0 || product.getId() != 0) && !fileName.equals("")) {
			product.setPhoto(fileName);
		}

		// save to db
		var saveProduct = service.save(product);
		// save photo
		if (!"".equals(fileName)) {
			String uploadDir = "upload-photos/" + saveProduct.getId(); // upload-photos/1
			FileUploadUtil.savePhoto(uploadDir, fileName, file);

		}
		return "redirect:/products";
	}

	@GetMapping("/products/edit/{id}")
	public String ediProduct(@PathVariable("id") int productId, Model model) {
		var product = service.findById(productId);

		model.addAttribute("categoryList", cateService.findAll());
		model.addAttribute("product", product);
		return "product-add";
	}

	@GetMapping("/products/delete/{id}")
	public String deleteProducts(@PathVariable("id") int id) {

		service.deleteById(id);
		return "redirect:/products";
	}

	@ModelAttribute
	public void assginDefaultModel(Model model) {
		model.addAttribute("page", "product");
		model.addAttribute("product", new Product());
	}

}
