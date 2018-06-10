import android.text.Spannable
import android.text.SpannableStringBuilder
import com.example.seki.android_custom_linklifytext_sample.ListData
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ListDataTest {

    @Test fun `ListDataのインスタンスが作成できること`() {
        val data = ListData(makeTestSpannable())
        assertThat(data.text.get().toString(), `is`("test"))
    }

    private fun makeTestSpannable(): Spannable {
        val mock = Mockito.mock(SpannableStringBuilder::class.java)
        `when`(mock.toString()).thenReturn("test")
        return mock
    }
}