package cn.jiyun.ssm.mapper;

import cn.jiyun.ssm.pojo.Dept;
import cn.jiyun.ssm.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EmpMapper {
    List<Emp> findAll();

    List<Dept> findByDept();

    void AddEmp(@Param(value = "emp") Emp emp);

    void deleteById(@Param(value = "eid")Integer eid);

    Emp findById(@Param(value = "eid")Integer eid);

    void updateEmp(@Param(value = "emp") Emp emp);
}
