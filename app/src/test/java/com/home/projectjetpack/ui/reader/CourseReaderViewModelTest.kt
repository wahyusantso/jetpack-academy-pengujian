package com.home.projectjetpack.ui.reader

import com.home.projectjetpack.data.ContentEntity
import com.home.projectjetpack.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class CourseReaderViewModelTest {
    private lateinit var viewModel: CourseReaderViewModel
    //inisialisasi dummyCourse dengan data pertama dari DataDummy.generateDummyCourses()
    private val dummyCourse = DataDummy.generateDummyCourses()[0]
    private val courseId = dummyCourse.courseId
    //inisialisai dummyModules dengan data DataDummy.generateDummyModules dan input parameters courseId pada fungsi tersebut.
    private val dummyModules = DataDummy.generateDummyModules(courseId)
    private val moduleId = dummyModules[0].moduleId

    @Before
    fun setup() {
        viewModel = CourseReaderViewModel()
        viewModel.setSelectedCourse(courseId)
        viewModel.setSelectedModule(moduleId)

        val dummyModule = dummyModules[0]
        dummyModule.contentEntity = ContentEntity("<h3 class=\\\"fr-text-bordered\\\">"+dummyModule.title+"</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>")
    }

    @Test
    fun getModules() {
        //inisalisasi moduleEntities dengan data dari fungsi getModules()
        val moduleEntities = viewModel.getModules()
        //memastikan data moduleEntities tidak null
        assertNotNull(moduleEntities)
        //memastikan jumlah data moduleEntities sesuai
        assertEquals(7, moduleEntities.size)
    }

    @Test
    fun getSelectedModule() {
        //inisialisasi moduleEntity dengan data dari fungsi getSelectedModule()
        val moduleEntity = viewModel.getSelectedModule()
        //memastikan data moduleEntity tidak null
        assertNotNull(moduleEntity)
        //inisalisasi contentEntity dengan data objek moduleEntity
        val contentEntity = moduleEntity.contentEntity
        //Memastikan data content tidak null.
        assertNotNull(contentEntity)
        val content = contentEntity?.content
        //Memastikan value dari content tidak null.
        assertNotNull(content)
        //Memastikan data content sesuai dengan yang diharapkan
        assertEquals(content, dummyModules[0].contentEntity?.content)
    }
}