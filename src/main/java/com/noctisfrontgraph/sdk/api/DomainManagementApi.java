package com.noctisfrontgraph.sdk.api;

import com.noctisfrontgraph.sdk.invoker.ApiClient;

import com.noctisfrontgraph.sdk.model.DomainerStringListResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-09-15T11:53:44.371328345Z[Etc/UTC]", comments = "Generator version: 7.13.0")
public class DomainManagementApi {
    private ApiClient apiClient;

    public DomainManagementApi() {
        this(new ApiClient());
    }

    @Autowired
    public DomainManagementApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * Find subdomains
     * Finds domains that are subdomains of the given base domain (e.g., finding &#39;www.example.com&#39; for base &#39;example.com&#39;). Allows filtering by absolute domain level (dot count). NOTE: This differs from relative depth filtering.
     * <p><b>200</b> - Subdomains found
     * <p><b>400</b> - Invalid base domain name
     * @param baseDomain Base domain name (e.g., example.com)
     * @param limit Maximum number of results
     * @param level Level of subdomains to find relative to the base domain (ALL, IMMEDIATE&#x3D;one level deeper, MAX_DEPTH&#x3D;deepest found relative to base).
     * @return DomainerStringListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec findSubdomainsRequestCreation(@javax.annotation.Nonnull String baseDomain, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String level) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'baseDomain' is set
        if (baseDomain == null) {
            throw new WebClientResponseException("Missing the required parameter 'baseDomain' when calling findSubdomains", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("baseDomain", baseDomain);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "level", level));
        
        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<DomainerStringListResponse> localVarReturnType = new ParameterizedTypeReference<DomainerStringListResponse>() {};
        return apiClient.invokeAPI("/domainer/api/domains/subdomains/{baseDomain}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Find subdomains
     * Finds domains that are subdomains of the given base domain (e.g., finding &#39;www.example.com&#39; for base &#39;example.com&#39;). Allows filtering by absolute domain level (dot count). NOTE: This differs from relative depth filtering.
     * <p><b>200</b> - Subdomains found
     * <p><b>400</b> - Invalid base domain name
     * @param baseDomain Base domain name (e.g., example.com)
     * @param limit Maximum number of results
     * @param level Level of subdomains to find relative to the base domain (ALL, IMMEDIATE&#x3D;one level deeper, MAX_DEPTH&#x3D;deepest found relative to base).
     * @return DomainerStringListResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<DomainerStringListResponse> findSubdomains(@javax.annotation.Nonnull String baseDomain, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String level) throws WebClientResponseException {
        ParameterizedTypeReference<DomainerStringListResponse> localVarReturnType = new ParameterizedTypeReference<DomainerStringListResponse>() {};
        return findSubdomainsRequestCreation(baseDomain, limit, level).bodyToMono(localVarReturnType);
    }

    /**
     * Find subdomains
     * Finds domains that are subdomains of the given base domain (e.g., finding &#39;www.example.com&#39; for base &#39;example.com&#39;). Allows filtering by absolute domain level (dot count). NOTE: This differs from relative depth filtering.
     * <p><b>200</b> - Subdomains found
     * <p><b>400</b> - Invalid base domain name
     * @param baseDomain Base domain name (e.g., example.com)
     * @param limit Maximum number of results
     * @param level Level of subdomains to find relative to the base domain (ALL, IMMEDIATE&#x3D;one level deeper, MAX_DEPTH&#x3D;deepest found relative to base).
     * @return ResponseEntity&lt;DomainerStringListResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<DomainerStringListResponse>> findSubdomainsWithHttpInfo(@javax.annotation.Nonnull String baseDomain, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String level) throws WebClientResponseException {
        ParameterizedTypeReference<DomainerStringListResponse> localVarReturnType = new ParameterizedTypeReference<DomainerStringListResponse>() {};
        return findSubdomainsRequestCreation(baseDomain, limit, level).toEntity(localVarReturnType);
    }

    /**
     * Find subdomains
     * Finds domains that are subdomains of the given base domain (e.g., finding &#39;www.example.com&#39; for base &#39;example.com&#39;). Allows filtering by absolute domain level (dot count). NOTE: This differs from relative depth filtering.
     * <p><b>200</b> - Subdomains found
     * <p><b>400</b> - Invalid base domain name
     * @param baseDomain Base domain name (e.g., example.com)
     * @param limit Maximum number of results
     * @param level Level of subdomains to find relative to the base domain (ALL, IMMEDIATE&#x3D;one level deeper, MAX_DEPTH&#x3D;deepest found relative to base).
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec findSubdomainsWithResponseSpec(@javax.annotation.Nonnull String baseDomain, @javax.annotation.Nullable Integer limit, @javax.annotation.Nullable String level) throws WebClientResponseException {
        return findSubdomainsRequestCreation(baseDomain, limit, level);
    }
}
