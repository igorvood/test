package ru.vood.infrastructureTest.entity.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vood.infrastructureTest.entity.DataClass;


public interface DataClassRepositoryJpa extends JpaRepository<DataClass, String> {
}
