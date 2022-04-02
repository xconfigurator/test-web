package liuyang.testweb.commons.util.ref;

import lombok.*;

/**
 * 基本上跟renren的R完成了相同的功能。
 *
 * P12 4-3
 * [视频]()
 *
 * @author liuyang
 * @scine 2021/7/2
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Deprecated
public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private boolean more;// 标记是否还会有更多的数据

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStrandardMessage();
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null, false);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStrandardMessage(), data, false);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getStrandardMessage(), null, false);
    }

    // 利用内部枚举来定义返回值类型 仅做枚举示例
    @AllArgsConstructor
    @Getter
    public enum Status {
        SUCCESS(200, "OK")
        , BAD_REQUEST(400, "Bat Qequest")
        , INTERNAL_SERVER_ERROR(500, "Unknown Internal Server Error")
        , INVALID_PARAM(40005, "Invalid Param")
        , NOT_SUPPORT_OPERATION(4006, "Operation is Not Supported")
        , NOT_LOGIN(50000, "Not Login");

        private int code;
        private String strandardMessage;
    }
}
