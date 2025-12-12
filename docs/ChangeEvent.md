

# ChangeEvent

A single detected change event

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timestamp** | **OffsetDateTime** | When the change was detected |  [optional] |
|**field** | **String** | Field that changed (dot notation, e.g., &#39;dns.a_record&#39;) |  [optional] |
|**oldValue** | **Object** |  |  [optional] |
|**newValue** | **Object** |  |  [optional] |
|**category** | **String** | Category of the change (dns, whois, ssl, etc.) |  [optional] |
|**severity** | **String** | Severity of the change: low, medium, high |  [optional] |



