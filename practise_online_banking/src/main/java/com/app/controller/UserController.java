package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojo.User;
import com.app.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency
	@Autowired
	private UserServiceImpl userService;

	public UserController() {
		System.out.println("In cnstru " + getClass().getName());
	}

	@GetMapping("/login")
	public String showHomePage() {
		System.out.println("in show login page");
		return "/user/login";
	}

	@PostMapping("/login")
	public String userAuthentic(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session) {
		System.out.println("in userAuthentic ");
		try {
			User user = userService.validateUser(email, password);
			session.setAttribute("user", user);
			session.setAttribute("message", "Login Successful!");
			return "redirect:/account/list";
		} catch (RuntimeException e) {
			e.printStackTrace();
			map.addAttribute("message", "Invalid email and password. Please try again!!");
			return "/user/login";
		}
	}

	@GetMapping("/reg_form")
	public String showRegisterForm(User u) {
		System.out.println("in reg form");
		return "/user/reg_form";
	}

	@PostMapping("/reg_form")
	public String processRegisterForm(User userDetails, RedirectAttributes flashMap, Model map) {
		try {
			String mesg = userService.userRegister(userDetails);
			flashMap.addFlashAttribute("message", mesg);
			System.out.println("user login --> Message - " + mesg);
			return "redirect:/user/login";
		} catch (RuntimeException e) {
			map.addAttribute("message", "Something wrong -  Error " + e.getMessage());
			return "/user/reg_form";
		}

	}

	@GetMapping("/logout")
	public String userLogout(HttpSession session, Model map, HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("in user's logout");
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		} else {
			map.addAttribute("details", session.getAttribute("user"));
			session.invalidate();
			resp.setHeader("refresh", "5;url=" + request.getContextPath());// /spring-mvc-boot
			return "/user/logout";
		}
	}

}
