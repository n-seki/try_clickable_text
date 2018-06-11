package screen

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.seki.android_custom_linklifytext_sample.MainActivity
import com.example.seki.android_custom_linklifytext_sample.R
import org.hamcrest.Matchers.isEmptyString
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) @LargeTest
class SpannableScreenTest {

    @Rule @JvmField
    val mainActivity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun `RecyclerViewが空で表示されていること`() {
        onView(withId(R.id.recycler_list))
                .check(matches(isDisplayed()))
                .check(matches(not(hasDescendant(withId(R.id.clickable_text)))))
    }

    @Test fun `EditTextが表示されていること`() {
        onView(withId(R.id.clickable_strings))
                .check(matches(isDisplayed()))
                .check(matches(withHint(R.string.hint_clickable_text)))
                .check(matches(withText(isEmptyString())))

        onView(withId(R.id.text))
                .check(matches(isDisplayed()))
                .check(matches(withHint(R.string.hint_input_text)))
                .check(matches(withText(isEmptyString())))
    }

    @Test fun `ボタンが表示されていること`() {
        onView(withId(R.id.submit_button))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.submit_button_label)))
    }

}