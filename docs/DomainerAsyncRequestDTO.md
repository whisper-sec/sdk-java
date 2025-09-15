

# DomainerAsyncRequestDTO

Parameters for an asynchronous domain search (either similarity or free-text)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domainName** | **String** | (Required for SIMILARITY requests) Domain name to search for similar domains |  [optional] |
|**similarityType** | [**SimilarityTypeEnum**](#SimilarityTypeEnum) | (Required for SIMILARITY requests) Type of similarity to use: CONTAINS, SOUNDING, PREFIX, SUFFIX, TYPO, UTFVARS |  [optional] |
|**queryString** | **String** | (Required for SEARCH requests) Query string (supports standard query syntax) |  [optional] |
|**operator** | [**OperatorEnum**](#OperatorEnum) | (Optional for SEARCH requests) Default operator between query terms if not specified |  [optional] |
|**level** | [**LevelEnum**](#LevelEnum) | (Optional for SEARCH requests) Filter results by absolute domain level (dot count) |  [optional] |
|**findAvailable** | **Boolean** | Set to true to find AVAILABLE similar domains (typo/sounding) instead of existing ones. Requires domainName, ignores similarityType/queryString/operator/level. |  [optional] |
|**limit** | **Integer** | Maximum number of results to return (use a reasonable limit to prevent excessive processing) |  [optional] |
|**callbackUrl** | **URI** | URL to call with results when the search is complete (must be accessible from the server) |  |



## Enum: SimilarityTypeEnum

| Name | Value |
|---- | -----|
| CONTAINS | &quot;CONTAINS&quot; |
| PREFIX | &quot;PREFIX&quot; |
| SUFFIX | &quot;SUFFIX&quot; |
| TYPO | &quot;TYPO&quot; |
| SOUNDING | &quot;SOUNDING&quot; |
| UTFVARS | &quot;UTFVARS&quot; |
| TLD_VARIANTS | &quot;TLD_VARIANTS&quot; |
| TYPO_OR_SOUNDING | &quot;TYPO_OR_SOUNDING&quot; |
| LEVENSHTEIN | &quot;LEVENSHTEIN&quot; |
| CONTAINS2 | &quot;CONTAINS&quot; |
| SOUNDING2 | &quot;SOUNDING&quot; |
| PREFIX2 | &quot;PREFIX&quot; |
| SUFFIX2 | &quot;SUFFIX&quot; |
| TYPO2 | &quot;TYPO&quot; |
| UTFVARS2 | &quot;UTFVARS&quot; |



## Enum: OperatorEnum

| Name | Value |
|---- | -----|
| AND | &quot;AND&quot; |
| OR | &quot;OR&quot; |



## Enum: LevelEnum

| Name | Value |
|---- | -----|
| ALL | &quot;ALL&quot; |
| IMMEDIATE | &quot;IMMEDIATE&quot; |
| MAX_DEPTH | &quot;MAX_DEPTH&quot; |



