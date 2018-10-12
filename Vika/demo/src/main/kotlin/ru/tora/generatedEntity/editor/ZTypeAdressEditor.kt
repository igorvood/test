package ru.tora.generatedEntity.editor;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tora.generatedEntity.entity.ZTypeAdressEntity;
import ru.tora.generatedEntity.service.ZTypeAdressService;
import ru.vood.amdWeb.util.abstraction.AbstractEditorKT;


@SpringComponent
@UIScope
/* Редактор для таблицы БД - Типы адресов */
class ZTypeAdressEditor : AbstractEditorKT<ZTypeAdressEntity, ZTypeAdressService>{
@Autowired
constructor(zTypeAdressServiceVal: ZTypeAdressService)
: super(ZTypeAdressEntity::class.java, zTypeAdressServiceVal) {
}

}
