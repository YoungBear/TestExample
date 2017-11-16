package com.ysx.testexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author ysx
 * @date 2017/11/14
 * @description
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    private static final String STRING_TO_BE_TYPED = "peter";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void sayHello(){
        onView(withId(R.id.et)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //line 1
//        onView(withId(R.id.et)).perform(closeSoftKeyboard());

        onView(withId(R.id.btn)).perform(click()); //line 2

        String expectedText = STRING_TO_BE_TYPED;
        onView(withId(R.id.tv_show)).check(matches(withText(expectedText))); //line 3
    }

}
