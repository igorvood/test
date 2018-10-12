package ru.tora.generatedEntity.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tora.generatedEntity.entity.ZClientEntity;


/* Репозиторий для таблицы БД - Клиенты */
interface ZClientRepository : JpaRepository<ZClientEntity, BigDecimal>{
}
