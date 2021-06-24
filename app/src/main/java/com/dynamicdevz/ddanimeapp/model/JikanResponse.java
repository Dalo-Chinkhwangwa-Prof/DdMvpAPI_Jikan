
package com.dynamicdevz.ddanimeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JikanResponse {

    @SerializedName("request_hash")
    @Expose
    private String requestHash;
    @SerializedName("request_cached")
    @Expose
    private boolean requestCached;
    @SerializedName("request_cache_expiry")
    @Expose
    private int requestCacheExpiry;
    @SerializedName("results")
    @Expose
    private List<JikanResult> jikanResults = null;
    @SerializedName("last_page")
    @Expose
    private int lastPage;

    public String getRequestHash() {
        return requestHash;
    }

    public void setRequestHash(String requestHash) {
        this.requestHash = requestHash;
    }

    public boolean isRequestCached() {
        return requestCached;
    }

    public void setRequestCached(boolean requestCached) {
        this.requestCached = requestCached;
    }

    public int getRequestCacheExpiry() {
        return requestCacheExpiry;
    }

    public void setRequestCacheExpiry(int requestCacheExpiry) {
        this.requestCacheExpiry = requestCacheExpiry;
    }

    public List<JikanResult> getResults() {
        return jikanResults;
    }

    public void setResults(List<JikanResult> jikanResults) {
        this.jikanResults = jikanResults;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

}
