package br.com.ezeqlabs.ihsqueci.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.ezeqlabs.ihsqueci.ListaLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListaLugaresEspressoTest {
    @Rule
    public ActivityTestRule<ListaLugaresActivity> listaLugaresActivityActivityTestRule = new ActivityTestRule(ListaLugaresActivity.class);

    @Test
    public void temTituloComNomeDoAPP(){
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
    }

    @Test
    public void temFloatingButton(){
        onView(withId(R.id.floating_adiciona_lugar)).check(matches(isDisplayed()));
    }

    @Test
    public void temListView(){
        onView(withId(R.id.lista_lugares)).check(matches(isDisplayed()));
    }


}
