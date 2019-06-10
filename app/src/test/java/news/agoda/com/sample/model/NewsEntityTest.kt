package news.agoda.com.sample.model

import org.junit.After
import org.junit.Assert
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock



/**
Created by kiranb on 10/6/19
 */
@RunWith(JUnit4::class)
class NewsEntityTest{
    private val title = "Testing Title"
    private val summary = "Testing summary"
    private val articleUrl = "www.google.com/image"
    private val byline = "Testing byline"
    private val publishedDate = "29-01-2019"
    private val mediaEntityList = ArrayList<MediaEntity>()

    @Mock
    var newsEntity: NewsEntity? = null
    @Mock
    var mediaList: List<MediaEntity>?=null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`<String>(newsEntity!!.title).thenReturn(title)
        Mockito.`when`<String>(newsEntity!!.summary).thenReturn(summary)
        Mockito.`when`<String>(newsEntity!!.articleUrl).thenReturn(articleUrl)
        Mockito.`when`(newsEntity!!.byline).thenReturn(byline)
        Mockito.`when`<String>(newsEntity!!.publishedDate).thenReturn(publishedDate)
        Mockito.`when`<List<MediaEntity>>(newsEntity!!.mediaEntityList).thenReturn(mediaEntityList)
    }

    @Test
    fun testNewsTitle() {
        Mockito.`when`<String>(newsEntity!!.title).thenReturn(title)
        Assert.assertEquals("Testing Title", newsEntity!!.title)
    }

    @Test
    fun testNewsSummary() {
        Mockito.`when`<String>(newsEntity!!.summary).thenReturn(summary)
        Assert.assertEquals("Testing summary", newsEntity!!.summary)
    }

    @Test
    fun testNewsArticleUrl() {
        Mockito.`when`<String>(newsEntity!!.articleUrl).thenReturn(articleUrl)
        Assert.assertEquals("www.google.com/image", newsEntity!!.articleUrl)
    }

    @Test
    fun testNewsByline() {
        Mockito.`when`(newsEntity!!.byline).thenReturn(byline)
        Assert.assertEquals("Testing byline", newsEntity!!.byline)
    }

    @Test
    fun testNewsDate() {
        Mockito.`when`<String>(newsEntity!!.publishedDate).thenReturn(publishedDate)
        Assert.assertEquals("29-01-2019", newsEntity!!.publishedDate)
    }


    @Test
    fun testNewsMediaEntitiy() {
        Mockito.`when`<List<MediaEntity>>(newsEntity!!.mediaEntityList).thenReturn(mediaEntityList)
        Assert.assertEquals(ArrayList<MediaEntity>(), newsEntity!!.mediaEntityList)
    }


    @Test
    fun testNewsTitleIncorrect() {
        Mockito.`when`<String>(newsEntity!!.title).thenReturn(title)
        Assert.assertNotEquals("Title", newsEntity!!.title)
    }

    @Test
    fun testNewsSummaryIncorrect() {
        Mockito.`when`<String>(newsEntity!!.summary).thenReturn(summary)
        Assert.assertNotEquals("summary", newsEntity!!.summary)
    }

    @Test
    fun testNewsArticleUrlIncorrect() {
        Mockito.`when`<String>(newsEntity!!.articleUrl).thenReturn(articleUrl)
        Assert.assertNotEquals("www.google.com", newsEntity!!.articleUrl)
    }

    @Test
    fun testNewsBylineIncorrect() {
        Mockito.`when`(newsEntity!!.byline).thenReturn(byline)
        Assert.assertNotEquals("byline", newsEntity!!.byline)
    }

    @Test
    fun testNewsDateIncorrect() {
        Mockito.`when`<String>(newsEntity!!.publishedDate).thenReturn(publishedDate)
        Assert.assertNotEquals("29-02-2019", newsEntity!!.publishedDate)
    }


    @Test
    fun testNewsMediaEntitiyIncorrect() {
        Mockito.`when`<List<MediaEntity>>(newsEntity!!.mediaEntityList).thenReturn(mediaEntityList)
        Assert.assertNotEquals("", newsEntity!!.mediaEntityList)
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        newsEntity = null
        mediaList = null
    }
}