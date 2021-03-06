package com.atyume.ibabym.basics;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ProjectToExam {            //套餐-单项关系表
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private Long examId;                  //体检套餐Id
    @NotNull
    private Long projectId;               //体检单项Id

    public ProjectToExam(Long examId, Long projectId) {
        this.examId = examId;
        this.projectId = projectId;
    }

    @Generated(hash = 2056752857)@Keep
    public ProjectToExam(Long id, @NotNull Long examId, @NotNull Long projectId) {
        this.id = id;
        this.examId = examId;
        this.projectId = projectId;
    }

    @Generated(hash = 430865244)@Keep
    public ProjectToExam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
