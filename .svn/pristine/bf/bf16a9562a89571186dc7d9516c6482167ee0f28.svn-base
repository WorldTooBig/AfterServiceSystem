package com.yinlong.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * 命名策略
 * 该类实现了 列名的命名规则（通过实体类的驼峰命名自动在数据库中转换为符合数据库的名称）
 * 例：  userId ==> user_id
 * @author 01270059
 *
 */
public class MyPhysicalNamingStrategyImpl implements PhysicalNamingStrategy {

	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        Identifier result = toStandard(name);
        return result;
    }
    
    private Identifier toStandard(Identifier name){
        return toStandard(name, null);
    }
    
    private Identifier toStandard(Identifier name, String prefix){
        if(name == null)
            return null;

        String text = name.getText();
        StringBuffer buffer = new StringBuffer();
        if(prefix != null)
            buffer.append(prefix);
        
        char[] chars = text.toCharArray();
        for(int i=0, len=chars.length; i<len; i++){
            char c = chars[i];
            if(c >= 'A' && c <= 'Z'){
                if(i > 0 && i + 1 < len){
                    if(chars[i + 1] < 'A' || chars[i + 1] > 'Z')
                        buffer.append('_');
                }
                c = (char) (c - 'A' + 'a');
            }
            buffer.append(c);
        }
        return new Identifier(buffer.toString(), name.isQuoted());
    }

  
}