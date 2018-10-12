package ru.tora.generatedEntity.grid;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.tora.generatedEntity.editor.ZClientOrgEditor;
import ru.tora.generatedEntity.entity.ZClientOrgEntity;
import ru.tora.generatedEntity.service.ZClientOrgService;
import ru.vood.amdWeb.util.abstraction.AbstractGridKT;


@Route(value="ZClientOrgGrid")
@UIScope
/* Таблица для таблицы БД - Юридические лица */
class ZClientOrgGrid(zClientOrgServiceVal:ZClientOrgService, zClientOrgEditorVal:ZClientOrgEditor)
 : AbstractGridKT<ZClientOrgEntity, ZClientOrgService, ZClientOrgEditor> ( zClientOrgServiceVal, ZClientOrgEntity::class.java, zClientOrgEditorVal ) {
}
