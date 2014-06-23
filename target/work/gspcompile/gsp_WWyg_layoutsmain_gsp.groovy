import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_WWyg_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
invokeTag('require','r',10,['module':("jquery")],-1)
printHtmlPart(4)
invokeTag('require','r',11,['modules':("application")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',13,[:],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',14,[:],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(createLink(controller:'userStory', action:'home'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'userStory', action:'index'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'shareYourStory', action:'index'))
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(createLink(controller:'user', action:'createAccount'))
printHtmlPart(12)
})
invokeTag('ifNotLoggedIn','sec',41,[:],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(createLink(controller:'user', action:'accountDetails'))
printHtmlPart(14)
})
invokeTag('ifLoggedIn','sec',44,[:],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(createLink(controller:'userStory', action:'login'))
printHtmlPart(15)
})
invokeTag('ifNotLoggedIn','sec',47,[:],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(createLink(controller:'logout', action:'index'))
printHtmlPart(17)
})
invokeTag('ifLoggedIn','sec',52,[:],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(createLink(uri:'/'))
printHtmlPart(18)
})
invokeTag('ifAnyGranted','sec',57,['roles':("ROLE_ADMIN")],2)
printHtmlPart(19)
invokeTag('layoutBody','g',62,[:],-1)
printHtmlPart(20)
invokeTag('require','r',66,['modules':("application")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',66,[:],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',74,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403198540000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
