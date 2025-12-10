

# CypherQueryResponse

Response from executing a Cypher query against the graph database.  Contains the query results as a list of records, along with execution metadata including timing and column information. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**results** | **List&lt;Map&lt;String, Object&gt;&gt;** | Query results as a list of records. Each record is a map of column name to value. |  [optional] |
|**executionTimeMs** | **Long** | Query execution time in milliseconds |  [optional] |
|**rowCount** | **Integer** | Number of rows returned |  [optional] |
|**columns** | **List&lt;String&gt;** | Column names in the result set |  [optional] |
|**truncated** | **Boolean** | Whether the result was truncated due to limit |  [optional] |
|**error** | **String** | Error message if the query failed |  [optional] |



