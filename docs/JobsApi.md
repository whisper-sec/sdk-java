# JobsApi

All URIs are relative to *https://api.whisper.security*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getJob**](JobsApi.md#getJob) | **GET** /v1/ops/jobs/{jobId} | Get Asynchronous Job Status and Results |
| [**listJobs**](JobsApi.md#listJobs) | **GET** /v1/ops/jobs/list | List Recent Jobs |



## getJob

> Job getJob(jobId)

Get Asynchronous Job Status and Results

&lt;p&gt;Retrieves the current status and results of an asynchronous job. Poll this endpoint to check job progress.&lt;/p&gt; &lt;h4&gt;Polling Recommendations:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;For fast jobs (e.g., similar domains), poll every 1-2 seconds.&lt;/li&gt;     &lt;li&gt;For slow jobs (e.g., WHOIS search, screenshots), poll every 5-10 seconds.&lt;/li&gt;     &lt;li&gt;Implement an exponential backoff strategy for very long-running jobs.&lt;/li&gt;     &lt;li&gt;Stop polling when the status is &#x60;COMPLETED&#x60;, &#x60;FAILED&#x60;, or &#x60;CANCELLED&#x60;.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Job Statuses:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;PENDING:&lt;/b&gt; Job is queued and waiting to start.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;PROCESSING:&lt;/b&gt; Job is actively being processed.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;COMPLETED:&lt;/b&gt; Job finished successfully, results are available.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;FAILED:&lt;/b&gt; Job failed with an error.&lt;/li&gt;     &lt;li&gt;&lt;b&gt;CANCELLED:&lt;/b&gt; Job was cancelled by user or system.&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Result Schemas by Job Type:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;ai-investigate:&lt;/b&gt; InvestigateResult - verdict, timeline, analysis, recommendations&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-pivot:&lt;/b&gt; PivotResult - related indicators, investigation paths, relationship graph&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-attribute:&lt;/b&gt; AttributeResult - actor identification, campaign clustering, TTP mapping&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-correlate:&lt;/b&gt; CorrelateResult - prevalence, industry breakdown, co-occurrence&lt;/li&gt;     &lt;li&gt;&lt;b&gt;ai-similar-cases:&lt;/b&gt; SimilarCasesResult - similar cases with similarity scores&lt;/li&gt;     &lt;li&gt;&lt;b&gt;screenshot:&lt;/b&gt; ScreenshotResult - screenshot URL, ID, capture time, metadata&lt;/li&gt; &lt;/ul&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.JobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        JobsApi apiInstance = new JobsApi(defaultClient);
        String jobId = "f6250320-9ed4-442b-a389-acfda52d9375"; // String | The unique ID of the job, returned from a `POST` operation.
        try {
            Job result = apiInstance.getJob(jobId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#getJob");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **jobId** | **String**| The unique ID of the job, returned from a &#x60;POST&#x60; operation. | |

### Return type

[**Job**](Job.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Job status and results retrieved successfully. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |
| **404** | Job ID not found. |  -  |


## listJobs

> JobListResponse listJobs(status, limit, offset)

List Recent Jobs

&lt;p&gt;Retrieves a list of recent jobs for the authenticated user, optionally filtered by status.&lt;/p&gt; &lt;h4&gt;Query Parameters:&lt;/h4&gt; &lt;ul&gt;     &lt;li&gt;&lt;b&gt;status:&lt;/b&gt; Filter by job status (PENDING, PROCESSING, COMPLETED, FAILED, CANCELLED)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;limit:&lt;/b&gt; Maximum number of jobs to return (default: 50, max: 100)&lt;/li&gt;     &lt;li&gt;&lt;b&gt;offset:&lt;/b&gt; Number of jobs to skip for pagination (default: 0)&lt;/li&gt; &lt;/ul&gt; &lt;h4&gt;Response Format:&lt;/h4&gt; &lt;p&gt;Returns a JSON object with a \&quot;jobs\&quot; array containing job summaries.&lt;/p&gt; 

### Example

```java
// Import classes:
import io.github.whispersec.ApiClient;
import io.github.whispersec.ApiException;
import io.github.whispersec.Configuration;
import io.github.whispersec.auth.*;
import io.github.whispersec.models.*;
import io.github.whispersec.api.JobsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.whisper.security");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        JobsApi apiInstance = new JobsApi(defaultClient);
        String status = "status_example"; // String | Filter by job status
        Integer limit = 50; // Integer | Maximum number of jobs to return
        Integer offset = 0; // Integer | Number of jobs to skip
        try {
            JobListResponse result = apiInstance.listJobs(status, limit, offset);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling JobsApi#listJobs");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **status** | **String**| Filter by job status | [optional] |
| **limit** | **Integer**| Maximum number of jobs to return | [optional] [default to 50] |
| **offset** | **Integer**| Number of jobs to skip | [optional] [default to 0] |

### Return type

[**JobListResponse**](JobListResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully retrieved job list. |  -  |
| **401** | Authentication failed. Missing or invalid API key. |  -  |

