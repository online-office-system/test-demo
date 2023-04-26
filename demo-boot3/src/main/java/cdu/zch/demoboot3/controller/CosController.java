package cdu.zch.demoboot3.controller;

import cdu.zch.demoboot3.controller.form.DeleteCosFileForm;
import cdu.zch.demoboot3.exception.DemoException;
import cdu.zch.demoboot3.utils.CosUtils;
import cdu.zch.demoboot3.utils.R;
import cdu.zch.demoboot3.utils.TypeEnum;
import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Zch
 * @data 2023/4/26
 **/
@RestController
@RequestMapping("/cos")
@Slf4j
public class CosController {
    @Autowired
    private CosUtils cosUtils;

    @PostMapping("/uploadCosFile")
    @SaCheckLogin
    public R uploadCosFile(@RequestParam("file") MultipartFile file, @RequestParam("type") String type){
        TypeEnum typeEnum=TypeEnum.findByKey(type);
        if(typeEnum==null){
            throw new DemoException("type类型错误");
        }
        try{
            HashMap map=cosUtils.uploadFile(file,typeEnum);
            return R.ok(map);
        }catch (IOException e){
            log.error("文件上传到腾讯云错误", e);
            throw new DemoException("文件上传到腾讯云错误");
        }
    }

    @PostMapping("/deleteCosFile")
    @SaCheckLogin
    public R deleteCosFile(@Valid @RequestBody DeleteCosFileForm form){
        cosUtils.deleteFile(form.getPath());
        return R.ok();
    }
}
