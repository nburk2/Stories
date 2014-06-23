package wwyg

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional
import com.google.common.cache.Cache;

import javax.annotation.PostConstruct
import java.util.concurrent.TimeUnit

@Transactional
class CategoryService {

    def category = ["Other", "Quitting", "Encouraging", "Exposure", "Loss", "Benefits", "Disparities"]
    def TandC = " Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
    Cache cache;

    /*
     Caches a Tags contents
     */
    @PostConstruct
    def init(){
        cache = CacheBuilder.newBuilder().
                expireAfterWrite(10, TimeUnit.SECONDS).
                maximumSize(500).
                build(new CacheLoader<String, Collection>() {
                    public Collection load(String key) throws Exception {
                        doExpensiveGetTagRequest(key)
                    }
                })
    }

    def tagStory(def id, String catName){
        RestBuilder rest = new RestBuilder()
        String tag = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=${catName}").json.id[0]
        String newUrl = "http://wwyg.com:8080/WWyg/userStory/details/${id}"
        def resp = rest.post("http://ctacdev.com:8090/TagCloud/tags/tagItemByTagId"){

            contentType "application/x-www-form-urlencoded"

            url = newUrl
            tagId = tag
        }
        resp.status
    }

    //returns a random 5 stories
    def getCategoryContent(String catName){
        Collection content = cache.get(catName)

        if(content.size() > 5){
            return content[0..4].each{}
        }
        else if(content){
            return content[0..content.size()-1].each{}
        }
        else
            content
    }
    private doExpensiveGetTagRequest(String key){
        RestBuilder rest = new RestBuilder()
        println "I'm about to call the service for real"
        String tagId = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=${key}").json.id[0]

        def resp = rest.get("http://ctacdev.com:8090/TagCloud/content/getContentForTagId?tagId=${tagId}")
        resp.json.url
    }
}
