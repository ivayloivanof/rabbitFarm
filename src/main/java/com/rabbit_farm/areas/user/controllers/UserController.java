package com.rabbit_farm.areas.user.controllers;

import com.rabbit_farm.areas.user.entities.User;
import com.rabbit_farm.areas.user.model.binding.UserLoginBindingModel;
import com.rabbit_farm.areas.user.model.binding.UserRegisterBindingModel;
import com.rabbit_farm.areas.user.model.view.UserEditViewModel;
import com.rabbit_farm.areas.user.model.view.UserInfoViewModel;
import com.rabbit_farm.areas.user.services.UserService;
import com.rabbit_farm.configurations.address.PagesTitle;
import com.rabbit_farm.configurations.errors.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//TODO create tests for user

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/login")
	public String getLoginPage(Model model, @ModelAttribute UserLoginBindingModel userLoginBindingModel, @RequestParam(required = false) String error) {
		model.addAttribute("title", PagesTitle.USER_LOGIN_PAGE);

		if (error != null) {
			model.addAttribute("error", Errors.INVALID_LOGIN_CREDENTIALS);
		}

		return "user/login";
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model, @ModelAttribute UserRegisterBindingModel userRegisterBindingModel, @RequestParam(required = false) String error) {
		model.addAttribute("pageTitle", PagesTitle.USER_REGISTER_PAGE);

		if (error != null) {
			model.addAttribute("error", Errors.INVALID_REGISTER_CREDENTIALS);
		}

		return "user/register";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/register";
		}

		userRegisterBindingModel.setPassword(this.bCryptPasswordEncoder.encode(userRegisterBindingModel.getPassword()));

		this.userService.createUser(userRegisterBindingModel);

		return "redirect:/user/login";
	}

	@GetMapping("/edit/{id}")
	public String getEditUserPageById(@PathVariable(value = "id") Long id, Model model, @ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {
		model.addAttribute("title", PagesTitle.USER_EDIT_PAGE);
		model.addAttribute("userViewModel", getUserViewModel(id));

		return "user/edit";
	}

	@PostMapping("/edit/{id}")
	public String editUserById(@PathVariable(value = "id") Long id, Model model, @Valid @ModelAttribute UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("pageTitle", PagesTitle.USER_EDIT_PAGE);
			model.addAttribute("userViewModel", getUserViewModel(id));

			return "user/user-edit";
		}

		userRegisterBindingModel.setPassword(this.bCryptPasswordEncoder.encode(userRegisterBindingModel.getPassword()));

		this.userService.updateUser(userRegisterBindingModel);

		return "redirect:/user/info";
	}

	@GetMapping("/info")
	public String getInfoUserPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();

		model.addAttribute("title", PagesTitle.USER_INFO_PAGE);
		model.addAttribute("userInfoViewModel", getUserInfoViewModel(user.getId()));

		return "user/info";
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteUser(@PathVariable(value = "id") Long id) {
		this.userService.deleteUserById(id);

		return "redirect:/logout";
	}

	@GetMapping("/logout")
	public String logoutUser( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
		}

		HttpSession session = httpServletRequest.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		Cookie[] cookies = httpServletRequest.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			httpServletResponse.addCookie(cookie);
		}

		return "redirect:/user/login?logout";
	}

	private UserEditViewModel getUserViewModel(Long id) {
		UserEditViewModel userViewModel = this.userService.findUserById(id);

		return userViewModel;
	}

	private UserInfoViewModel getUserInfoViewModel(Long id) {
		UserInfoViewModel userViewModel = this.userService.findInfoForUserById(id);

		return userViewModel;
	}

}