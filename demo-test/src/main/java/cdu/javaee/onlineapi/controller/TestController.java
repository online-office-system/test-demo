package cdu.javaee.onlineapi.controller;

import cdu.javaee.onlineapi.constant.Status;
import cdu.javaee.onlineapi.exception.JsonException;
import cdu.javaee.onlineapi.exception.PageException;
import cdu.javaee.onlineapi.utils.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Zch
 * @data 2023/4/25
 **/
@Controller
public class TestController {

    @GetMapping("/json")
    @ResponseBody
    public ResponseUtils testJson() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    public ModelAndView testPage() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }

}