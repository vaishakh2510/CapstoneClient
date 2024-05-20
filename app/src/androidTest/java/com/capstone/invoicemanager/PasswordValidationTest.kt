package com.capstone.invoicemanager;


import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PasswordValidationTest {

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun testPasswordValid() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test a valid password
                assertTrue(activity.isValidPassword("Password1!"))
        }
    }

    @Test
    fun testPasswordNoUpperCase() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test password with no uppercase letter
                assertFalse(activity.isValidPassword("password1!"))
        }
    }

    @Test
    fun testPasswordNoLowerCase() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test password with no lowercase letter
                assertFalse(activity.isValidPassword("PASSWORD1!"))
        }
    }

    @Test
    fun testPasswordNoNumber() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test password with no number
                assertFalse(activity.isValidPassword("Password!"))
        }
    }

    @Test
    fun testPasswordNoSpecialCharacter() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test password with no special character
                assertFalse(activity.isValidPassword("Password1"))
        }
    }

    @Test
    fun testPasswordTooShort() {
        val scenario = ActivityScenario.launch(SignupActivity::class.java)
        scenario.onActivity { activity ->
                // Test password that is too short
                assertFalse(activity.isValidPassword("P1!"))
        }
    }
}
