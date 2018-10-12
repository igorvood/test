package ru.tora.generatedEntity.grid;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.tora.generatedEntity.editor.ZAddressEditor;
import ru.tora.generatedEntity.entity.ZAddressEntity;
import ru.tora.generatedEntity.service.ZAddressService;
import ru.vood.amdWeb.util.abstraction.AbstractGridKT;


@Route(value="ZAddressGrid")
@UIScope
/* Таблица для таблицы БД - Адреса */
class ZAddressGrid(zAddressServiceVal:ZAddressService, zAddressEditorVal:ZAddressEditor)
 : AbstractGridKT<ZAddressEntity, ZAddressService, ZAddressEditor> ( zAddressServiceVal, ZAddressEntity::class.java, zAddressEditorVal ) {
}
