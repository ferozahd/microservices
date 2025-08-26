# Dockerize 
```dockerfile 
docker build -t configuration-server .
```
```dockerfile
docker compose up -d
```


## Test the configuration server
`To test the configuration server we have to call http request to featch the configurati9on`

```json
//{HOST}/sales/dev => to get the sales configuration
//http://localhost:8888/sales/dev

{
  "name": "sales",
  "profiles": [
    "dev"
  ],
  "label": null,
  "version": null,
  "state": null,
  "propertySources": [
    {
      "name": "classpath:/config/sales-dev.yml",
      "source": {
        "spring.datasource.url": "jdbc:postgresql://localhost:5432/sales",
        "spring.datasource.username": "myuser",
        "spring.datasource.password": "mypassword",
        "spring.datasource.driver-class-name": "org.postgresql.Driver"
      }
    }
  ]
}
```
## CURL test
```
curl --location --request GET 'http://localhost:8888/sales/dev' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' 
```
### like wise we can test other services
* Payment
* Restaurants