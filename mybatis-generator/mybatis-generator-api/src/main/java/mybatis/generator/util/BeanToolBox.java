package mybatis.generator.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-11-30.
 */
public final class BeanToolBox {

    private static final String GETTER_PREFIX = "get";
    private static final String SETTER_PREFIX = "set";

    public static String toClassName(String tableName) {
        if(StringUtils.isBlank(tableName))
            return null;
        String name = getTableNameWithPrefix(tableName);
        String[] subNames = name.split("\\_");
        StringBuilder className = new StringBuilder();
        for(int i = 0; i < subNames.length; i++) {
            if(StringUtils.isBlank(subNames[i]))
                continue;
            char[] ca = subNames[i].toCharArray();
            className.append(Character.toUpperCase(ca[0])).append(ca, 1, ca.length -1);
        }
        return className.toString();
    }

    public static String columnNameToFieldName(String dbColumnName) {
        if(StringUtils.isBlank(dbColumnName))
            return null;
        String[] subNames = dbColumnName.split("\\_");
        StringBuilder fieldName = new StringBuilder();
        for(int i = 0; i < subNames.length; i++) {
            if(StringUtils.isBlank(subNames[i]))
                continue;
            if(i == 0) {
                fieldName.append(subNames[0]);
            } else {
                char[] ca = subNames[i].toCharArray();
                fieldName.append(Character.toUpperCase(ca[0])).append(ca, 1, ca.length -1);
            }
        }
        return fieldName.toString();
    }

    public static String classNameToFieldName(String className) {
        if(StringUtils.isBlank(className))
            return null;
        StringBuilder fieldName = new StringBuilder();
        char[] ca = className.toCharArray();
        fieldName.append(Character.toLowerCase(ca[0])).append(ca, 1, ca.length -1);
        return fieldName.toString();
    }

    public static String toResultMapName(String tableName) {
        String temp = AppParams.INSTANCE.getResultMapPrefix() + "_" + tableName;
        StringBuilder resultMapName = new StringBuilder();
        char[] ca = columnNameToFieldName(temp).toCharArray();
        resultMapName.append(Character.toUpperCase(ca[0])).append(ca, 1, ca.length -1);
        return resultMapName.toString();
    }

    public static String buildClassNameWithPrefix(String tableName) {
        return tableName.toLowerCase().startsWith(AppParams.INSTANCE.getGlobalPrefix().toLowerCase() + "_")
                ? tableName
                : AppParams.INSTANCE.getGlobalPrefix() + "_" + tableName;
    }

    public static String toSetter(String dbColumnName) {
        return toJavaBeanMethod(SETTER_PREFIX, dbColumnName);
    }

    public static String toGetter(String dbColumnName) {
        return toJavaBeanMethod(GETTER_PREFIX, dbColumnName);
    }

    private static String toJavaBeanMethod(String prefix, String dbColumnName) {
        if(StringUtils.isBlank(dbColumnName))
            return null;
        String fieldName = columnNameToFieldName(dbColumnName);
        StringBuilder methodName = new StringBuilder(prefix);
        char[] ca = fieldName.toCharArray();
        methodName.append(Character.toUpperCase(ca[0])).append(ca, 1, ca.length - 1);
        return methodName.toString();
    }

    private static String getTableNameWithPrefix(String tableName) {
        return tableName.toLowerCase().startsWith(AppParams.INSTANCE.getGlobalPrefix().toLowerCase() + "_")
                ? tableName
                : AppParams.INSTANCE.getGlobalPrefix() + "_" + tableName;
    }

    public static void main(String[] args) {
        String name1 = "test_name";
        System.out.println(BeanToolBox.columnNameToFieldName(name1));
        System.out.println(BeanToolBox.toSetter(name1));
        System.out.println(BeanToolBox.toGetter(name1));
        String name2 = "test";
        System.out.println(BeanToolBox.columnNameToFieldName(name2));
        System.out.println(BeanToolBox.toSetter(name2));
        System.out.println(BeanToolBox.toGetter(name2));
        String name3 = "mg_test";
        System.out.println(name3.substring(name3.indexOf("mg_") + "mg_".length()));
    }
}
