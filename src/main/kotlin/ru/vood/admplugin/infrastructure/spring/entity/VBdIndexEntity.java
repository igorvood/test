package ru.vood.admplugin.infrastructure.spring.entity;

import ru.vood.admplugin.infrastructure.spring.context.LoadedCTX;
import ru.vood.admplugin.infrastructure.spring.intf.CommonFunctionService;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static ru.vood.admplugin.infrastructure.spring.entity.ParentForAll.SCHEMA;

@Entity
@Table(name = "V_BD_INDEX", schema = SCHEMA, catalog = "")
public class VBdIndexEntity extends VBdObjectEntity {
    @Basic
    @Column(name = "UNIQUE_I")
    private boolean uniqueI = false;

    @Basic
    @Column(name = "GLOBAL_I")
    private boolean globalI = false;

    //    @JoinTable(name = "contact_hobby_detail",
//            joinColumns = @JoinColumn(name = "CONTACT_ID"),
//            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "collectionId")//(mappedBy = "columns")//(fetch = FetchType.LAZY)
//    @JoinColumn(table = "VBdIndexedColumnsEntity", name = "VBdIndexedColumnsEntity", referencedColumnName = "columns")
/*    @OneToMany//(mappedBy = "collectionId", fetch = FetchType.EAGER)
    @JoinColumn(name = "COLUMNS", referencedColumnName = COLLECTION)*/
    @Transient
    private List<VBdIndexedColumnsEntity> colomnsEntities;

    //    @Basic
    @Column(name = "COLUMNS", nullable = true, length = 1)
//    @Transient
    private BigDecimal columns;

    public boolean getUniqueI() {
        return uniqueI;
    }

    public void setUniqueI(boolean uniqueI) {
        this.uniqueI = uniqueI;
    }

    public boolean getGlobalI() {
        return globalI;
    }

    public void setGlobalI(boolean globalI) {
        this.globalI = globalI;
    }

    public List<VBdIndexedColumnsEntity> getColomnsEntities() {
        return colomnsEntities;
    }

    public void setColomnsEntities(List<VBdIndexedColumnsEntity> colomnsEntities) {
        this.colomnsEntities = colomnsEntities;
    }

    public BigDecimal getColumns() {
        return columns;
    }

    public void setColumns(BigDecimal columns) {
        this.columns = columns;
    }

    public void addColomn(VBdIndexedColumnsEntity entity) {
        if (columns == null) {
            columns = LoadedCTX.getService(CommonFunctionService.class).nextId();
        }
        if (colomnsEntities == null) {
            colomnsEntities = new ArrayList<VBdIndexedColumnsEntity>();
        }
        entity.setCollectionId(columns);
        colomnsEntities.add(entity);
    }

    public void addColomn(VBdColumnsEntity entity) {
        VBdIndexedColumnsEntity indexedColomnsEntity = new VBdIndexedColumnsEntity();
        indexedColomnsEntity.setColomnRef(entity);
        addColomn(indexedColomnsEntity);
    }


//    @OneToMany(targetEntity = VBdIndexedColumnsEntity.class)
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JoinColumn(name = "COLLECTIONID")
//    private List<VBdIndexedColumnsEntity> colomnsEntities1;
//
//    public List<VBdIndexedColumnsEntity> getColomnsEntities1() {
//        return colomnsEntities1;
//    }
//
//    public void setColomnsEntities1(List<VBdIndexedColumnsEntity> colomnsEntities1) {
//        this.colomnsEntities1 = colomnsEntities1;
//    }
}
