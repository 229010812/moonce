package com.moonce.common.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义数据库映射名称策略
 */

@Component
public class DataBaseNamingStrategyUtil implements PhysicalNamingStrategy {

    @Value("${database.prefix}")
    private String prefix;  //读取application.properties配置的前缀


    protected String addUnderscores(String name) {
        if (name == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(name.replace('.', '_'));
        for (int i = 1; i < stringBuffer.length() - 1; i++) {
            if (Character.isLowerCase(stringBuffer.charAt(i-1)) && Character.isUpperCase(stringBuffer.charAt(i)) && Character.isLowerCase(stringBuffer.charAt(i+1))) {
                stringBuffer.insert(i++, '_');
            }
        }
        return stringBuffer.toString().toLowerCase();
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(prefix + addUnderscores(identifier.getText()));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(addUnderscores(identifier.getText()));
    }


}