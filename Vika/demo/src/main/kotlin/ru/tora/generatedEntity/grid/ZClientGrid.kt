package ru.tora.generatedEntity.grid;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.tora.generatedEntity.editor.ZClientEditor;
import ru.tora.generatedEntity.entity.ZClientEntity;
import ru.tora.generatedEntity.service.ZClientService;
import ru.vood.amdWeb.util.abstraction.AbstractGridKT;


@Route(value="ZClientGrid")
@UIScope
/* Таблица для таблицы БД - Клиенты */
class ZClientGrid(zClientServiceVal:ZClientService, zClientEditorVal:ZClientEditor)
 : AbstractGridKT<ZClientEntity, ZClientService, ZClientEditor> ( zClientServiceVal, ZClientEntity::class.java, zClientEditorVal ) {
}
