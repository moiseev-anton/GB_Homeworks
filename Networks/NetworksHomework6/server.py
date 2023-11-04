import socket
import threading

host = '127.0.0.1'
port = 55555

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host, port))
server.listen()

# Заменил массивы на словарь
clients = {}

# Добавил проверку чтобы сообщение не отправлялось самому отправителю
def broadcast(message, sender=None):
    for client in clients.keys():
        if client != sender:
            client.send(message)


def handle(client):
    while True:
        try:
            message = client.recv(1024)
            broadcast(message, client)
        except:
            nickname = clients.pop[client]
            client.close()
            broadcast('{} left!'.format(nickname))
            break

def receive():
    while True:
        client, address = server.accept()
        print("Connected with {}".format(str(address)))

        client.send('NICK'.encode('ascii'))
        nickname = client.recv(1024).decode('ascii')
        clients[client] = nickname

        print("Nickname is {}".format(nickname))
        broadcast("{} joined!".format(nickname).encode('ascii'), client)
        client.send('Connected to server!'.encode('ascii'))

        thread = threading.Thread(target=handle, args=(client,))
        thread.start()

print("Server if listening...")
receive()

