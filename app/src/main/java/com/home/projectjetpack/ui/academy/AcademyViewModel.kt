package com.home.projectjetpack.ui.academy

import androidx.lifecycle.ViewModel
import com.home.projectjetpack.data.CourseEntity
import com.home.projectjetpack.utils.DataDummy

class AcademyViewModel: ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}