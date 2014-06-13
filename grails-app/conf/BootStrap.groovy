import grails.plugins.rest.client.RestBuilder
import wwyg.*

class BootStrap {

    def words = new File("/usr/share/dict/words").readLines()
    def names = new File("/usr/share/dict/propernames").readLines()
    def categoryService
    Random num = new Random()
    def static id = 1;

    def init = { servletContext ->
        checkForCategories()
        5.times{new UserStory(title: randomSentence(), author: randomName(), contactEmail: randomEmail(), story:randomParagraph(), category: tagItem()).save()}

    }

    def destroy = {
    }

    def createTag(String newTag){
        RestBuilder rest = new RestBuilder()
        def resp = rest.post("http://ctacdev.com:8090/TagCloud/tags/createTag"){
            contentType "application/x-www-form-urlencoded"

            tagName = newTag
            tagTypeId = "1"
            languageId = "1"

        }
        resp.json
    }

    def checkForCategories(){
        try {
            RestBuilder rest = new RestBuilder()
            categoryService.category.each {
                def resp = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=${it}").json
                if (!resp) {
                    createTag(it)
                }
            }
        }catch(Exception e) {println "could not make rest call to find tags by name"}
    }


    def tagItem(){
        try {
            RestBuilder rest = new RestBuilder()
            String tag = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=Other").json.id[0]
            String newUrl = "http://wwyg.com:8080/WWyg/userStory/details/${id++}"
            rest.post("http://ctacdev.com:8090/TagCloud/tags/tagItemByTagId") {

                contentType "application/x-www-form-urlencoded"

                url = newUrl
                tagId = tag
            }
        }catch(Exception){println "Could not access Tag"}
        "Other"
    }
    def randomName(){
        "${names[num.nextInt(names.size())]} ${names[num.nextInt(names.size())]}"
    }

    def randomEmail(){

        "${names[num.nextInt(names.size())]}@example.com"
    }

    def randomDate(){
        new Date() - num.nextInt(365)
    }

    def randomWord(){
        words[num.nextInt(words.size())]
    }

    def randomSentence(){
        def sentence = ""
        (num.nextInt(10)+3).times{
            sentence += randomWord() +" "
        }
        sentence.capitalize()[0..-2] + "."
    }

    def randomParagraph(){
        def paragraph = ""
        (num.nextInt(8)+3).times{
            paragraph += randomSentence() +" "
        }
        paragraph

    }

}
