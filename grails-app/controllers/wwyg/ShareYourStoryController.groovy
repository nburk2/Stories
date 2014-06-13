package wwyg

class ShareYourStoryController {

    def categoryService

    def index() {
        render view:'index', model:[TermsAndConditions:categoryService.TandC]
    }

    def category(){
        render view:'category', model:[categoryList:categoryService.category]
    }

    def stories(){
        long start = System.currentTimeMillis()
        render template:'content', model: [content:categoryService.getCategoryContent(params.id), category:params.id]
        println System.currentTimeMillis() - start
    }
}
