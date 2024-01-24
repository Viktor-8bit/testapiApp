#### GetAllPC

Url  
http://localhost:5160/api/pc/GetAllPC

Json
```json
[
	{
		"id":1,
		"hostname":"AmogusPC",
		"online":false
	},
	{
		"id":2,
		"hostname":"DESKTOP-050E4JN",
		"online":true
	},
	{
		"id":3,
			"hostname":"WIN-8PJNE1C8M8J",
		"online":true
	}
]
```
#### InfoPc

Url
http://localhost:5160/api/pc/InfoPc/{hostname}

json с DESKTOP-050E4JN http://localhost:5160/api/pc/InfoPc/DESKTOP-050E4JN
```json
{
	"id":2,
	"hostname":"DESKTOP-050E4JN",
	"online":true
}
```
### Process

#### GetAllProcessActionDate

url http://localhost:5160/api/process/GetAllProcessActionDate/{hostname}

json с DESKTOP-050E4JN  http://localhost:5160/api/process/GetAllProcessActionDate/DESKTOP-050E4JN
```json
[
	"2024-01-01T23:58:44.80835",
	"2024-01-01T23:58:54.904135",
	"2024-01-01T23:58:59.964726",
	"2024-01-01T23:59:05.009494",
	"2024-01-01T23:59:20.121889",
	"2024-01-01T23:59:25.168886",
	"2024-01-01T23:59:30.22662",
	"2024-01-01T23:59:35.284998",
	"2024-01-01T23:59:40.344305",
	"2024-01-02T00:08:58.844407",
	"2024-01-02T00:09:08.94082",
	"2024-01-02T00:09:19.023026",
	"2024-01-02T00:09:29.120042",
	"2024-01-02T00:09:34.18115",
	"2024-01-02T00:09:39.311177",
	"2024-01-02T00:09:44.382417",
	"2024-01-02T00:09:49.618473",
	"2024-01-02T00:09:54.776454",
	"2024-01-02T00:10:04.879164",
	"2024-01-02T00:10:14.979824",
	"2024-01-02T00:10:20.029744",
	"2024-01-02T00:10:25.073272"
]
```

#### GetProcessesByDate

url http://localhost:5160/api/process/GetProcessesByDate/{hostname}/{date}

json c DESKTOP-050E4JN и 2024-01-02T00:08:58.844407 http://localhost:5160/api/process/GetProcessesByDate/DESKTOP-050E4JN/2024-01-02T00:08:58.844407
```json
[
	{"name":"Idle","processId":0,"date":"2024-01-02T00:08:43.547258"},
	{"name":"System","processId":4,"date":"2024-01-02T00:08:43.547258"},
	{"name":"Secure System","processId":104,"date":"2024-01-02T00:08:43.547258"},
	{"name":"Registry","processId":180,"date":"2024-01-02T00:08:43.547258"},
	{"name":"smss","processId":580,"date":"2024-01-02T00:08:43.547258"},

<---------------------------------------------------------------------------------->

	{"name":"iisexpresstray","processId":18540,"date":"2024-01-02T00:08:43.547258"},
	{"name":"SearchProtocolHost","processId":13920,"date":"2024-01-02T00:08:43.547258"},
	{"name":"SearchFilterHost","processId":25644,"date":"2024-01-02T00:08:43.547258"},
	{"name":"dotnet","processId":16220,"date":"2024-01-02T00:08:43.547258"},
	{"name":"conhost","processId":21344,"date":"2024-01-02T00:08:43.547258"},
	{"name":"winpty-agent","processId":26480,"date":"2024-01-02T00:08:43.547258"},
	{"name":"conhost","processId":16908,"date":"2024-01-02T00:08:43.547258"},
	{"name":"JetBrains.DPA.Runner","processId":20640,"date":"2024-01-02T00:08:43.547258"},
	{"name":"SpyAppVer0.0.1","processId":4356,"date":"2024-01-02T00:08:43.547258"}]
```
