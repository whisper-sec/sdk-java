

# IndicatorResponse

Comprehensive intelligence response for an IP address or domain indicator

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | [**QueryInfo**](QueryInfo.md) | Query metadata including the indicator type, value, and response timing |  [optional] |
|**summary** | [**SummaryInfo**](SummaryInfo.md) | Executive summary with key facts about the indicator for quick decision-making |  [optional] |
|**geolocation** | **Object** |  |  [optional] |
|**network** | **Object** |  |  [optional] |
|**routing** | **Object** |  |  [optional] |
|**isp** | **Object** |  |  [optional] |
|**registration** | **Object** |  |  [optional] |
|**dns** | [**DnsInfo**](DnsInfo.md) | DNS records and resolution data |  [optional] |
|**relationships** | [**RelationshipInfo**](RelationshipInfo.md) | Relationship data showing connections to other infrastructure |  [optional] |
|**reputation** | [**ReputationInfo**](ReputationInfo.md) | Reputation and risk scoring information |  [optional] |
|**security** | **Object** |  |  [optional] |
|**rpki** | **Object** |  |  [optional] |
|**ipIntelligence** | **Map&lt;String, Object&gt;** | When domain is queried with include&#x3D;ip_intelligence, contains full intelligence for each resolved IP |  [optional] |
|**metadata** | [**MetadataInfo**](MetadataInfo.md) | Response metadata including data sources, errors, and processing information |  [optional] |



