package com.bif.common.model;

import java.text.MessageFormat;

public interface Enums {
    String getCode();

    String getDesc();

    String getDesc(Object... objs);

    enum SysCode implements Enums {
        SUCCESS("000", "成功"),
        PARAM_ERROR("009", "参数有误 【{0}】"),
        UPLOAD_FAIL("998", "文件上传失败"),
        DATA_OPERATE_FAIL("999", "数据操作失败【{0}】"),
        DATA_OPERATE_FAIL_("999", "数据操作失败"),
        EXPORT_ERROR_NON_TEMPLATE("999999", "模板不存在"),
        EXPORT_ERROR("999998", "导出失败"),
        EXPORT_SUCCESS("000000", "导出成功"),
        API_CALL_FAIL("997", "接口调用失败");

        private String code;
        private String desc;

        SysCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDesc(Object... objs) {
            return MessageFormat.format(this.desc, objs);
        }

        public boolean equalsCode(String code) {
            return this.code.equals(code);
        }

        public static Enums.SysCode getEnums(String value) {
            Enums.SysCode[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                Enums.SysCode code = var1[var3];
                if (code.getCode().equals(value)) {
                    return code;
                }
            }

            return null;
        }
    }
}
