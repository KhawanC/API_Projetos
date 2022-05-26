package com.api.API_Estacionamento.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.API_Estacionamento.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{

	boolean existsByPlacaVeiculo(String placaVeiculo);
	boolean existsByNumeroLugar(String numeroLugar);
	boolean existsByApartamentoAndBloco(String apartamento, String bloco);
}
