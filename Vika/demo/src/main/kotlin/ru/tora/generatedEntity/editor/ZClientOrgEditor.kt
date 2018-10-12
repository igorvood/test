package ru.tora.generatedEntity.editor;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tora.generatedEntity.entity.ZClientOrgEntity;
import ru.tora.generatedEntity.service.ZClientOrgService;
import ru.vood.amdWeb.util.abstraction.AbstractEditorKT;


@SpringComponent
@UIScope
/* Редактор для таблицы БД - Юридические лица */
class ZClientOrgEditor : AbstractEditorKT<ZClientOrgEntity, ZClientOrgService>{
@Autowired
constructor(zClientOrgServiceVal: ZClientOrgService)
: super(ZClientOrgEntity::class.java, zClientOrgServiceVal) {
}

}
