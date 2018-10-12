package ru.tora.generatedEntity.editor;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tora.generatedEntity.entity.ZClientEntity;
import ru.tora.generatedEntity.service.ZClientService;
import ru.vood.amdWeb.util.abstraction.AbstractEditorKT;


@SpringComponent
@UIScope
/* Редактор для таблицы БД - Клиенты */
class ZClientEditor : AbstractEditorKT<ZClientEntity, ZClientService>{
@Autowired
constructor(zClientServiceVal: ZClientService)
: super(ZClientEntity::class.java, zClientServiceVal) {
}

}
