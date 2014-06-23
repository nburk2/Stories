import wwyg.UserStory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_userStory_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/userStory/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: userStoryInstance, field: 'category', 'error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("userStory.contactEmail.label"),'default':("Category")],-1)
printHtmlPart(2)
invokeTag('select','g',9,['class':("form-control"),'name':("category"),'from':(category)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: userStoryInstance, field: 'title', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("userStory.title.label"),'default':("Title")],-1)
printHtmlPart(5)
expressionOut.print(userStoryInstance?.title)
printHtmlPart(6)
expressionOut.print(hasErrors(bean: userStoryInstance, field: 'author', 'error'))
printHtmlPart(7)
invokeTag('message','g',22,['code':("userStory.author.label"),'default':("Author")],-1)
printHtmlPart(8)
expressionOut.print(userStoryInstance?.author)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: userStoryInstance, field: 'contactEmail', 'error'))
printHtmlPart(10)
invokeTag('message','g',30,['code':("userStory.contactEmail.label"),'default':("Contact Email")],-1)
printHtmlPart(11)
expressionOut.print(userStoryInstance?.contactEmail)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: userStoryInstance, field: 'story', 'error'))
printHtmlPart(13)
invokeTag('message','g',39,['code':("userStory.story.label"),'default':("Story")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(14)
expressionOut.print(userStoryInstance.story)
printHtmlPart(15)
})
invokeTag('editor','ckeditor',44,['name':("story"),'height':("400px"),'width':("100%")],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403009368000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
