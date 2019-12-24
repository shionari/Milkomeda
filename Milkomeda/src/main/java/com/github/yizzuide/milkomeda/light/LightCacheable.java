package com.github.yizzuide.milkomeda.light;

import java.lang.annotation.*;

/**
 * LightCacheable
 *
 * @author yizzuide
 * @since 2.0.0
 * Create at 2019/12/18 14:35
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface LightCacheable {
    /**
     * 缓存实例名（不同的缓存类型应该设置不能的名字）
     * @return  String
     */
    String value() default LightCacheAspect.DEFAULT_BEAN_NAME;

    /**
     * 缓存key，支持EL表达式获取参数的值
     * @return  String
     */
    String key() default "";

    /**
     * 缓存key前辍，与属性方法 key() 合成完整的key
     * @return String
     */
    String keyPrefix() default "";

    /**
     * 自定义构建缓存key，与属性方法 key() 二选一；如果同时都设置，则 gKey() 优先级要高
     * @return  String
     */
    String gKey() default "";

    /**
     * 缓存条件，使用EL表达式
     * @return String
     */
    String condition() default "";

    /**
     * 缓存策略
     * @return LightDiscardStrategy
     */
    LightDiscardStrategy discardStrategy() default LightDiscardStrategy.DEFAULT;

    /**
     * 新的缓存总是拷贝内置的配置（如果想针对某类型定制配置，设置为false，然后配置LightCache Bean，Bean名与注解属性value()相同）
     * @return bool
     */
    boolean copyDefaultConfig() default true;
}