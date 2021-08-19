package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojo.Account;
import com.app.pojo.Type;
import com.app.pojo.User;
import com.app.service.AccountService;

@Controller
@RequestMapping("/account")
public class AcccountController {
	// dependency
	@Autowired
	private AccountService accService;

	@GetMapping("list")
	public String showAccList(HttpSession session, Model map) {
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		} else {
			User user = (User) session.getAttribute("user");
			map.addAttribute("details", session.getAttribute("user"));
			try {
				System.out.println("in account list try");
				map.addAttribute("acc_list", accService.allAccount(user.getUser_id()));
			} catch (RuntimeException e) {
				System.out.println("in account list catch");
				map.addAttribute("message", "Something Wrong - No data Found");
			}
			return "/account/list";
		}
	}

	@PostMapping("/list")
	public String processAfterClickOnDepositeWithdrowClose(@RequestParam String submit,
			@RequestParam(name = "acc_id") int accId, @RequestParam double amount, HttpSession session, Model map,
			RedirectAttributes flashMap) {
		System.out.println("in withdrow, deposite, close acc process " + submit);
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		} else {
			try {
				if (submit.equals("Withdraw")) {
					flashMap.addFlashAttribute("message", accService.withdrawAmount(accId, amount));
					return "redirect:/account/list";
				} else if (submit.equals("Deposite")) {
					flashMap.addFlashAttribute("message", accService.depositeAmount(accId, amount));
					return "redirect:/account/list";
				} else if (submit.equals("Close Account")) {
					flashMap.addFlashAttribute("message", accService.closeAccount(accId));
					return "redirect:/account/list";
				} else {
					System.out.println("invalid submit value");
					flashMap.addFlashAttribute("message", "Something wrong - invalid submit value");
					return "redirect:/account/list";
				}
			} catch (RuntimeException e) {
				System.out.println("error " + e);
				flashMap.addFlashAttribute("message", "Something wrong - process not completed! " + e);
				return "redirect:/account/list";
			}
		}
	}

	@GetMapping("/create_acc")
	public String showCreateAccForm(Model map, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/user/login";
		} else {
			List<Type> list = accService.fetchAccType();
			map.addAttribute("acc_type", list);
			System.out.println("in create acc show " + list);
			return "/account/create_acc";
		}
	}

	@PostMapping("/create_acc")
	public String createAccount(@RequestParam String type, @RequestParam double balance, Model map, HttpSession session,
			RedirectAttributes flashMap) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/user/login";
		} else {
			try {
				flashMap.addFlashAttribute("message", accService.createAcc(user, type, balance));
				return "redirect:/account/list";
			} catch (RuntimeException e) {
				map.addAttribute("message", e);
				return "/account/create_acc";
			}
		}
	}
}
