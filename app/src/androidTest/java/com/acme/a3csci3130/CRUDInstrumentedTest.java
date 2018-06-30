package com.acme.a3csci3130;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.core.deps.guava.base.Predicate;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.core.deps.guava.base.Predicates.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CRUDInstrumentedTest {
    @Rule
    public ActivityTestRule<CreateBusinessActivity> activityActivityTestRule =
            new ActivityTestRule<>(CreateBusinessActivity.class);
    @Test
    public void createTestGood(){
        Espresso.onView(withId(R.id.businessNumberField)).perform(ViewActions.click())
                .perform(ViewActions.typeText("123456789"));
        Espresso.onView(withId(R.id.nameField)).perform(ViewActions.click())
                .perform(ViewActions.typeText("Madam Fish"));
        Espresso.onView(withId(R.id.primaryBusinessSpinner)).perform(ViewActions.click());
        //Espresso.onData(allOf(is(instanceOf(String.class)), is("Fish Monger"))).perform(ViewActions.click());
        //Espresso.onData(allOf(is(instanceOf(String.class)), is("Fish Monger")))
        //        .perform(ViewActions.click());
        //I dont know what I am asserting for here.
    }

}
