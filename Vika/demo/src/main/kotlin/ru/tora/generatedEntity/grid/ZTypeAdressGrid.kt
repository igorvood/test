package ru.tora.generatedEntity.grid;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.tora.generatedEntity.editor.ZTypeAdressEditor;
import ru.tora.generatedEntity.entity.ZTypeAdressEntity;
import ru.tora.generatedEntity.service.ZTypeAdressService;
import ru.vood.amdWeb.util.abstraction.AbstractGridKT;


@Route(value="ZTypeAdressGrid")
@UIScope
/* Таблица для таблицы БД - Типы адресов */
class ZTypeAdressGrid(zTypeAdressServiceVal:ZTypeAdressService, zTypeAdressEditorVal:ZTypeAdressEditor)
 : AbstractGridKT<ZTypeAdressEntity, ZTypeAdressService, ZTypeAdressEditor> ( zTypeAdressServiceVal, ZTypeAdressEntity::class.java, zTypeAdressEditorVal ) {
}
