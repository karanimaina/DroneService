# DroneService
# BAKERY PRODUCT  REST API application

The REST API to the bakery product  application  is described below.

## Create a new product

### Request 

    'POST http://localhost:8087/api/v1/dronecreate/'
    
    
    curl -i -H 'Accept: application/json' -d 
    "serialNo":"123456",
    "model":"LightWeight",
    "weightLimit":40.45,
    "batteryPercentage":50,
    "state":"IDLE"
    


### Response

    HTTP/1.1 201 Created
    Date: 2022-11-27T08 http://localhost:8087/api/v1/dronecreate/:40         "serialNo":"123456",
    "model":"LightWeight",
    "weightLimit":40.45,
    "batteryPercentage":50,
    "state":"IDLE":01.759+00:00
    Status: 201 Created
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 36
    
    {
    "status": 201,
    "data": {
    "id": 1,
    "serialNo":"123456",
    "model":"LightWeight",
    "weightLimit":40.45,
    "batteryPercentage":50,
    "state":"IDLE"
    },
    "message": "drone created"
}



## Add product details to product
### Request

   `POST  http://localhost:8087/api/v1/dronecreate/`

    curl -i -H 'Accept: application/json' -d 
    "droneId":1,
    "medicineId":"your partner in cake prooduction",
   


### Response

    HTTP/1.1 201 Created
    Date: 2022-11-27T08:40:01.759+00:00
    Status: 201 Created
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 36
    
    {
    "status": 201,
    "data": {
        "id": 1,
        "medicine: {
        "id : 1"
        },
        "count": 10 ,
        "delivery": {
        "drone":{
         "id":1,
         "deliveryStatus : "LOADING",
         "loadWeight" :200
        },
        "postedDate": "2022-11-27T08:40:01.759+00:00"
    },
    "message": "Drone Loaded"
}



## Get All Products

### Request 

    GET  http://localhost:8087/api/v1//available/drone  curl -i -H 'Accept: application/json '    

### Response

    HTTP/1.1 200 OK
    Date: 2022-11-27T08:40:01.759+00:0
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    Content-Length: 2
    
    {
    "status": 200
 "data": {
    "id": 1,
    "serialNo":"123456",
    "model":"LightWeight",
    "weightLimit":40.45,
    "batteryPercentage":50,
    "state":"IDLE"
    "postedDate": "2022-11-27T08:40:01.759+00:00"
        }
    ],
    "message": "drone  retrieved successfully"
}


#
##   License

Copyright (c) 2022 Felix Maina

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
