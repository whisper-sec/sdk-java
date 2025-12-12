

# CorrelateRequest

Request for cross-customer indicator correlation analysis

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicators** | **List&lt;String&gt;** | List of indicators (IPs, domains, hashes) to correlate across global threat intelligence. Maximum 100 indicators per request. |  |
|**options** | [**CorrelateOptions**](CorrelateOptions.md) | Optional configuration object for correlation analysis. NOT a string - must be an object with fields like timeWindow, minConfidence, etc. |  [optional] |



