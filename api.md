# API Doc
Spezifikationen zu den Operationen die durch die Sockets übertragen werden.

## Client to Server
```json
{
"op" : "CREATE_COMP",
"userid" : "int",
"data" : {
    "name" : "String",
    "type" : "ENUM"
    }
}
```

```json
{
  "op" : "BUY_WARE",
  "userid" : "int",
  "data" : {
    "offerId" : "int",
    "qantity" : "int"
  }
}
```

```json
{
  "op" : "SELL_WARE",
  "userid" : "int",
  "data" : {
    "storeageId" : "int",
    "qantity" : "int"
  }
}
```

```json
{
  "op" : "END_ROUND",
  "userid" : "int",
  "data" : { }
}
```

## Server to Client
```json
{
  "op" : "UPDATE_MARKET",
  "userid" : "null",
  "data" : {
    "offerId" : "int",
    "newQantity" : "int"
  }
}
```

```json
{
  "op" : "UPDATE_STOREAGE",
  "userid" : "int",
  "data" : {
    "storeageId" : "int",
    "newQantity" : "int"
  }
}
```



Diese Liste wird ggf noch erweitert.
