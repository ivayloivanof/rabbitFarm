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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RabbitServiceImpl implements RabbitService {

	private RabbitRepository rabbitRepository;
	private ModelMapper modelMapper;

	@Autowired
	public RabbitServiceImpl(RabbitRepository rabbitRepository, ModelMapper modelMapper) {
		this.rabbitRepository = rabbitRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public void create(RabbitCreateBindingModel rabbitCreateBindingModel) throws InvalidRabbitException {
		if (rabbitCreateBindingModel == null) {
			throw new InvalidRabbitException("Rabbit can not be NULL!");
		}

		Rabbit rabbit = this.modelMapper.map(rabbitCreateBindingModel, Rabbit.class);

		this.rabbitRepository.save(rabbit);
	}

	@Override
	public void update(RabbitEditBindingModel rabbitEditBindingModel) throws RabbitNotFoundException {
		if (rabbitEditBindingModel == null) {
			throw new InvalidRabbitException("Rabbit not found!");
		}

		Rabbit rabbit = this.modelMapper.map(rabbitEditBindingModel, Rabbit.class);

		this.rabbitRepository.save(rabbit);
	}

	@Override
	public RabbitEditViewModel findRabbitById(Long id) throws RabbitNotFoundException {
		if (id == null) {
			throw new RabbitNotFoundException("Rabbit not foud in database!");
		}

		Rabbit rabbit = this.rabbitRepository.findRabbitById(id);
		RabbitEditViewModel rabbitEditViewModel = this.modelMapper.map(rabbit, RabbitEditViewModel.class);

		return rabbitEditViewModel;
	}

	@Override
	public List<RabbitEditViewModel> findAllRabbits() throws RabbitsDbEmptyException {
		List<Rabbit> rabbits = this.rabbitRepository.findAll(new Sort(Sort.Direction.ASC));
		List<RabbitEditViewModel> rabbitEditViewModel = new LinkedList<>();

		for (Rabbit rabbit : rabbits) {
			rabbitEditViewModel.add(this.modelMapper.map(rabbit, RabbitEditViewModel.class));
		}

		return rabbitEditViewModel;
	}

	@Override
	public void delete(RabbitEditViewModel rabbitEditViewModel) {
		if (rabbitEditViewModel == null) {
			throw new InvalidRabbitException("Rabbit can not be NULL!");
		}

		Rabbit rabbit = this.modelMapper.map(rabbitEditViewModel, Rabbit.class);

		this.rabbitRepository.delete(rabbit);
	}
}
