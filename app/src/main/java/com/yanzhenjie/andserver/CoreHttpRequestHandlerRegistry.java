package com.yanzhenjie.andserver;

import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.util.Args;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/12.
 */

public class CoreHttpRequestHandlerRegistry extends HttpRequestHandlerRegistry {
    private HttpRequestHandlerRegistry httpRequestHandlerRegistry;
    private HttpRequestHandler noMatchHttpRequestHandler;
    public CoreHttpRequestHandlerRegistry(HttpRequestHandlerRegistry httpRequestHandlerRegistry, HttpRequestHandler noMatchHttpRequestHandler){
        this.httpRequestHandlerRegistry = httpRequestHandlerRegistry;
        this.noMatchHttpRequestHandler =  noMatchHttpRequestHandler;
    }

    /**
     * Registers the given {@link HttpRequestHandler} as a handler for URIs
     * matching the given pattern.
     *
     * @param pattern the pattern to register the handler for.
     * @param handler the handler.
     */
    public void register(final String pattern, final HttpRequestHandler handler) {
        Args.notNull(pattern, "URI request pattern");
        Args.notNull(handler, "Request handler");
        httpRequestHandlerRegistry.register(pattern, handler);
    }

    /**
     * Removes registered handler, if exists, for the given pattern.
     *
     * @param pattern the pattern to unregister the handler for.
     */
    public void unregister(final String pattern) {
        httpRequestHandlerRegistry.unregister(pattern);
    }

    /**
     * Sets handlers from the given map.
     * @param map the map containing handlers keyed by their URI patterns.
     */
    public void setHandlers(final Map<String, HttpRequestHandler> map) {
        httpRequestHandlerRegistry.setHandlers(map);
    }

    /**
     * Get the handler map.
     * @return The map of handlers and their associated URI patterns.
     *
     * @since 4.2
     */
    public Map<String, HttpRequestHandler> getHandlers() {
        return httpRequestHandlerRegistry.getHandlers();
    }

    public HttpRequestHandler lookup(final String requestURI) {
        HttpRequestHandler httpRequestHandler = httpRequestHandlerRegistry.lookup(requestURI);
        if(httpRequestHandler != null){
            return httpRequestHandler;
        }
        return noMatchHttpRequestHandler;
    }

}
