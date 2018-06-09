import com.example.seki.android_custom_linklifytext_sample.ListData
import com.example.seki.android_custom_linklifytext_sample.clickableString.ClickableString
import org.junit.Test

class ListDataTest {

    @Test fun `ListDataのインスタンスが作成できること`() {
        val data = ListData(ClickableString.create("test", "test"))
        assetThat(data.text.get().toString(), "test")
    }
}