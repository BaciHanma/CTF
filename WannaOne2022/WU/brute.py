import requests
for a in ("m","M"):
    for b in ("v","V"):
        for c in ("y","Y"):
            for d in ("d","D"):
                url = "https://pastebin.com/raw/"+a+"0"+b+"3"+c+d+"43"
                print(url)
                res = requests.get(url=url)
                if "Not Found" not in res.text:
                    print(res.text)  
                    exit(0)              