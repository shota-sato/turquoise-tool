
Windowspowershellの場合
```
Invoke-RestMethod -Uri "http://localhost:8080/products" `
  -Method Post `
  -Body '{"id": "1", "name": "Sample", "price": 100}' `
  -ContentType "application/json"
```

PowerShellでのcurl
```
 curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": "1", "name": "Sample", "price": 100}'
```

index取得
```
http://localhost:8080/products/1
```


