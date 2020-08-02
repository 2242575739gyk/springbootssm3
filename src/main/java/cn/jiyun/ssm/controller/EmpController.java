package cn.jiyun.ssm.controller;

import cn.jiyun.ssm.pojo.Dept;
import cn.jiyun.ssm.pojo.Emp;
import cn.jiyun.ssm.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Value("${file.upload.path}")
    private String filepath;
   /* @Value("${file.upload.relative.pathth}")
    private  String relativePath;*/

    @Autowired
    private EmpService empService;

    @GetMapping("findAll")
    public String findAll(Model model) {
        List<Emp> le = empService.findAll();
        model.addAttribute("le22", le);
        return "show";
    }

    //添加
    @GetMapping("ToEmpAdd")
    public String ToEmpAdd(Model model) {
        List<Dept> ld = empService.findByDept();
        model.addAttribute("ld22", ld);
        return "AddEmp";
    }

    //添加方法
    @PostMapping("addEmp")
    public String addEmp(@ModelAttribute(value = "emp") Emp emp, @RequestParam(value = "pic") MultipartFile pic) throws Exception {
        String filename = pic.getOriginalFilename();

        String newname = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        File file = new File(filepath, newname);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        pic.transferTo(new File(filepath + File.separator + newname));
        emp.setPhoto("/img/" + newname);
        empService.AddEmp(emp);
        return "redirect:/emp/findAll";
    }

    //删除
    @GetMapping("DeleteById")
    public String DeleteById(Integer eid) {
        empService.deleteById(eid);
        return "redirect:/emp/findAll";
    }

    //修改一
    @GetMapping("findById")
    public String findById(Integer eid, Model model) {
        Emp e = empService.findById(eid);
        List<Dept> ld = empService.findByDept();
        model.addAttribute("ld22", ld);
        model.addAttribute("e", e);
        return "update";
    }

    //修改·
    @PostMapping("UpdateEmp")
    public String UpdateEmp(@ModelAttribute(value = "emp") Emp emp, @RequestParam(value = "pic") MultipartFile pic) throws IOException {


        String filename = pic.getOriginalFilename();
        if(!filename.equals("")){
        String newname = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        File file = new File(filepath, newname);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //上传
        pic.transferTo(new File(filepath + File.separator + newname));
        emp.setPhoto("/img/" + newname);

    }
        empService.updateEmp(emp);
        return  "redirect:/emp/findAll";
    }

}
