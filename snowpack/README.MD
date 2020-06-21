aws dynamodb list-tables --endpoint-url http://localhost:8000

aws dynamodb scan --table-name Snotel --endpoint-url http://localhost:8000
aws dynamodb scan --table-name BasinLocations --endpoint-url http://localhost:8000