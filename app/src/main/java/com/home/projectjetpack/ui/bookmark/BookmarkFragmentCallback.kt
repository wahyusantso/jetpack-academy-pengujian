package com.home.projectjetpack.ui.bookmark

import com.home.projectjetpack.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}