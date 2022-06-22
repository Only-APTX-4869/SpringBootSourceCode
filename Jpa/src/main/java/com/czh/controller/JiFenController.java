package com.czh.controller;

import com.czh.entity.JiFen;
import com.czh.service.JiFenService;
import com.czh.vo.JiFenVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户积分接口
 */
@RestController
@RequestMapping("/JiFen")
public class JiFenController {

    private  JiFenService jiFenService;

    JiFenController(JiFenService jiFenService){
        this.jiFenService = jiFenService;
    }

    @PostMapping("/addJiFen")
    //新增积分
    public JiFen save(@RequestBody JiFenVo jfVo) throws Exception {
        if (jfVo == null || StringUtils.isBlank(jfVo.getName())
                || jfVo.getId() == null)
            throw new Exception("请求参数错误");
        JiFen jf = new JiFen();
        jf.setId(jfVo.getId());
        jf.setName(jfVo.getName());
        return jiFenService.save(jf);
    }

    @PostMapping("/getOne")
    //获取当前积分和下级段位
    public JiFen getOne(@RequestBody JiFen jiFen) throws Exception {
        if (jiFen == null || jiFen.getId() < 0)
            throw new Exception("id 不存在");
        JiFen jfVo = jiFenService.getJiFenById(jiFen.getId());
        JiFen nextJf = jiFenService.getJiFenById(jiFen.getId() + 1);
        jfVo.setNextJiFen(nextJf);
        return jfVo;
    }

    @PostMapping("/delJiFen")
    public void del(@RequestBody JiFen jiFen) throws Exception {
        if (jiFen.getId() < 0)
            throw new Exception("id 不存在");
        jiFenService.delById(jiFen.getId());

    }
    @PostMapping("/getAll")
    public List<JiFen> getAll() throws Exception {
        List<JiFen> LJiFen = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        List<JiFen> jiFenList = jiFenService.findAll();

        jiFenList.forEach(e -> ids.add(e.getId()));
        for(Long id:ids){
            LJiFen.add(jiFenService.getJiFenById(id));
        }
        return LJiFen;
    }

}
