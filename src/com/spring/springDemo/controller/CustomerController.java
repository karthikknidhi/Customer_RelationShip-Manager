package com.spring.springDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.springDemo.entity.Customer;
import com.spring.springDemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCusomer(Model theModel){
		
		
		List<Customer> custom = customerService.getCustomer();
		theModel.addAttribute("customers",custom);
		
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model themodel){
		
		themodel.addAttribute("customer", new Customer());
		return "Cutomer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer thecustomer){
		
		
		customerService.saveCustomer(thecustomer);
		
		return "redirect:/customer/list";

	}
	
	
	@GetMapping("/showUpdate")
	public String showformupdate(@RequestParam("customerId")int id,Model model){
		
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer",customer);
		
		return "Cutomer-form";
	}
	
	@GetMapping("/delete")
	public String showfordelete(@RequestParam("customerId")int id){
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
	
}