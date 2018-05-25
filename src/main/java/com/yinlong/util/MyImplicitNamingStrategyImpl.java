package com.yinlong.util;

import org.hibernate.boot.model.naming.*;

/**
 * 命名策略
 * 该类实现了  外键的命名规则（通过实体类注解自动在数据库生产符合命名规则的外键名）
 * FK_表名_列名
 * @author 01270059
 *
 */
@SuppressWarnings("serial")
public class MyImplicitNamingStrategyImpl extends ImplicitNamingStrategyJpaCompliantImpl implements ImplicitNamingStrategy {
	@Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource source) {
        Identifier name = super.determinePrimaryTableName(source);
        Identifier result = toStandard(name, "Impl");
        return result;
    }
    
    private Identifier toStandard(Identifier name, String... removeSuffixes){
        if(removeSuffixes == null)
            return name;
        
        if(name == null)
            return null;

        String text = name.getText();
        if(removeSuffixes != null){
            for(String suffix : removeSuffixes){
                if(text.endsWith(suffix))
                    text = text.substring(0, text.length() - suffix.length());
            }
        }
        return new Identifier(text, name.isQuoted());
    }

    @Override
    public Identifier determineJoinTableName(ImplicitJoinTableNameSource source) {
        Identifier name = super.determineJoinTableName(source);
        return name;
    }

    @Override
    public Identifier determineCollectionTableName(ImplicitCollectionTableNameSource source) {
        Identifier name = super.determineCollectionTableName(source);
        return name;
    }

    @Override
    public Identifier determineDiscriminatorColumnName(ImplicitDiscriminatorColumnNameSource source) {
        Identifier name = super.determineDiscriminatorColumnName(source);
        return name;
    }

    @Override
    public Identifier determineTenantIdColumnName(ImplicitTenantIdColumnNameSource source) {
        Identifier name = super.determineTenantIdColumnName(source);
        return name;
    }

    @Override
    public Identifier determineIdentifierColumnName(ImplicitIdentifierColumnNameSource source) {
        Identifier name = super.determineIdentifierColumnName(source);
        return name;
    }

    @Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
        Identifier name = super.determineBasicColumnName(source);
        return name;
    }

    @Override
    public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource source) {
        Identifier name = super.determineJoinColumnName(source);
        final String result;

        if ( source.getNature() == ImplicitJoinColumnNameSource.Nature.ELEMENT_COLLECTION || source.getAttributePath() == null ) {
            result = transformEntityName( source.getEntityNaming() );
        } else {
            result = transformAttributePath( source.getAttributePath() );
        }

        return toIdentifier( result, source.getBuildingContext() );
    }

    @Override
    public Identifier determinePrimaryKeyJoinColumnName(ImplicitPrimaryKeyJoinColumnNameSource source) {
        Identifier name = super.determinePrimaryKeyJoinColumnName(source);
        return name;
    }

    @Override
    public Identifier determineAnyDiscriminatorColumnName(ImplicitAnyDiscriminatorColumnNameSource source) {
        Identifier name = super.determineAnyDiscriminatorColumnName(source);
        return name;
    }

    @Override
    public Identifier determineAnyKeyColumnName(ImplicitAnyKeyColumnNameSource source) {
        Identifier name = super.determineAnyKeyColumnName(source);
        return name;
    }

    @Override
    public Identifier determineMapKeyColumnName(ImplicitMapKeyColumnNameSource source) {
        Identifier name = super.determineMapKeyColumnName(source);
        return name;
    }

    @Override
    public Identifier determineListIndexColumnName(ImplicitIndexColumnNameSource source) {
        Identifier name = super.determineListIndexColumnName(source);
        return name;
    }

//    @Override
//    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
//        Identifier name = super.determineForeignKeyName(source);
//        String result = null;
//        if(source.getColumnNames().size() == 1){
//            result = source.getColumnNames().get(0).getText();
//        } else  {
//            result = source.getReferencedTableName().getText();
//        }
//        return new Identifier(result, name.isQuoted());
//    }   
    @Override
    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource source) {
        Identifier name = super.determineForeignKeyName(source);
        String result = null;
        String tableName = source.getTableName().getText();
        if(source.getColumnNames().size() == 1){
            result = "FK_" + tableName + "_" + source.getColumnNames().get(0).getText();
        } else  {
            String columnName = source.getReferencedTableName().getText();
            result = "FK_" + tableName + "_" + columnName;
        }
        System.out.println("ImplicitNamingStrategy / ForeignKeyName -> \n\t" + name + " => " + result);
        return new Identifier(result, name.isQuoted());
    }

    @Override
    public Identifier determineUniqueKeyName(ImplicitUniqueKeyNameSource source) {
        Identifier name = super.determineUniqueKeyName(source);
        return name;
    }

    @Override
    public Identifier determineIndexName(ImplicitIndexNameSource source) {
        Identifier name = super.determineIndexName(source);
        return name;
    }

}
