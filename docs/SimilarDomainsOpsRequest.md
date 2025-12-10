

# SimilarDomainsOpsRequest

Request for generating similar/lookalike domains for brand protection

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The target domain to generate variations for |  |
|**techniques** | **String** | Techniques to use for generating similar domains. Supported values: typosquatting, homoglyph, bitsquatting, tld_variation, sounding, prefix, suffix, contains, levenshtein. If not specified, defaults to typosquatting. |  [optional] |
|**limit** | **Integer** | Maximum number of similar domains to return per technique |  [optional] |
|**options** | **Object** |  |  [optional] |



