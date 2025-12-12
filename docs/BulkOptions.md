

# BulkOptions

Advanced configuration options for bulk processing including batch size, timeouts, and error handling.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**parallelProcessing** | **Boolean** | Enable parallel processing of indicators for faster results |  [optional] |
|**batchSize** | **Integer** | Number of indicators to process in each batch. Smaller batches &#x3D; more frequent progress updates |  [optional] |
|**timeoutPerIndicator** | **Integer** | Maximum time in milliseconds to wait for each indicator before timing out. Domain enrichment and ip_intelligence require longer timeouts. |  [optional] |
|**continueOnError** | **Boolean** | Continue processing remaining indicators if one fails. Recommended for large batches. |  [optional] |
|**includeFailed** | **Boolean** | Include failed indicators in the response with error details |  [optional] |



