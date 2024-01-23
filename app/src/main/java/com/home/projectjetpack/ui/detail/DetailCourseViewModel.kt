package com.home.projectjetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.home.projectjetpack.data.CourseEntity
import com.home.projectjetpack.data.ModuleEntity
import com.home.projectjetpack.utils.DataDummy

class DetailCourseViewModel: ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity? {
        var course: CourseEntity? = null
        for (courseEntity in DataDummy.generateDummyCourses()) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}