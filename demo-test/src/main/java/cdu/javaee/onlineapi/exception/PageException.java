package cdu.javaee.onlineapi.exception;

import cdu.javaee.onlineapi.constant.Status;
import lombok.Getter;

/**
 * @author Zch
 **/
@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
