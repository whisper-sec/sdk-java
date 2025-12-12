

# GraphResponse

Graph visualization data showing relationships between infrastructure elements. Format is compatible with react-force-graph, vis.js, cytoscape.js, and similar libraries.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodes** | [**List&lt;GraphNode&gt;**](GraphNode.md) | List of nodes (vertices) in the graph. Each node represents an infrastructure element. |  [optional] |
|**links** | [**List&lt;GraphLink&gt;**](GraphLink.md) | List of links (edges) connecting nodes. Each link represents a relationship between elements. |  [optional] |
|**totalNodes** | **Integer** | Total count of nodes before any limit was applied |  [optional] |
|**totalLinks** | **Integer** | Total count of links before any limit was applied |  [optional] |



