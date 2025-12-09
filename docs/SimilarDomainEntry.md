

# SimilarDomainEntry

A single similar domain entry with its detection technique

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The similar domain name. For homoglyph/IDN domains, may include punycode in parentheses. |  |
|**technique** | [**TechniqueEnum**](#TechniqueEnum) | The similarity detection technique that found this domain |  |



## Enum: TechniqueEnum

| Name | Value |
|---- | -----|
| TYPO | &quot;TYPO&quot; |
| UTFVARS | &quot;UTFVARS&quot; |
| TLD_VARIANTS | &quot;TLD_VARIANTS&quot; |
| SOUNDING | &quot;SOUNDING&quot; |
| PREFIX | &quot;PREFIX&quot; |
| SUFFIX | &quot;SUFFIX&quot; |
| CONTAINS | &quot;CONTAINS&quot; |
| LEVENSHTEIN | &quot;LEVENSHTEIN&quot; |



