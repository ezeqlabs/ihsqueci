package br.com.ezeqlabs.ihsqueci.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.ezeqlabs.ihsqueci.BoasVindasActivity;
import br.com.ezeqlabs.ihsqueci.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BoasVindasEspressoTest {
    @Rule
    public ActivityTestRule<BoasVindasActivity> boasVindasActivityActivityTestRule = new ActivityTestRule(BoasVindasActivity.class);

    @Test
    public void temNomeApp(){
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }

    @Test
    public void temVersaoApp(){
        onView(withText(R.string.app_version)).check(matches(isDisplayed()));
    }
}
