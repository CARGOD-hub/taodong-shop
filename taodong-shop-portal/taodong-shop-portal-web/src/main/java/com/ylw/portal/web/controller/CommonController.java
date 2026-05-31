package com.ylw.portal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommonController {

	private List<Map<String, Object>> getMockProducts() {
		List<Map<String, Object>> products = new ArrayList<>();
		Map<String, Object> p1 = new HashMap<>();
		p1.put("id", 1);
		p1.put("name", "泰国进口山竹2KG");
		p1.put("subtitle", "新鲜直达，口感丰富");
		p1.put("mainImage", "../res/static/img/hot_sale1.jpg");
		p1.put("price", 149.90);
		p1.put("detail", "泰国进口山竹，精选大果，果肉饱满，酸甜可口，营养丰富。");
		products.add(p1);

		Map<String, Object> p2 = new HashMap<>();
		p2.put("id", 2);
		p2.put("name", "虾仁胡萝卜口味300g");
		p2.put("subtitle", "新鲜虾仁，营养美味");
		p2.put("mainImage", "../res/static/img/hot_sale2.jpg");
		p2.put("price", 22.90);
		p2.put("detail", "精选虾仁搭配胡萝卜，营养均衡，美味可口。");
		products.add(p2);

		Map<String, Object> p3 = new HashMap<>();
		p3.put("id", 3);
		p3.put("name", "泰国山竹5A级新鲜水果");
		p3.put("subtitle", "5A级品质，新鲜直达");
		p3.put("mainImage", "../res/static/img/hot_sale3.jpg");
		p3.put("price", 69.90);
		p3.put("detail", "泰国5A级山竹，果肉雪白，口感细腻，甜中带酸。");
		products.add(p3);

		Map<String, Object> p4 = new HashMap<>();
		p4.put("id", 4);
		p4.put("name", "澳洲M12+纯种肉眼牛排");
		p4.put("subtitle", "进口牛肉，品质保证");
		p4.put("mainImage", "../res/static/img/hot_sale4.jpg");
		p4.put("price", 798.00);
		p4.put("detail", "澳洲进口M12+级别肉眼牛排，雪花分布均匀，口感鲜嫩多汁。");
		products.add(p4);

		Map<String, Object> p5 = new HashMap<>();
		p5.put("id", 5);
		p5.put("name", "烟台红富士苹果");
		p5.put("subtitle", "脆甜多汁");
		p5.put("mainImage", "../res/static/img/hot_new1.jpg");
		p5.put("price", 36.80);
		p5.put("detail", "烟台红富士苹果，果实饱满，色泽鲜艳，口感清脆甘甜。");
		products.add(p5);

		Map<String, Object> p6 = new HashMap<>();
		p6.put("id", 6);
		p6.put("name", "四川春见粑粑柑");
		p6.put("subtitle", "皮薄多汁");
		p6.put("mainImage", "../res/static/img/hot_new2.jpg");
		p6.put("price", 38.80);
		p6.put("detail", "四川春见粑粑柑，皮薄肉嫩，汁水丰富，酸甜可口。");
		products.add(p6);

		Map<String, Object> p7 = new HashMap<>();
		p7.put("id", 7);
		p7.put("name", "海南小台农芒果");
		p7.put("subtitle", "香甜浓郁");
		p7.put("mainImage", "../res/static/img/hot_new3.jpg");
		p7.put("price", 26.80);
		p7.put("detail", "海南小台农芒果，果肉细腻，甜度高，香气浓郁。");
		products.add(p7);

		Map<String, Object> p8 = new HashMap<>();
		p8.put("id", 8);
		p8.put("name", "进口大把香蕉2kg装");
		p8.put("subtitle", "新鲜进口");
		p8.put("mainImage", "../res/static/img/hot_new4.jpg");
		p8.put("price", 28.80);
		p8.put("detail", "进口大把香蕉，果肉饱满，口感香甜，富含钾元素。");
		products.add(p8);

		return products;
	}

	private Map<String, Object> getMockProduct(Integer id) {
		List<Map<String, Object>> products = getMockProducts();
		for (Map<String, Object> product : products) {
			if (product.get("id").equals(id)) {
				return product;
			}
		}
		return products.get(0);
	}

	@RequestMapping("/usershop")
	public String usershop(HttpSession session) {
		List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		return "usershop";
	}

	@RequestMapping("/usershop.html")
	public String usershopHtml(HttpSession session) {
		return usershop(session);
	}

	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Integer productId, @RequestParam("quantity") Integer quantity, HttpSession session) {
		Map<String, Object> product = getMockProduct(productId);
		if (product != null) {
			List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
			if (cart == null) {
				cart = new ArrayList<>();
			}
			boolean found = false;
			for (Map<String, Object> item : cart) {
				if (item.get("productId").equals(productId)) {
					item.put("quantity", (Integer) item.get("quantity") + quantity);
					found = true;
					break;
				}
			}
			if (!found) {
				Map<String, Object> newItem = new HashMap<>();
				newItem.put("productId", productId);
				newItem.put("name", product.get("name"));
				newItem.put("price", product.get("price"));
				newItem.put("image", product.get("mainImage"));
				newItem.put("quantity", quantity);
				cart.add(newItem);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/usershop";
	}

	@RequestMapping("/list.html")
	public String list(Model model) {
		model.addAttribute("productList", getMockProducts());
		return "list";
	}

	@RequestMapping("/detail.html")
	public String detail(Model model, @RequestParam(name = "id", required = false) Integer id) {
		if (id == null) {
			id = 1;
		}
		model.addAttribute("product", getMockProduct(id));
		return "detail";
	}

	@GetMapping("/detail/{id}")
	public String detailById(Model model, @PathVariable("id") Integer id) {
		return detail(model, id);
	}

	@RequestMapping("/order")
	public String order(Model model, HttpSession session) {
		List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<>();
		}
		double total = 0;
		for (Map<String, Object> item : cart) {
			total += (Double) item.get("price") * (Integer) item.get("quantity");
		}
		model.addAttribute("total", total);
		return "order";
	}

	@RequestMapping("/service")
	public String service(Model model) {
		return "service";
	}
}
