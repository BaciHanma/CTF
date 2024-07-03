import requests
import ipaddress
def scan_http(ip,port,timeout):
    
    try:
        port80 = requests.get(f"http://{ip}")
        port443 = requests.get(f"https://{ip}")
        if port80.status_code in ["200","301","302"]:
             print(port80.text)
        if port443.status_code in ["200","301","302"]:
             print(port443.text)
    except Exception as e:
            return f"IP: {ip}, Port: {port} scanning failed. Error: {str(e)}"
    finally:
        sock.close()
def main():
    # Define the IP range
    ip_range = ipaddress.ip_network('10.54.10.0/24')
    
    # Iterate over all IPs in the range
    for ip in ip_range.hosts():
        result = scan_http(str(ip),80,2)
        print(result)

if __name__ == "__main__":
    main()