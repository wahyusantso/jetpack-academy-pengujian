package com.home.projectjetpack.ui.academy

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class AcademyViewModelTest {

    private lateinit var viewModel: AcademyViewModel

    @Before
    fun setup() {
        //inisialisasi viewmodel
        viewModel = AcademyViewModel()
    }

    @Test
    fun getCourses() {
        //inisialisai variable courseEntities dengan hasil dari function getCourses
        val courseEntities = viewModel.getCourses()
        //memastikan variable courseEntities tidak null
        assertNotNull(courseEntities)
        //pengecekan jumlah data courseEntities
        assertEquals(5, courseEntities.size)
    }
}