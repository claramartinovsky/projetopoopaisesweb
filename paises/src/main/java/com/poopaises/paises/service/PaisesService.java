package com.poopaises.paises.service;

import com.poopaises.paises.entity.ContinentEntity;
import com.poopaises.paises.entity.PaisesEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaisesService {
    private final List<PaisesEntity> paisesList;


    public PaisesService() {
        paisesList = new ArrayList<>();
        paisesList.add(new PaisesEntity("Brasil", "Brasília", ContinentEntity.AMERICA_SUL, "/images/brasil.png"));
        paisesList.add(new PaisesEntity("Japão", "Tóquio", ContinentEntity.ASIA, "/images/japao.png"));
        paisesList.add(new PaisesEntity("África do Sul", "Pretória", ContinentEntity.AFRICA, "/images/africadosul.png"));
        paisesList.add(new PaisesEntity("Alemanha", "Berlim", ContinentEntity.EUROPA, "/images/alemanha.png"));
        paisesList.add(new PaisesEntity("Butão", "Thimphu", ContinentEntity.ASIA, "/images/butao.png"));
        paisesList.add(new PaisesEntity("Chile", "Santiago", ContinentEntity.AMERICA_SUL, "/images/chile.png"));
        paisesList.add(new PaisesEntity("China", "Pequim", ContinentEntity.ASIA, "/images/china.png"));
        paisesList.add(new PaisesEntity("Austria", "Viena", ContinentEntity.OCEANIA, "/images/austria.png"));
        paisesList.add(new PaisesEntity("Grécia", "Atenas", ContinentEntity.EUROPA, "/images/grecia.png"));
        paisesList.add(new PaisesEntity("Estados Unidos", "Washington, D.C.", ContinentEntity.AMERICA_NORTE, "/images/eua.png"));
    }
        public List<PaisesEntity> getAllPaises(String sortBy, ContinentEntity filterByContinent) {
        return paisesList.stream()
                .filter(p -> filterByContinent == null || p.getContinent() == filterByContinent)
                .sorted(getComparator(sortBy))
                .collect(Collectors.toList());
    }

    private Comparator<PaisesEntity> getComparator(String sortBy) {
        if (sortBy == null) return Comparator.comparing(PaisesEntity::getName);
        return switch (sortBy) {
            case "capital" -> Comparator.comparing(PaisesEntity::getCapital);
            case "continent" -> Comparator.comparing(p -> p.getContinent().name());
            default -> Comparator.comparing(PaisesEntity::getName);
        };
    }

    public ContinentEntity[] getAllContinents() {
        return ContinentEntity.values();
    }
}
