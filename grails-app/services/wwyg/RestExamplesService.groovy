package wwyg

import com.google.common.cache.CacheLoader
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional


import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import com.google.common.cache.Cache;

import javax.annotation.PostConstruct

@Transactional
class RestExamplesService {

   private Cache cache

    @PostConstruct
    def init(){
        //do something after construct but before client run-time
        //initialize the cache
        cache = CacheBuilder.newBuilder().
                expireAfterWrite(10, TimeUnit.SECONDS).
                maximumSize(500).
                build(new CacheLoader<String, Collection>() {
                    public Collection load(String key) throws Exception {
                        doExpensiveGetTagRequest(key)
                    }
                })
    }

    def processRequest(def getAttribute = null, def postAttribute = null) {
           return cache.get("Quitting")

    }

    private doExpensiveGetTagRequest(String key){
        RestBuilder rest = new RestBuilder()
        println "I'm about to call the service for real"
        String tag = rest.get("http://ctacdev.com:8090/TagCloud/tags/findTagsByTagName?tagName=${key}").json.id[0]

        def resp = rest.get("http://ctacdev.com:8090/TagCloud/content/getContentForTagId?tagId=${tag}")
        resp.json.url
    }
}
