

# SimilarCasesRequest

Request for ML-based similar case matching

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicators** | **List&lt;String&gt;** | List of indicators for the current case |  |
|**behaviorDescription** | **String** | Description of observed behavior |  [optional] |
|**observedTTPs** | **List&lt;String&gt;** | Observed MITRE ATT&amp;CK TTPs |  [optional] |
|**minSimilarity** | **Double** | Confidence threshold for matches (0-1) |  [optional] |
|**limit** | **Integer** | Maximum number of similar cases to return |  [optional] |



