package com.robin.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description
 * @Author Robin
 * @Date 2018/12/16 16:18
 */
public class MyImportSelector implements ImportSelector {

    @Override
    //返回值，就是导入到容器中的组件的全类名
    //AnnotationMetadata：当前标注@Import注解类的所有注解信息
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        importingClassMetadata

        return new String[]{"com.robin.bean.Blue","com.robin.bean.Yellow"};
        //不能返回null，可以返回一个空数组
        //return null;
    }
}
