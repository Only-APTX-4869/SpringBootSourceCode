package com.czh.controller;

import com.czh.entity.JiFen;
import com.czh.service.JiFenService;
import com.czh.util.ResultCode;
import com.czh.vo.JiFenVo;
import com.czh.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户积分接口
 */
@RestController
@RequestMapping("/JiFen")
@Slf4j
public class JiFenController {

    final JiFenService jiFenService;

    JiFenController(JiFenService jiFenService){
        this.jiFenService = jiFenService;
    }

    @PostMapping("/addJiFen")//新增积分
    public ResultVo save(@RequestBody @Validated JiFenVo jfVo) throws Exception {
//        if (jfVo == null || StringUtils.isBlank(jfVo.getName())
//                || jfVo.getId() == null)
//            throw new Exception(ResultCode.FAILED + "请求参数错误");
        JiFen jf = new JiFen(jfVo.getId(), jfVo.getName());
        jiFenService.save(jf);
        return new ResultVo(ResultCode.SUCCESS, jfVo);
    }

    @PostMapping("/getOne")   //获取当前积分和下级段位
    public ResultVo getOne(@RequestBody JiFenVo jiFenVo) throws Exception {
        if (jiFenVo == null || jiFenVo.getId() < 0) {
            throw new Exception("id 不存在");
        }
        JiFen jfVo = jiFenService.getJiFenById(jiFenVo.getId());
        JiFen nextJf = jiFenService.getJiFenById(jiFenVo.getId() + 1);
        jfVo.setNextJiFen(nextJf);
        return new ResultVo(ResultCode.SUCCESS, jfVo);
    }

    @PostMapping("/delJiFen")
    public ResultVo del(@RequestBody JiFen jiFen) throws Exception {
        if (jiFen == null || jiFen.getId() < 0)
            throw new Exception("id 不存在");
        jiFenService.delById(jiFen.getId());
        return new ResultVo(ResultCode.SUCCESS);
    }

    @PostMapping("/getAll")
    public ResultVo getAll() throws Exception {
        List<JiFen> jiFenList = jiFenService.findAll();
        return new ResultVo(ResultCode.SUCCESS, jiFenList);
    }

}
