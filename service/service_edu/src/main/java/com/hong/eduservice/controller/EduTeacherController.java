package com.hong.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hong.commonutils.Result;
import com.hong.eduservice.entity.EduTeacher;
import com.hong.eduservice.entity.TeacherQuery;
import com.hong.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-09-05
 */
@RestController
@RequestMapping("/teacher")
public class EduTeacherController{
    @Autowired
    private EduTeacherService teacherService;

    //查询讲师表所有数据
    @GetMapping("/findAll")
    public Result findAllTeacher(){
        //调用service方法实现查询
       List<EduTeacher> list = teacherService.list(null);
       return Result.ok().data("items",list);
    }

    @DeleteMapping("/{id}")
    public Result deleteTeacher(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        return teacherService.removeById(id)?Result.ok():Result.error();
    }

    //current表示当前页，limit表示一页显示多少条记录
    @GetMapping("/{current}/{limit}")
    public Result pageListTeacher(@PathVariable long current,@PathVariable long limit){
        //创建page对象
        Page<EduTeacher> pageteacher = new Page<>(current,limit);
        //调用page方法实现分页
        //调用方法的时候，底层分装，把分页所有数据分装到pageteacher对象中
        teacherService.page(pageteacher,null);
        List<EduTeacher> records = pageteacher.getRecords();
        long total = pageteacher.getTotal();
        return Result.ok().data("total",total).data("rows",records);
    }

    //条件查询加分页
    @PostMapping("/teacherquery/{current}/{limit}")
    public Result teacherQuery(@PathVariable long current,
                               @PathVariable long limit,
                               @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //调用方法实现条件查询分页
        teacherService.pageQuery(pageTeacher,teacherQuery);
        List<EduTeacher> records = pageTeacher.getRecords();
        long total = pageTeacher.getTotal();
        return Result.ok().data("total",total).data("rows",records);
        }
    //添加讲师接口的方法
    @PostMapping("/addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if(save){
            return Result.ok();
        }else {
            return Result.error();
        }
    }
    //根据id查询讲师id
    @GetMapping("/getTeacherById/{id}")
    public Result getTeacherById(@PathVariable  String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return Result.ok().data("teacher",eduTeacher);
    }
    //根据id修改讲师信息
    @PostMapping("/updateTeacherById")
    public Result updateTeacherById(@RequestBody EduTeacher teacher) {

        boolean flag = teacherService.updateById(teacher);
        if (flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}

