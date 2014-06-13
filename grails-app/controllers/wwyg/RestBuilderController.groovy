package wwyg
import wwyg.RestExamplesService

class RestBuilderController {

    def restExamplesService

    def index() {
        render view:'index'
    }

    def restRequest(){
        long start = System.currentTimeMillis()
        render "<ul>"
        restExamplesService.processRequest(params.GET, params.POST).each{
            render "<li>$it</li>"
        }
        render "</ul>"
        println System.currentTimeMillis() - start
    }
}
