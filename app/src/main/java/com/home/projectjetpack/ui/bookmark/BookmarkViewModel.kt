package com.home.projectjetpack.ui.bookmark

import androidx.lifecycle.ViewModel
import com.home.projectjetpack.data.CourseEntity
import com.home.projectjetpack.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}