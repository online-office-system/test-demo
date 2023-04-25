package cdu.javaee.onlineapi.handler;

import cdu.javaee.onlineapi.exception.JsonException;
import cdu.javaee.onlineapi.exception.PageException;
import cdu.javaee.onlineapi.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 统一Json异常处理
     * @param exception JsonException
     * @return 同一返回Json格式
     *
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ResponseUtils jsonErrorHandler(JsonException exception) {
        log.error("[JsonException]: {}", exception.getMessage());
        return ResponseUtils.ofException(exception);
    }

    /**
     * 统一页面异常处理
     * @param exception PageException
     * @return 同一跳转到异常页面
     */
    @ExceptionHandler(value = PageException.class)
    public ModelAndView pageErrorHandler(PageException exception) {
        log.error("[PageException]: {}", exception.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("message", exception.getMessage());
        view.setViewName(DEFAULT_ERROR_VIEW);
        return view;
    }

}
