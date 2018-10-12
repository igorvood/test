package ru.tora.generatedEntity.repository;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tora.generatedEntity.entity.ZClientOrgEntity;


/* Репозиторий для таблицы БД - Юридические лица */
interface ZClientOrgRepository : JpaRepository<ZClientOrgEntity, BigDecimal>{
}
