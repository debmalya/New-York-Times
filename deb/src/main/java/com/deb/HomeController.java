package com.deb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deb.model.Categories;
import com.deb.model.CategoryDetails;
import com.deb.service.NewYorkTimesImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private static Categories categories = null;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		if (categories == null) {
			categories = new NewYorkTimesImpl().listCategories();
		}

		if (categories != null) {
			model.addAttribute("categories", categories.getCategoryList());
		}
		model.addAttribute("categoryDetails", new ArrayList<CategoryDetails>());
		return "home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String getDetails(Locale locale, Model model,
			@RequestParam("nyt_categories") String nyt_categories) {
		// Get selected category

		System.out.println("Categeory " + nyt_categories);

		if (categories == null) {
			categories = new NewYorkTimesImpl().listCategories();
		}
		model.addAttribute("categories", categories.getCategoryList());

		if (nyt_categories != null && nyt_categories.trim().length() > 0) {
			List<CategoryDetails> categoryDetails = new NewYorkTimesImpl()
					.listCategoryDetails(nyt_categories);
			if (categoryDetails != null) {
				model.addAttribute("categoryDetails", categoryDetails);
			} else{
				model.addAttribute("categoryDetails", new ArrayList<CategoryDetails>());
			}
		} else {
			model.addAttribute("categoryDetails", new ArrayList<CategoryDetails>());
		}

		return "home";
	}

}
