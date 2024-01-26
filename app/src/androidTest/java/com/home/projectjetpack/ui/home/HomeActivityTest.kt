package com.home.projectjetpack.ui.home
import androidx.recyclerview.widget.RecyclerView
import com.home.projectjetpack.R

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.home.projectjetpack.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyCourse = DataDummy.generateDummyCourses()

    @get:Rule
    //menentukan activty yang dijalankan dalam pengujian
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadCourses() {
        //Memastikan rv_academy dalam keadaan tampil.
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()))
        //Gulir rv_academy ke posisi data terakhir.
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }

    @Test
    fun loadDetailCourse() {
        //Memberi tindakan klik pada data pertama di rv_academy.
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Memastikan TextView untuk title tampil sesuai dengan yang diharapkan.
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyCourse[0].title)))
        //Memastikan TextView untuk deadline tampil sesuai dengan yang diharapkan.
        onView(withId(R.id.text_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_date)).check(matches(withText("Deadline ${dummyCourse[0].deadline}")))
    }

    @Test
    fun loadModule() {
        //Memberi tindakan klik pada data pertama di rv_academy.
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Memberi tindakan klik pada btn_start.
        onView(withId(R.id.btn_start)).perform(click())
        //Memastikan rv_module dalam keadaan tampil.
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModule() {
        //Memberi tindakan klik pada data pertama di rv_academy.
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Memberi tindakan klik pada btn_start.
        onView(withId(R.id.btn_start)).perform(click())
        //Memberi tindakan klik pada data pertama di rv_module
        onView(withId(R.id.rv_module)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        //Memastikan web_view sudah tampil.
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadBookmarks() {
        //Klik TabLayout dengan teks Bookmark
        onView(withText("Bookmark")).perform(click())
        //Memastikan rv_module dalam keadaan tampil.
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        //Gulir rv_module ke posisi data terakhir.
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }
}