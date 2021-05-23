apiurl='http://localhost:8080/api'
authorization='Authorization: Bearer pxeyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDcxODIwNTksImV4cCI6MTYwNzE4OTI1OSwidXNlcklkIjo1LCJlbWFpbCI6ImZyZWVAdGVzdG1haWwuY29tIiwiZmlyc3ROYW1lIjoiRnJlZSIsImxhc3ROYW1lIjoiQ29kZSJ9.CDTE_lAz7iCLtxsfmCweKA3-6m7pff2Q1glUn'
content_type='Content-Type: application/json'

# Add products
curl --location --request POST "${apiurl}/products" \
  --header "${authorization}" \
  --header "${content_type}" \
  --data-raw '{
    "name": "Big TV",
    "price": 10000.00,
    "quantity": 1
  }'

curl --location --request POST "${apiurl}/products" \
  --header "${authorization}" \
  --header "${content_type}" \
  --data-raw '{
    "name": "Small TV",
    "price": 1000.00,
    "quantity": 10
  }'

curl --location --request POST "${apiurl}/products" \
  --header "${authorization}" \
  --header "${content_type}" \
  --data-raw '{
    "name": "Jeans",
    "price": 100.00,
    "quantity": 100
  }'

curl --location --request POST "${apiurl}/products" \
  --header "${authorization}" \
  --header "${content_type}" \
  --data-raw '{
    "name": "Bubblegum",
    "price": 1.00,
    "quantity": 1000
  }'

# Add users
curl --location --request POST "${apiurl}/users/register" \
  --header "${authorization}" \
  --header "${content_type}" \
  --data-raw '{
    "firstname": "Dragan",
    "lastname": "Nikolic",
    "email": "dn@test.com",
    "password": "pera123"
  }'
