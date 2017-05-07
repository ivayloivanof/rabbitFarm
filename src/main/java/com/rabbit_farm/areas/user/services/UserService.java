package com.rabbit_farm.areas.user.services;

import com.rabbit_farm.areas.user.entities.User;
import com.rabbit_farm.areas.user.exceptions.InvalidUserException;
import com.rabbit_farm.areas.user.exceptions.UserNotFoundException;
import com.rabbit_farm.areas.user.exceptions.UsersDbEmptyException;
import com.rabbit_farm.areas.user.model.binding.UserRegisterBindingModel;
import com.rabbit_farm.areas.user.model.view.UserEditViewModel;
import com.rabbit_farm.areas.user.model.view.UserInfoViewModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

	void createUser(UserRegisterBindingModel userRegisterBindingModel) throws InvalidUserException;

	List<UserEditViewModel> findAllUsers() throws UsersDbEmptyException;

	UserEditViewModel findUserById(Long id) throws UserNotFoundException;

	UserInfoViewModel findInfoForUserById(Long id) throws UserNotFoundException;

	void updateUser(UserRegisterBindingModel userRegisterBindingModel) throws UserNotFoundException;

	void deleteUserById(Long id) throws UserNotFoundException;

}
