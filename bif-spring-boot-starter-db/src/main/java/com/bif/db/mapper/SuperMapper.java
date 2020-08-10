package com.bif.db.mapper;


import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
    // 这里可以放一些公共的方法
}
