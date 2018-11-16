package de.oscar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GeoCachingProxy proxy;

    @GetMapping("/api/caches/{cacheId}")
    public Cache getCache(@PathVariable("cacheId") String cacheId) {
        Cache cache = proxy.getCacheById(cacheId);
        logger.info("Requested cache {}", cache);
        return cache;
    }
}