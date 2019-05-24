# RIdeHire
How to run:
Add Application configuration as:
1. BookRide as Main Class
2. server /config.yaml as program arguments. 

Server will run on port 9000

Api to get Drivers list as per requireement:

```
POST /book-ride/v1/get-drivers HTTP/1.1
Host: 127.0.0.1:9000
Content-Type: application/json
cache-control: no-cache
body:
{
"latitude": 3.0,
"longitude": 4.0,
"radius": 4.0
}
```

Result: List of drivers within the specified radius of User location.
