# Search Application v1.0

Create a new branch from master branch which have the spring boot application boiler plate. You new branch will be “search-application-v1”.

Create an POST API /search whose request body will look like this

```json
{"searchTerm": "samsung"}
```

Create a service class and return dummy response shown in left from your service. Your response will look like this:
```json 
{
  "products": [ 
    {
      "name": "samsung glaxy s5",
      "description": "some description",
      "price": 12345,
      "inStock": true
    }, {
      "name": "samsung glaxy s6",
      "description": "some description",
      "price": 123,
      "inStock": false
    }
    
  ]
}
```
