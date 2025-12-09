package io.github.whispersec.api;

import io.github.whispersec.ApiClient;

import io.github.whispersec.model.ChangeTrackingRequest;
import io.github.whispersec.model.ChangeTrackingResponse;
import io.github.whispersec.model.ErrorResponse;
import io.github.whispersec.model.GenericSuccessResponse;
import io.github.whispersec.model.JobResponse;
import io.github.whispersec.model.TrackedIndicatorsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-12-09T22:14:53.714678089Z[Etc/UTC]", comments = "Generator version: 7.17.0")
public class ChangeTrackingApi {
    private ApiClient apiClient;

    public ChangeTrackingApi() {
        this(new ApiClient());
    }

    public ChangeTrackingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ChangeTrackingResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getChangesRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling getChanges", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling getChanges", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "since", since));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ChangeTrackingResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ChangeTrackingResponse> getChanges(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return getChangesRequestCreation(type, value, since).bodyToMono(localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ResponseEntity&lt;ChangeTrackingResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<ChangeTrackingResponse>> getChangesWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        ParameterizedTypeReference<ChangeTrackingResponse> localVarReturnType = new ParameterizedTypeReference<ChangeTrackingResponse>() {};
        return getChangesRequestCreation(type, value, since).toEntity(localVarReturnType);
    }

    /**
     * Get Detected Changes
     * &lt;p&gt;Retrieve detected changes for a tracked indicator. Returns the current tracking configuration, baseline snapshot, and list of all detected changes.&lt;/p&gt; &lt;h4&gt;Response Includes:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;tracking:&lt;/b&gt; Current tracking configuration (enabled, frequency, fields, next check)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;baseline:&lt;/b&gt; The stored baseline snapshot data&lt;/li&gt;     &lt;li&gt;&lt;b&gt;changes:&lt;/b&gt; Array of detected changes with timestamps, old/new values&lt;/li&gt;     &lt;li&gt;&lt;b&gt;totalChanges:&lt;/b&gt; Total number of changes detected&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>200</b> - Successfully retrieved changes.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param since ISO 8601 timestamp to get changes from
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec getChangesWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable String since) throws WebClientResponseException {
        return getChangesRequestCreation(type, value, since);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @return TrackedIndicatorsResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listTrackedIndicatorsRequestCreation() throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<TrackedIndicatorsResponse> localVarReturnType = new ParameterizedTypeReference<TrackedIndicatorsResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @return TrackedIndicatorsResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<TrackedIndicatorsResponse> listTrackedIndicators() throws WebClientResponseException {
        ParameterizedTypeReference<TrackedIndicatorsResponse> localVarReturnType = new ParameterizedTypeReference<TrackedIndicatorsResponse>() {};
        return listTrackedIndicatorsRequestCreation().bodyToMono(localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @return ResponseEntity&lt;TrackedIndicatorsResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<TrackedIndicatorsResponse>> listTrackedIndicatorsWithHttpInfo() throws WebClientResponseException {
        ParameterizedTypeReference<TrackedIndicatorsResponse> localVarReturnType = new ParameterizedTypeReference<TrackedIndicatorsResponse>() {};
        return listTrackedIndicatorsRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * List Tracked Indicators
     * &lt;p&gt;Get a list of all indicators currently being tracked for changes by the authenticated user.&lt;/p&gt; 
     * <p><b>200</b> - List of tracked indicators.
     * <p><b>401</b> - Authentication failed.
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec listTrackedIndicatorsWithResponseSpec() throws WebClientResponseException {
        return listTrackedIndicatorsRequestCreation();
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>400</b> - Invalid indicator type or fields.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec startChangeTrackingRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        Object postBody = changeTrackingRequest;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'changeTrackingRequest' is set
        if (changeTrackingRequest == null) {
            throw new WebClientResponseException("Missing the required parameter 'changeTrackingRequest' when calling startChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>400</b> - Invalid indicator type or fields.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return JobResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<JobResponse> startChangeTracking(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest).bodyToMono(localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>400</b> - Invalid indicator type or fields.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return ResponseEntity&lt;JobResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<JobResponse>> startChangeTrackingWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        ParameterizedTypeReference<JobResponse> localVarReturnType = new ParameterizedTypeReference<JobResponse>() {};
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest).toEntity(localVarReturnType);
    }

    /**
     * Start Change Tracking
     * &lt;p&gt;Start tracking changes for an IP or domain. When tracking is started, a baseline snapshot is captured. Subsequent checks will compare against this baseline and record any detected changes.&lt;/p&gt; &lt;h4&gt;Trackable Fields for Domains:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;dns:&lt;/b&gt; A, AAAA, MX, NS, TXT, CNAME records&lt;/li&gt;     &lt;li&gt;&lt;b&gt;whois:&lt;/b&gt; Registrant, registrar, dates, nameservers&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ssl:&lt;/b&gt; Certificate issuer, expiry, SAN&lt;/li&gt;     &lt;li&gt;&lt;b&gt;subdomains:&lt;/b&gt; Discovered subdomains&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ips:&lt;/b&gt; Resolved IP addresses&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Trackable Fields for IPs:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;geolocation:&lt;/b&gt; Country, city, coordinates&lt;/li&gt;     &lt;li&gt;&lt;b&gt;asn:&lt;/b&gt; ASN number, organization&lt;/li&gt;     &lt;li&gt;&lt;b&gt;routing:&lt;/b&gt; BGP routing status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;rpki:&lt;/b&gt; RPKI validation status&lt;/li&gt;     &lt;li&gt;&lt;b&gt;reverse_dns:&lt;/b&gt; PTR records&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Frequencies:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;hourly:&lt;/b&gt; Check every hour&lt;/li&gt;     &lt;li&gt;&lt;b&gt;daily:&lt;/b&gt; Check once per day (default)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;weekly:&lt;/b&gt; Check once per week&lt;/li&gt; &lt;/ul&gt; 
     * <p><b>202</b> - Tracking started. Job ID returned for baseline capture.
     * <p><b>400</b> - Invalid indicator type or fields.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type: ip or domain
     * @param value Indicator value (IP address or domain name)
     * @param changeTrackingRequest Tracking configuration
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec startChangeTrackingWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nonnull ChangeTrackingRequest changeTrackingRequest) throws WebClientResponseException {
        return startChangeTrackingRequestCreation(type, value, changeTrackingRequest);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>200</b> - Tracking stopped successfully.
     * <p><b>401</b> - Authentication failed.
     * <p><b>500</b> - Internal server error.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @return GenericSuccessResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec stopChangeTrackingRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling stopChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling stopChangeTracking", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "deleteHistory", deleteHistory));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>200</b> - Tracking stopped successfully.
     * <p><b>401</b> - Authentication failed.
     * <p><b>500</b> - Internal server error.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @return GenericSuccessResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GenericSuccessResponse> stopChangeTracking(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return stopChangeTrackingRequestCreation(type, value, deleteHistory).bodyToMono(localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>200</b> - Tracking stopped successfully.
     * <p><b>401</b> - Authentication failed.
     * <p><b>500</b> - Internal server error.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @return ResponseEntity&lt;GenericSuccessResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GenericSuccessResponse>> stopChangeTrackingWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return stopChangeTrackingRequestCreation(type, value, deleteHistory).toEntity(localVarReturnType);
    }

    /**
     * Stop Change Tracking
     * &lt;p&gt;Stop tracking changes for an indicator. Optionally delete all change history.&lt;/p&gt; 
     * <p><b>200</b> - Tracking stopped successfully.
     * <p><b>401</b> - Authentication failed.
     * <p><b>500</b> - Internal server error.
     * @param type Indicator type: ip or domain
     * @param value Indicator value
     * @param deleteHistory Delete change history as well
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec stopChangeTrackingWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value, @jakarta.annotation.Nullable Boolean deleteHistory) throws WebClientResponseException {
        return stopChangeTrackingRequestCreation(type, value, deleteHistory);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>400</b> - Invalid indicator type.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type
     * @param value Indicator value
     * @return GenericSuccessResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec triggerCheckRequestCreation(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new WebClientResponseException("Missing the required parameter 'type' when calling triggerCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'value' is set
        if (value == null) {
            throw new WebClientResponseException("Missing the required parameter 'value' when calling triggerCheck", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("type", type);
        pathParams.put("value", value);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return apiClient.invokeAPI("/v1/ops/tracking/{type}/{value}/check", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>400</b> - Invalid indicator type.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type
     * @param value Indicator value
     * @return GenericSuccessResponse
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<GenericSuccessResponse> triggerCheck(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return triggerCheckRequestCreation(type, value).bodyToMono(localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>400</b> - Invalid indicator type.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type
     * @param value Indicator value
     * @return ResponseEntity&lt;GenericSuccessResponse&gt;
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<ResponseEntity<GenericSuccessResponse>> triggerCheckWithHttpInfo(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        ParameterizedTypeReference<GenericSuccessResponse> localVarReturnType = new ParameterizedTypeReference<GenericSuccessResponse>() {};
        return triggerCheckRequestCreation(type, value).toEntity(localVarReturnType);
    }

    /**
     * Trigger Immediate Check
     * &lt;p&gt;Trigger an immediate check for changes on a tracked indicator. Creates a job to compare current data against the stored baseline.&lt;/p&gt; 
     * <p><b>202</b> - Check triggered successfully.
     * <p><b>400</b> - Invalid indicator type.
     * <p><b>404</b> - Indicator is not being tracked.
     * <p><b>401</b> - Authentication failed.
     * @param type Indicator type
     * @param value Indicator value
     * @return ResponseSpec
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec triggerCheckWithResponseSpec(@jakarta.annotation.Nonnull String type, @jakarta.annotation.Nonnull String value) throws WebClientResponseException {
        return triggerCheckRequestCreation(type, value);
    }
}
