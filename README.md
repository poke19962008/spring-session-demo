# Search Application v3.0

Modify your /search API to support location based search. You request body will look like this 
```json
{"searchTerm": "samsung", "location": "Jakarta"}
```

In your response ”products” will be the same as before, ”locationBaseProducts” will be your location search and you can get the data from here​

```
[GET] /solr/productCollection/select? q=stockLocation:”Jakarta”
```
