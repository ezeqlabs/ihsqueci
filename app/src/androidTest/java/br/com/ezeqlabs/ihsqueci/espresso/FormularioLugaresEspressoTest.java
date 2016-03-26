package br.com.ezeqlabs.ihsqueci.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.ezeqlabs.ihsqueci.FormularioLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isFocusable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FormularioLugaresEspressoTest {
    @Rule
    public ActivityTestRule<FormularioLugaresActivity> listaLugaresActivityActivityTestRule = new ActivityTestRule(FormularioLugaresActivity.class);

    @Test
    public void temCampoNome(){
        onView(withId(R.id.formulario_campo_nome)).check(matches(isDisplayed()));
        onView(withId(R.id.formulario_campo_nome)).check(matches(isEnabled()));
        onView(withId(R.id.formulario_campo_nome)).check(matches(isFocusable()));
    }

    @Test
    public void temCampoEndereco(){
        onView(withId(R.id.formulario_campo_endereco)).check(matches(isDisplayed()));
        onView(withId(R.id.formulario_campo_endereco)).check(matches(isEnabled()));
        onView(withId(R.id.formulario_campo_endereco)).check(matches(isFocusable()));
    }

    @Test
    public void temCampoTrouxe(){
        onView(withId(R.id.formulario_campo_trouxe)).check(matches(isDisplayed()));
        onView(withId(R.id.formulario_campo_trouxe)).check(matches(isEnabled()));
        onView(withId(R.id.formulario_campo_trouxe)).check(matches(isFocusable()));
    }
}
