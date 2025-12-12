

# AttributeRequest

Request for threat actor attribution and campaign clustering

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**indicators** | **List&lt;String&gt;** | List of indicators (IPs, domains, hashes, URLs) for attribution analysis. Maximum 500 indicators per request. |  |
|**context** | [**AttributionContext**](AttributionContext.md) | Optional context object to enhance attribution accuracy. NOT a string - must be an object with fields like observedTTPs, targetedSector, etc. |  [optional] |



