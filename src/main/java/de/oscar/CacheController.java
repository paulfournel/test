package de.oscar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    private GeoCachingProxy proxy;

    @GetMapping("/api/caches/{cacheId}")
    public String getCache(@PathVariable("cacheId") String cacheId) {
        return proxy.getCacheById(cacheId);
    }

}