package org.wuliu.enums;

public enum ResultEnum {
    ADMIN(-1, "管理员"),
    SUCCESS(0, "成功"),
    FAIL(1, "登录失败"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
