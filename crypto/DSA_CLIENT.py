import socket
import ssl
import pickle
import random

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

def sign(message, p, q, g, x):
    H = simple_hash(message)
    while True:
        k = random.randint(1, q - 1)
        r = pow(g, k, p) % q
        if r == 0:
            continue
        k_inv = modinv(k, q)
        s = (k_inv * (H + x * r)) % q
        if s != 0:
            return (r, s)


p = 809
q = 101
g = pow(2, (p - 1)//q, p)


x = random.randint(1, q - 1)
y = pow(g, x, p)

print("Share this public key with server:", y)

message = input("Enter message: ")
signature = sign(message, p, q, g, x)

context = ssl.create_default_context()

sock = socket.socket()
secure_sock = context.wrap_socket(sock, server_hostname='localhost')

secure_sock.connect(('localhost', 4444))

data = pickle.dumps((message, signature))
secure_sock.send(data)

secure_sock.close()
