package com.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //返回值就是放入容器中的组件的全类名
        //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
        return new String[]{"com.spring.bean.Blue","com.spring.bean.Yello"};
    }
}
