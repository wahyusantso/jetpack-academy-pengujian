package com.home.projectjetpack.ui.detail

import com.home.projectjetpack.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailCourseViewModelTest {
    private lateinit var viewModel: DetailCourseViewModel
    //dummycourse hanya mengambil data pertama
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setup() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourse() {
        //panggil fungsi setSelectedCourse dengan memasukan parameter id data yang diinginkan
        viewModel.setSelectedCourse(courseId)
        //inisialisai courseEntities dengan data dari getcourse
        val courseEntities =  viewModel.getCourse()
        //memastikan variable courseEntities tidak null
        assertNotNull(courseEntities)
        //pencocokan data getcourse dengan data dummy
        courseEntities?.let {
            assertEquals(dummyCourse.courseId, it.courseId)
            assertEquals(dummyCourse.title, it.title)
            assertEquals(dummyCourse.description, it.description)
            assertEquals(dummyCourse.deadline, it.deadline)
            assertEquals(dummyCourse.bookmarked, it.bookmarked)
            assertEquals(dummyCourse.imagePath, it.imagePath)
        }
    }

    @Test
    fun getModules() {
        //inisialisasi moduleEntities dengan data dari getModules
        val moduleEntities = viewModel.getModules()
        //memastikan moduleEntities tidak null
        assertNotNull(moduleEntities)
        //memasikan jumlah moduleEntities sesuai
        assertEquals(7, moduleEntities.size)
    }
}