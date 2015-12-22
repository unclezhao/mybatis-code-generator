package mybatis.generator.enums;

import mybatis.generator.util.AppParams;
import mybatis.generator.util.BeanToolBox;
import org.apache.commons.lang.StringUtils;

import java.io.File;

/**
 * @author unclezhao on 15-12-1.
 */
public enum GenClassTypeEnum {

    DO(AppParams.INSTANCE.getDoPackageName(), AppParams.INSTANCE.getDoSurffix()) {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.DO.getName();
        }
    },
    DAO(AppParams.INSTANCE.getDaoPackageName(), AppParams.INSTANCE.getMapperSurffix()) {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.DAO.getName();
        }
    },
    SERVICE(AppParams.INSTANCE.getServicePackageName(), AppParams.INSTANCE.getServiceSurffix()) {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.SERVICE.getName();
        }
    },
    SERVICE_IMPL(AppParams.INSTANCE.getServiceImplPackageName(), AppParams.INSTANCE.getServiceImplSurffix()) {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.SERVICE_IMPL.getName();
        }
    },
    DTO(AppParams.INSTANCE.getDtoPackageName(), AppParams.INSTANCE.getDtoSurffix()) {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.DTO.getName();
        }
    },
    SQLMAP("", "") {
        @Override
        public String getPackageName() {
            return AppParams.INSTANCE.getSqlMapPackageName();
        }

        @Override
        public String getTemplateName() {
            return TemplateNameEnum.SQLMAP.getName();
        }

        @Override
        public String getGeneratePath() {
            return FilePathEnum.SQLMAP.getName() + File.separator
                    + getPackageName().replaceAll("\\.", File.separator);
        }

        @Override
        public String getFileName(String tableName) {
            String className = getClassName(tableName);
            if(StringUtils.isBlank(className))
                return null;
            String name = BeanToolBox.buildClassNameWithPrefix(tableName);
            return "sqlmap-" + name.toLowerCase().replaceAll("\\_", "-") + FilePathEnum.SQLMAP.getSurffix();
        }
    },
    SERIAL_MODEL(AppParams.INSTANCE.getDoPackageName(), "") {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.SERIAL_MODEL.getName();
        }

        @Override
        public String getFileName(String className) {
            return className + FilePathEnum.JAVA.getSurffix();
        }
    },
    BASE_QUERY(AppParams.INSTANCE.getQueryPackageName(), "") {
        @Override
        public String getTemplateName() {
            return TemplateNameEnum.BASE_QUERY.getName();
        }
    };

    private GenClassTypeEnum(String packageName, String surffix) {
        this.packageName = packageName;
        this.surffix = surffix;
    }

    private String packageName;
    private String surffix;

    public String getPackageName() {
        return AppParams.INSTANCE.getBasePackageName() + "." + packageName;
    }

    public String getClassName(String tableName) {
        if(StringUtils.isBlank(tableName))
            return null;
        return BeanToolBox.toClassName(BeanToolBox.buildClassNameWithPrefix(tableName) + surffix);
    }

    public abstract String getTemplateName();

    public String getGeneratePath() {
        return FilePathEnum.JAVA.getName() + File.separator
                + getPackageName().replaceAll("\\.", File.separator);
    }

    public String getFileName(String tableName) {
        String className = getClassName(tableName);
        if(StringUtils.isBlank(className))
            return null;
        return className + FilePathEnum.JAVA.getSurffix();
    }

    private enum TemplateNameEnum {
        
        DO("do.vm"),
        DAO("dao.vm"),
        SERVICE("service.vm"),
        SERVICE_IMPL("service_impl.vm"),
        DTO("dto.vm"),
        SQLMAP("sqlmap.vm"),
        SERIAL_MODEL("serial_model.vm"),
        BASE_QUERY("base_query.vm");
        
        private TemplateNameEnum(String name) {
            this.name = name;
        }
        
        private String name;

        public String getName() {
            return name;
        }
    }

    private enum FilePathEnum {
        JAVA("java", ".java"),
        SQLMAP("resources", ".xml");

        private FilePathEnum(String name, String surffix) {
            this.name = name;
            this.surffix = surffix;
        }

        private String name;
        private String surffix;

        public String getName() {
            return name;
        }

        public String getSurffix() {
            return surffix;
        }
    }

    public static void main(String[] args) {
        System.out.println(GenClassTypeEnum.DO.getClassName("user_order"));
        System.out.println(GenClassTypeEnum.DAO.getClassName("user_order"));
        System.out.println(GenClassTypeEnum.SERVICE.getClassName("user_order"));
        System.out.println(GenClassTypeEnum.SERVICE_IMPL.getClassName("user_order"));
        System.out.println(GenClassTypeEnum.DTO.getClassName("user_order"));
        System.out.println(GenClassTypeEnum.DTO.getFileName("user_order"));
        System.out.println(GenClassTypeEnum.SQLMAP.getFileName("user_order"));
    }
}
