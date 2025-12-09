

# GraphNode

A node in the infrastructure graph representing a domain, IP, ASN, or other entity

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier for the node (typically the domain name, IP address, or ASN) |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of infrastructure element this node represents |  [optional] |
|**label** | **String** | Human-readable label for display (may differ from id) |  [optional] |
|**properties** | **Map&lt;String, Object&gt;** | Additional properties for node styling or filtering |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| DOMAIN_NAME | &quot;DomainName&quot; |
| IP_ADDRESS | &quot;IpAddress&quot; |
| ASN | &quot;ASN&quot; |
| NAMESERVER | &quot;Nameserver&quot; |
| MAIL_SERVER | &quot;MailServer&quot; |
| NETWORK | &quot;Network&quot; |
| CERTIFICATE | &quot;Certificate&quot; |



