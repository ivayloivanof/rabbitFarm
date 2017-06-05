package com.rabbit_farm.areas.rabbit.repositories;

import com.rabbit_farm.areas.rabbit.entities.Rabbit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabbitRepository extends JpaRepository<Rabbit, Long> {

}
