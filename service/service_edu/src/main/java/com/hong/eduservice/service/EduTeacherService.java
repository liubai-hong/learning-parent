package com.hong.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hong.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.eduservice.entity.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-09-05
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> teacherPage, TeacherQuery teacherQuery);
}
