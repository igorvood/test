package ru.tora.generatedEntity.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tora.generatedEntity.entity.ZTypeAdressEntity;


/* Репозиторий для таблицы БД - Типы адресов */
interface ZTypeAdressRepository : JpaRepository<ZTypeAdressEntity, BigDecimal>{
}
