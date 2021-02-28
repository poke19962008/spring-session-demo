# Search Application v2.0

In the service class which you will have to integrate with an external apache Solr service running at <ip>:8983. Solr API contract will look like this:

```
[GET] /solr/productCollection/browse?q=Samsung
```

Following API will respond with many unwanted fields, out which you have extract the following relevant fields only:

- isInStock
- salePrice
- Description
- mediumImage

Your response should look like this in the left. Use feign client to communicate your app to external Solr service
