

# SubdomainResponse

Response containing discovered subdomains and related metadata

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**domain** | **String** | The root domain that was queried |  |
|**totalCount** | **Integer** | Total number of subdomains discovered |  |
|**subdomains** | [**List&lt;SubdomainInfo&gt;**](SubdomainInfo.md) | List of discovered subdomains |  |
|**timestamp** | **OffsetDateTime** | Timestamp of when the data was retrieved |  |
|**sources** | **List&lt;String&gt;** | Data sources used for subdomain discovery |  [optional] |



