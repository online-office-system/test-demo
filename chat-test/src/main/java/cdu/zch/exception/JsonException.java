package cdu.zch.exception;

import cdu.zch.constant.Status;
import lombok.Getter;

/**
 * @author Zch
 **/
@Getter
public class JsonException extends BaseException{
    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
