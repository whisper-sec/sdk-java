

# IndicatorResponse

Comprehensive intelligence response for an IP address or domain indicator

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**query** | [**QueryInfo**](QueryInfo.md) |  |  [optional] |
|**summary** | [**SummaryInfo**](SummaryInfo.md) |  |  [optional] |
|**geolocation** | **Object** |  |  [optional] |
|**network** | **Object** |  |  [optional] |
|**routing** | **Object** |  |  [optional] |
|**isp** | **Object** |  |  [optional] |
|**registration** | **Object** |  |  [optional] |
|**dns** | [**DnsInfo**](DnsInfo.md) |  |  [optional] |
|**relationships** | [**RelationshipInfo**](RelationshipInfo.md) |  |  [optional] |
|**reputation** | [**ReputationInfo**](ReputationInfo.md) |  |  [optional] |
|**security** | **Object** |  |  [optional] |
|**rpki** | **Object** |  |  [optional] |
|**ipIntelligence** | **Map&lt;String, Object&gt;** | When domain is queried with include&#x3D;ip_intelligence, contains full intelligence for each resolved IP |  [optional] |
|**metadata** | [**MetadataInfo**](MetadataInfo.md) |  |  [optional] |



