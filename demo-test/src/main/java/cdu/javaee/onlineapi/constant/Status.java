package cdu.javaee.onlineapi.constant;

import lombok.Getter;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@Getter
public enum Status {

    /**
     * 操作成功
     */
    OK(200, "操作成功!"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR(500, "服务器内部出错啦！");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
