import com.example.seki.android_custom_linklifytext_sample.ClickableTextPresenter
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ClickableTextPresenterTest {

    @Test
    fun `インスタンス作成時にView#setPresenterが実行されること`() {
        val mockView = mock(ClickableTextPresenter.View::class.java)
        val presenter = ClickableTextPresenter(mockView)

        verify(mockView).setPresenter(presenter)
    }

    @Test
    fun `onClickSubmitでtextが空の場合にshowTextEnptyMessageとclearInputTextが実行されること`() {
        val mockView = mock(ClickableTextPresenter.View::class.java)
        val presenter = ClickableTextPresenter(mockView)

        presenter.onClickSubmit(null, "")

        verify(mockView).showTextEmptyMessage()
        verify(mockView).clearInputText()
    }
}