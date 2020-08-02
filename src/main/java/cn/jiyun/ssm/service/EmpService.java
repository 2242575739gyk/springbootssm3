package cn.jiyun.ssm.service;

import cn.jiyun.ssm.mapper.EmpMapper;
import cn.jiyun.ssm.pojo.Dept;
import cn.jiyun.ssm.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpService {
    @Autowired
    private EmpMapper empMapper;
    public List<Emp> findAll() {
     List<Emp> le= empMapper.findAll();
     return  le;
    }

    public List<Dept> findByDept() {
        return  empMapper.findByDept();
    }

    public void AddEmp(Emp emp) {
        empMapper.AddEmp(emp);
    }

    public void deleteById(Integer eid) {
        empMapper.deleteById(eid);
    }

    public Emp findById(Integer eid) {
        return  empMapper.findById(eid);
    }

    public void updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
    }
}
