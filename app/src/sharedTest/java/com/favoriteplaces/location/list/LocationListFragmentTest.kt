package com.favoriteplaces.location.list

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.fragment.app.testing.withFragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.favoriteplaces.R
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
class LocationListFragmentTest {

    //  private val mockWebServer = MockWebServer()

    private val scenario =
        launchFragmentInContainer<LocationListFragment>(
            themeResId = R.style.AppTheme,
            initialState = Lifecycle.State.RESUMED
        )
    private val navHost = TestNavHostController(ApplicationProvider.getApplicationContext())

    @Before
    fun setUp() {
        scenario.withFragment {
            navHost.setGraph(R.navigation.main_nav_graph)
            Navigation.setViewNavController(requireView(), navHost)
        }
//
//        mockWebServer.start(8080)
//        mockWebServer.enqueue(MockResponse().setResponseCode(400))
    }

    @Test
    fun name() {
        onView(withId(R.id.locationListProgressBar)).check(matches(isDisplayed()))
    }
}