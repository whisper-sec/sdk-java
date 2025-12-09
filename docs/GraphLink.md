

# GraphLink

A link/edge connecting two nodes in the infrastructure graph

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**source** | **String** | ID of the source node (where the relationship originates) |  [optional] |
|**target** | **String** | ID of the target node (where the relationship points to) |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of relationship between the nodes |  [optional] |
|**weight** | **Double** | Weight or strength of the relationship (for layout algorithms) |  [optional] |
|**properties** | **Map&lt;String, Object&gt;** | Additional properties for link styling or filtering |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| RESOLVES_TO | &quot;resolvesTo&quot; |
| HAS_NAMESERVER | &quot;hasNameserver&quot; |
| HAS_MAIL_HOST | &quot;hasMailHost&quot; |
| HAS_DOMAIN_PARENT | &quot;hasDomainParent&quot; |
| SAME_ASN | &quot;sameASN&quot; |
| SAME_NETWORK | &quot;sameNetwork&quot; |
| SAME_CERTIFICATE | &quot;sameCertificate&quot; |
| SAME_REGISTRANT | &quot;sameRegistrant&quot; |
| LINKS_TO | &quot;linksTo&quot; |
| REDIRECTS_TO | &quot;redirectsTo&quot; |
| CONTAINS | &quot;contains&quot; |



