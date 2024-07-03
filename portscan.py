import requests
import ipaddress
def scan_http(ip,port,timeout):
    
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(timeout)
        
        # Attempt to connect to the IP and port
        result = sock.connect_ex((ip, port))
        if result == 0:
            # If connected, try to receive the banner
            banner = sock.recv(1024).decode().strip()
            port80 = requests.get(f"http://{ip}")
            port443 = request.get(f"https://{ip}")
            print(port80.text)
            print(port443.text)
            return f"IP: {ip}, Port: {port} is open. Banner: {banner}"
        else:
            return f"IP: {ip}, Port: {port} is closed."
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