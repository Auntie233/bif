package com.bif.common.model;

import java.text.MessageFormat;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 15:03
 * @Version 1.0
 */
public enum ExcelCode implements Enums {
    FILE_TYPE_ERROR("985", "上传文件类型错误，必须为.xlsx文件"),
    TITLE_LEN_ERROR("986", "Excel标题列长度不匹配,请重新下载模版！"),
    TITLE_NAME_ERROR("987", "第{0}列标题名错误，应为[{1}]！"),
    COL_LEN_ERROR("989", "第{0}行数据错误，列数量不匹配！"),
    DATA_NULL_ERROR("990", "第{0}行[{1}]列必填！"),
    NO_DATA_ERROR("991", "导入的Excel无数据！"),
    DATA_TYPE_ERROR("992", "第{0}行[{1}]列单元格类型错误，应为[{2}]！"),
    CELL_LEN_ERROR("993", "第{0}行[{1}]列单元格数据长度超出，最大长度[{2}]！"),
    DATA_ERROR("994", "第{0}行[{1}]列填写错误！"),
    DATA_LEN_ERROR("995", "第{0}行[{1}]列值长度错误,应为[{2}]位！"),
    BILL_AMOUNT_ERROR("996", "第{0}行金额范围超出，范围：(0,999999999.99]！"),
    ROW_LEN_ERROR("997", "导入的Excel中有多余无用空行，请删除数据行以外的其他空行后重新导入！");

    private String code;
    private String desc;

    ExcelCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getDesc(Object... objs) {
        return MessageFormat.format(this.desc, objs);
    }

    // 通过value获取对应的枚举对象
    public static ExcelCode getEnums(String value) {
        for (ExcelCode code : ExcelCode.values()) {
            if (code.getCode().equals(value)) {
                return code;
            }
        }
        return null;
    }
}
