

# SimilarCasesRequest

Request for ML-based similar case matching. Finds historical incidents similar to the current case based on indicators, behaviors, and TTPs.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicators** | **List&lt;String&gt;** | List of indicators (IPs, domains, hashes, URLs) associated with the current case. This is the primary matching criteria. |  |
|**behaviorDescription** | **String** | Free-text description of observed malicious behavior or incident details. Improves matching accuracy by considering behavioral patterns. |  [optional] |
|**observedTTPs** | **List&lt;String&gt;** | Observed MITRE ATT&amp;CK technique IDs. Helps find cases with similar attack techniques. See https://attack.mitre.org for reference. |  [optional] |
|**minSimilarity** | **Double** | Minimum similarity score threshold (0.0 to 1.0). Higher values return fewer but more precise matches. Default: 0.5 |  [optional] |
|**limit** | **Integer** | Maximum number of similar cases to return. Higher limits may increase processing time. |  [optional] |



