package cn.hyqup.dict.bin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.NamingCase;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeDictHelper {
    public static void start() throws SQLException {
        List<Entity> entityList = Db.use().findAll("code_dict");
        List<CodeDict> codeDictList = BeanUtil.copyToList(entityList, CodeDict.class);
        if (CollectionUtil.isEmpty(codeDictList)) {
            return;
        }
        List<CodeDict> codeCategoryList = codeDictList.stream().filter(it -> it.getLevel() == 1L).collect(Collectors.toList());


        LinkedHashMap<String, List<CodeDict>> dictGroup = codeDictList.stream().filter(it -> it.getLevel() != 1L)
                .collect(Collectors.groupingBy(it -> it.getDictCategory(), LinkedHashMap::new, Collectors.toList()));

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("EnumFtl.java.ftl");
        String basePath = basePath();
        String packageName = "/lab06-dict/src/main/java/cn/hyqup/dict/code";
        String path = basePath + packageName;

        codeCategoryList.forEach(codeDict -> {
            List<CodeDict> dictList = dictGroup.get(codeDict.getDictCategory());
            dictList.forEach(it->{
                it.setDictCode(it.getDictCode().toUpperCase());
            });

            String enumClassName = getEnumClassName(codeDict.getDictCategory());
            String classPath=path+"/"+enumClassName+".java";
            File file = FileUtil.newFile(classPath);
            Map map=new HashMap();
            map.put("className",enumClassName);
            map.put("dictList",dictList);
            template.render(map,file);

        });


    }

    /**
     *
     * @param str
     * @return
     */
    private static String getEnumClassName(String str){
        String str1 = StrUtil.toCamelCase(str);
        String str2 = StrUtil.upperFirst(str1);
        String str3 = StrUtil.appendIfMissing(str2, "Enum", "Enum");
        return str3;
    }

    private static String basePath() {
        return FileUtil.getAbsolutePath(new File(""));
    }

    public static void main(String[] args) throws SQLException {
        start();
    }
}
