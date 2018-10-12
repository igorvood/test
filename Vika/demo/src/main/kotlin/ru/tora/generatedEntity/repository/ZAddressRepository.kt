package ru.tora.generatedEntity.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tora.generatedEntity.entity.ZAddressEntity;


/* Репозиторий для таблицы БД - Адреса */
interface ZAddressRepository : JpaRepository<ZAddressEntity, BigDecimal>{
}
