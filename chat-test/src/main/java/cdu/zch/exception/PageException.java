package cdu.zch.exception;

import cdu.zch.constant.Status;
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
