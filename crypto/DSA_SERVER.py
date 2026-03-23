import socket
import ssl
import pickle

def modinv(a, m):
    def egcd(a, b):
        if a == 0:
            return b, 0, 1
        gcd, x1, y1 = egcd(b % a, a)
        return gcd, y1 - (b // a) * x1, x1
    gcd, x, _ = egcd(a, m)
    return x % m

def simple_hash(message):
    return sum(message.encode()) % 1000

def verify(message, signature, p, q, g, y):
    r, s = signature
    if not (0 < r < q and 0 < s < q):
        return False
    H = simple_hash(message)
    w = modinv(s, q)
    u1 = (H * w) % q
    u2 = (r * w) % q
    v = ((pow(g, u1, p) * pow(y, u2, p)) % p) % q
    return v == r

p = 809
q = 101
g = pow(2, (p - 1)//q, p)

y = int(input("Enter client's public key: "))

context = ssl.SSLContext(ssl.PROTOCOL_TLS_SERVER)
context.load_cert_chain(certfile="server.crt", keyfile="server.key")

server_socket = socket.socket()
server_socket.bind(('localhost', 4444))
server_socket.listen(1)

print("Server waiting for connection...")

conn, addr = server_socket.accept()
secure_conn = context.wrap_socket(conn, server_side=True)

data = secure_conn.recv(4096)
message, signature = pickle.loads(data)

print("Received:", message)

if verify(message, signature, p, q, g, y):
    print("Signature Verified")
else:
    print("Invalid Signature")

secure_conn.close()
