package ru.tora.generatedEntity.editor;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tora.generatedEntity.entity.ZAddressEntity;
import ru.tora.generatedEntity.service.ZAddressService;
import ru.tora.generatedEntity.service.ZTypeAdressService;
import ru.vood.amdWeb.util.abstraction.AbstractEditorKT;


@SpringComponent
@UIScope
/* Редактор для таблицы БД - Адреса */
class ZAddressEditor : AbstractEditorKT<ZAddressEntity, ZAddressService>{
private val zTypeAdressServiceVal: ZTypeAdressService
@Autowired
constructor(zTypeAdressServiceVal: ZTypeAdressService, zAddressServiceVal: ZAddressService)
: super(ZAddressEntity::class.java, zAddressServiceVal) {
this.zTypeAdressServiceVal = zTypeAdressServiceVal
}

}
