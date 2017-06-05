package com.rabbit_farm.areas.rabbit.servicesImpl;

import com.rabbit_farm.areas.rabbit.entities.Rabbit;
import com.rabbit_farm.areas.rabbit.exceptions.InvalidRabbitException;
import com.rabbit_farm.areas.rabbit.exceptions.RabbitNotFoundException;
import com.rabbit_farm.areas.rabbit.exceptions.RabbitsDbEmptyException;
import com.rabbit_farm.areas.rabbit.models.binding.RabbitCreateBindingModel;
import com.rabbit_farm.areas.rabbit.models.binding.RabbitEditBindingModel;
import com.rabbit_farm.areas.rabbit.models.view.RabbitEditViewModel;
import com.rabbit_farm.areas.rabbit.repositories.RabbitRepository;
import com.rabbit_farm.areas.rabbit.services.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitServiceImpl implements RabbitService {

	private RabbitRepository rabbitRepository;

	@Autowired
	public RabbitServiceImpl(RabbitRepository rabbitRepository) {
		this.rabbitRepository = rabbitRepository;
	}

	@Override
	public void create(RabbitCreateBindingModel rabbitCreateBindingModel) throws InvalidRabbitException {

	}

	@Override
	public void update(RabbitEditBindingModel rabbitEditBindingModel) throws RabbitNotFoundException {

	}

	@Override
	public RabbitEditViewModel findRabbitById() throws RabbitNotFoundException {
		return null;
	}

	@Override
	public List<RabbitEditViewModel> findAllRabbits() throws RabbitsDbEmptyException {
		return null;
	}

	@Override
	public void delete(Rabbit rabbit) {

	}
}
