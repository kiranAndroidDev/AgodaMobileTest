package news.agoda.com.sample.model

import org.junit.After
import org.junit.Assert
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test
import org.mockito.Mock



/**
Created by kiranb on 10/6/19
 */
class MediaEntityTest {

    private val url = "www.test.com"
    private val format = "testing format"
    private val height = 2
    private val width = 1
    private val type = "testing type"
    private val subType = "testing subtype"
    private val caption = "testing caption"
    private val copyright = "testing copyright"

    @Mock
    internal var mediaEntity: MediaEntity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`<String>(mediaEntity!!.url).thenReturn(url)
        Mockito.`when`<String>(mediaEntity!!.format).thenReturn(format)
        Mockito.`when`<Int>(mediaEntity!!.height).thenReturn(height)
        Mockito.`when`<Int>(mediaEntity!!.width).thenReturn(width)
        Mockito.`when`<String>(mediaEntity!!.type).thenReturn(type)
        Mockito.`when`<String>(mediaEntity!!.subType).thenReturn(subType)
        Mockito.`when`<String>(mediaEntity!!.caption).thenReturn(caption)
        Mockito.`when`<String>(mediaEntity!!.caption).thenReturn(copyright)
    }

    @Test
    fun testMediaUrl() {
        Mockito.`when`<String>(mediaEntity!!.url).thenReturn(url)
        Assert.assertEquals("www.test.com", mediaEntity!!.url)
    }

    @Test
    fun testMediaFormat() {
        Mockito.`when`<String>(mediaEntity!!.format).thenReturn(format)
        Assert.assertEquals("testing format", mediaEntity!!.format)
    }

    @Test
    fun testMediaHeight() {
        Mockito.`when`<Int>(mediaEntity!!.height).thenReturn(height)
        Assert.assertEquals(2, mediaEntity!!.height)
    }

    @Test
    fun testMediaWidth() {
        Mockito.`when`<Int>(mediaEntity!!.width).thenReturn(width)
        Assert.assertEquals(1, mediaEntity!!.width)
    }

    @Test
    fun testMediaType() {
        Mockito.`when`<String>(mediaEntity!!.type).thenReturn(type)
        Assert.assertEquals("testing type", mediaEntity!!.type)
    }

    @Test
    fun testMediaSubType() {
        Mockito.`when`<String>(mediaEntity!!.subType).thenReturn(subType)
        Assert.assertEquals("testing subtype", mediaEntity!!.subType)
    }

    @Test
    fun testMediaCaption() {
        Mockito.`when`<String>(mediaEntity!!.caption).thenReturn(caption)
        Assert.assertEquals("testing caption", mediaEntity!!.caption)
    }

    @Test
    fun testMediaCopyright() {
        Mockito.`when`<String>(mediaEntity!!.copyright).thenReturn(copyright)
        Assert.assertEquals("testing copyright", mediaEntity!!.copyright)
    }


    @Test
    fun testMediaUrlIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.url).thenReturn(url)
        Assert.assertNotEquals(" testing www.test.com", mediaEntity!!.url)
    }

    @Test
    fun testMediaFormatIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.format).thenReturn(format)
        Assert.assertNotEquals("format", mediaEntity!!.format)
    }

    @Test
    fun testMediaHeightIncorrect() {
        Mockito.`when`<Int>(mediaEntity!!.height).thenReturn(height)
        Assert.assertNotEquals(12, mediaEntity!!.height)
    }

    @Test
    fun testMediaWidthIncorrect() {
        Mockito.`when`<Int>(mediaEntity!!.width).thenReturn(width)
        Assert.assertNotEquals(11, mediaEntity!!.width)
    }

    @Test
    fun testMediaTypeIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.type).thenReturn(type)
        Assert.assertNotEquals("type", mediaEntity!!.type)
    }

    @Test
    fun testMediaSubTypeIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.subType).thenReturn(subType)
        Assert.assertNotEquals("subtype", mediaEntity!!.subType)
    }

    @Test
    fun testMediaCaptionIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.caption).thenReturn(caption)
        Assert.assertNotEquals("caption", mediaEntity!!.caption)
    }

    @Test
    fun testMediaCopyrightIncorrect() {
        Mockito.`when`<String>(mediaEntity!!.copyright).thenReturn(copyright)
        Assert.assertNotEquals("copyright", mediaEntity!!.copyright)
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        mediaEntity = null
    }
}