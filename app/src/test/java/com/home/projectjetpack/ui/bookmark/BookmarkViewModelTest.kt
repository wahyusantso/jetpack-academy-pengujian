package com.home.projectjetpack.ui.bookmark

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @Before
    fun setup() {
        //inisialisasi viewmodel
        viewModel = BookmarkViewModel()
    }

    @Test
    fun getBookmarks() {
        //inisialisai variable courseEntities dengan hasil dari function getbookmarks
        val courseEntities = viewModel.getBookmarks()
        //memastikan variable courseEntities tidak null
        assertNotNull(courseEntities)
        //pengecekan jumlah data courseEntities
        assertEquals(5, courseEntities.size)
    }
}