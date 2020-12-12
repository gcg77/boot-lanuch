# boot lanuch 使用swagger创建API文档


<a name="overview"></a>
## 概览

### 版本信息
*版本* : 1.0.0


### 联系方式
*名字* : 郭晨刚


### URI scheme
*域名* : localhost:8888  
*基础路径* : /


### 标签

* ajax-response-controller : Ajax Response Controller




<a name="paths"></a>
## 资源

<a name="ajax-response-controller_resource"></a>
### Ajax-response-controller
Ajax Response Controller


<a name="addbookusingpost"></a>
#### addBook
```
POST /book
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**bookInfo**  <br>*必填*|bookInfo|[BookInfo](#bookinfo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBase](#responsebase)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/book
```


###### 请求 body
```
json :
{
  "auto" : "string",
  "date" : "string",
  "id" : 0,
  "money" : "string",
  "read" : {
    "age" : "string",
    "name" : "string"
  },
  "remark" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="updatebookusingput"></a>
#### updateBook
```
PUT /book
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**bookInfo**  <br>*必填*|bookInfo|[BookInfo](#bookinfo)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBase](#responsebase)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/book
```


###### 请求 body
```
json :
{
  "auto" : "string",
  "date" : "string",
  "id" : 0,
  "money" : "string",
  "read" : {
    "age" : "string",
    "name" : "string"
  },
  "remark" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="deletebookusingdelete"></a>
#### deleteBook
```
DELETE /book
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**id**  <br>*必填*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBase](#responsebase)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/book
```


###### 请求 query
```
json :
{
  "id" : 0
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="findbookoneusingget"></a>
#### findBookOne
```
GET /book/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[ResponseBase](#responsebase)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/book/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="bookinfo"></a>
### BookInfo

|名称|说明|类型|
|---|---|---|
|**auto**  <br>*可选*|**样例** : `"string"`|string|
|**date**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|**样例** : `0`|integer (int32)|
|**money**  <br>*可选*|**样例** : `"string"`|string|
|**read**  <br>*可选*|**样例** : `"[readinfo](#readinfo)"`|[ReadInfo](#readinfo)|
|**remark**  <br>*可选*|**样例** : `"string"`|string|


<a name="readinfo"></a>
### ReadInfo

|名称|说明|类型|
|---|---|---|
|**age**  <br>*可选*|**样例** : `"string"`|string|
|**name**  <br>*可选*|**样例** : `"string"`|string|


<a name="responsebase"></a>
### ResponseBase

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `"string"`|string|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**isok**  <br>*可选*|**样例** : `true`|boolean|
|**message**  <br>*可选*|**样例** : `"string"`|string|





