import random


def modinv(a, m):
    def egcd(a, b):
        if a == 0:
            return b, 0, 1
        gcd, x1, y1 = egcd(b % a, a)
        x = y1 - (b // a) * x1
        y = x1
        return gcd, x, y

    gcd, x, _ = egcd(a, m)
    if gcd != 1:
        raise Exception("Modular inverse does not exist")
    return x % m


def is_prime(n):

    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True



def generate_params():
    
    q = 101
    p = 809  

    h = 2
    g = pow(h, (p - 1) // q, p)

    return p, q, g


def generate_keys(p, q, g):
    x = random.randint(1, q - 1)   
    y = pow(g, x, p)             
    return x, y


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
        if s == 0:
            continue

        return (r, s)


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

p, q, g = generate_params()
x, y = generate_keys(p, q, g)

message = "Hello!"

signature = sign(message, p, q, g, x)
print("Signature:", signature)

valid = verify(message, signature, p, q, g, y)
print("Valid Signature?", valid)
