package com.rabbit_farm.areas.user.servicesImpl;

import com.rabbit_farm.areas.role.entity.Role;
import com.rabbit_farm.areas.user.configurations.UserPayment;
import com.rabbit_farm.areas.user.entities.User;
import com.rabbit_farm.areas.user.enumerations.UserRole;
import com.rabbit_farm.areas.user.exceptions.InvalidUserException;
import com.rabbit_farm.areas.user.exceptions.UserNotFoundException;
import com.rabbit_farm.areas.user.exceptions.UsersDbEmptyException;
import com.rabbit_farm.areas.user.model.binding.UserRegisterBindingModel;
import com.rabbit_farm.areas.user.model.view.UserEditViewModel;
import com.rabbit_farm.areas.user.model.view.UserInfoViewModel;
import com.rabbit_farm.areas.user.repositories.UserRepository;
import com.rabbit_farm.areas.user.services.UserService;
import com.rabbit_farm.configurations.errors.UserErrors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void createUser(UserRegisterBindingModel userRegisterBindingModel) throws InvalidUserException {
		if(userRegisterBindingModel == null) {
			throw new InvalidUserException("User can't null!");
		}

		User user = this.modelMapper.map(userRegisterBindingModel, User.class);
		user.setRemuneration(new BigDecimal(UserPayment.WORKER_REMUNERATION));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);

		Role role = new Role();
		role.setAuthority(UserRole.WORKER.toString());
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);
		user.setAuthorities(roleSet);

		this.userRepository.save(user);
	}

	@Override
	public List<UserEditViewModel> findAllUsers() throws UsersDbEmptyException {
		List<User> users = this.userRepository.findAll();
		if (users.isEmpty()) {
			throw new UsersDbEmptyException("Users database is empty!");
		}

		List<UserEditViewModel> userEditViewModelList = new LinkedList<>();

		for (User user : users) {
			UserEditViewModel userEditViewModel = this.modelMapper.map(user, UserEditViewModel.class);
			userEditViewModelList.add(userEditViewModel);
		}

		return userEditViewModelList;
	}

	@Override
	public UserEditViewModel findUserById(Long id) throws UserNotFoundException {
		User user = this.userRepository.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException(String.format("User with id: %s - not found!", id));
		}

		UserEditViewModel userEditViewModel = this.modelMapper.map(user, UserEditViewModel.class);

		return userEditViewModel;
	}

	@Override
	public UserInfoViewModel findInfoForUserById(Long id) throws UserNotFoundException {
		User user = this.userRepository.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException(String.format("User with id: %s - not found!", id));
		}

		UserInfoViewModel userInfoViewModel = this.modelMapper.map(user, UserInfoViewModel.class);

		return userInfoViewModel;
	}

	@Override
	public void updateUser(UserRegisterBindingModel userRegisterBindingModel) throws UserNotFoundException {
		User user = this.modelMapper.map(userRegisterBindingModel, User.class);
		user.setRemuneration(new BigDecimal(UserPayment.WORKER_REMUNERATION));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);

		this.userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) throws UserNotFoundException {
		if (id == null) {
			throw new UserNotFoundException(String.format("User with id: %s, can not exist!", id));
		}

		this.userRepository.delete(id);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.findUserByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException(UserErrors.NOT_FOUND_USER);
		}

		return user;
	}
}
