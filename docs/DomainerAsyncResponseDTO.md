

# DomainerAsyncResponseDTO

Response object for an asynchronous domain similarity search request submission

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**requestId** | **UUID** | Unique identifier for tracking the request |  [readonly] |
|**domainName** | **String** | Domain name being searched |  [readonly] |
|**queryString** | **String** | Query string submitted for free-text search (if applicable) |  [optional] [readonly] |
|**message** | **String** | Status message providing information about the request |  [readonly] |
|**statusUrl** | **URI** | URL to check for results (can be polled to monitor progress and get results) |  [readonly] |



