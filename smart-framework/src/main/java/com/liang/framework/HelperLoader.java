package com.liang.framework;

import com.liang.framework.annotation.Controller;
import com.liang.framework.helper.BeanHelper;
import com.liang.framework.helper.ClassHelper;
import com.liang.framework.helper.IocHelper;
import com.liang.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by liangz on 2015/12/29.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                Controller.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
