import psycopg2

hostname = 'localhost'
db = 'e_comentario'
usuario = 'postgres'
senha = 'desceproplay123'
porta = 5432
connection = None
cur = None

try:
    connection = psycopg2.connect(
        host = hostname,
        dbname = db,
        user = usuario,
        password = senha,
        port = porta)

    def queryGetAllCategoria():
        cur = connection.cursor()
        cur.execute('SELECT * FROM categoria')
        resp = cur.fetchall()
        return resp

    def queryGetAllProdutos():
        cur = connection.cursor()
        cur.execute('SELECT * FROM produtos')
        resp = cur.fetchall()
        return resp

    connection.commit()

except Exception as error:
    print(error)
    if cur is not None:  
            cur.close()
    if connection is not None:
        connection.close()