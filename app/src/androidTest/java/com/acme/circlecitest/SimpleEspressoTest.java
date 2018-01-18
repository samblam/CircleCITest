package com.acme.circlecitest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.Console;

import static android.content.Context.KEYGUARD_SERVICE;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleEspressoTest {

    private String textToFind;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void SetUp()
    {
        textToFind = "Not Hello World!";
    }

    @Test
    public void findText()
    {
        //Tries to find the text on the screen
        //Return true if it matches the expected test
        onView(withId(R.id.hello))

                .check(matches(withText(textToFind)));

        //Same thing but not using IDs
        //It does not makes much sense in this case
        //onView(withText(textToFind)).check(matches(withText(textToFind)));
    }


}