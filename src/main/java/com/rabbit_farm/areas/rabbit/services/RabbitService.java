package com.rabbit_farm.areas.rabbit.services;

import com.rabbit_farm.areas.rabbit.entities.Rabbit;
import com.rabbit_farm.areas.rabbit.exceptions.InvalidRabbitException;
import com.rabbit_farm.areas.rabbit.exceptions.RabbitNotFoundException;
import com.rabbit_farm.areas.rabbit.exceptions.RabbitsDbEmptyException;
import com.rabbit_farm.areas.rabbit.models.binding.RabbitCreateBindingModel;
import com.rabbit_farm.areas.rabbit.models.binding.RabbitEditBindingModel;
import com.rabbit_farm.areas.rabbit.models.view.RabbitEditViewModel;

import java.util.List;

public interface RabbitService {

	void create(RabbitCreateBindingModel rabbitCreateBindingModel) throws InvalidRabbitException;

	void update(RabbitEditBindingModel rabbitEditBindingModel)  throws RabbitNotFoundException;

	RabbitEditViewModel findRabbitById() throws RabbitNotFoundException;

	List<RabbitEditViewModel> findAllRabbits() throws RabbitsDbEmptyException;

	void delete(Rabbit rabbit);
}
